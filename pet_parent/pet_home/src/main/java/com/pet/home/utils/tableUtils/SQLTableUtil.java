package com.pet.home.utils.tableUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 数据库建表工具类
 *
 * @author xieh 2019/11/27
 */
public class SQLTableUtil {

	//private String mysql = "MYSQL";
	//private String mssql = "MSSQL";
	//private String oracle = "ORACLE";
	//private String psql = "PSQL";

	/**
	 * MySQL数据库创建表SQL语句生成
	 *
	 * @param listSqlFiled
	 * @return
	 */
	public static String createMYSQL(List<Map<String, String>> listSqlFiled) {
		if (listSqlFiled != null && listSqlFiled.size() > 0) {
			List<String> priKeyArray = new ArrayList<String>();// 主键集合
			StringBuilder sqlStr = new StringBuilder();
			// 获取第一个map，存在表名
			Map<String, String> mapFirst = listSqlFiled.get(0);
			/*int countMapFirst = 0;// 控制第一行的表名和表注释遍历次数
			for(Map.Entry<String, String> entry:mapFirst.entrySet()){
				if(countMapFirst == 0){
					sqlStr.append("DROP TABLE IF EXISTS `"+ entry.getValue() +"`;\n");
					sqlStr.append("CREATE TABLE `"+ entry.getValue() +"` (\n");
				}

			}*/
			sqlStr.append("DROP TABLE IF EXISTS `" + mapFirst.get("c0") + "`;\n");
			sqlStr.append("CREATE TABLE `" + mapFirst.get("c0") + "` (\n");

			int length = listSqlFiled.size();
			// 遍历list集合
			for (int i = 1; i < length; i++) {
				// 遍历map集合
				Map<String, String> map = listSqlFiled.get(i);
				if (map.size() == 0) {// 此处判断不准确，最好的办法就是把excle表的底部多余的行右键删除掉
					System.out.println("SQL语句不准确，请把excle表底部多余的行右键删除掉！");
					continue;
				}
				sqlStr.append("`" + map.get("c1") + "`\t " + map.get("c2") + "\t");
				// 是否为主键并且主键不能为空
				if (map.get("c3").equalsIgnoreCase("Y")) {
					priKeyArray.add(map.get("c1"));
					sqlStr.append("NOT NULL COMMENT '" + map.get("c5") + "',\n");
					//表示结束了到最后一行了，并且只有一个主键
					if (i >= length - 1 && priKeyArray.size() == 1) {// 只有一个主键时
						sqlStr.append("PRIMARY KEY (`" + priKeyArray.get(0) + "`)\n");
						sqlStr.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
						// 表示到最后一行了，并且存在多个主键
					} else if (i >= length - 1 && priKeyArray.size() > 1) {// 多个主键时
						sqlStr.append("PRIMARY KEY (");
						// 遍历主键
						for (int k = 0; k < priKeyArray.size(); k++) {
							// 到最后一个主键时
							if (k == priKeyArray.size() - 1) {
								sqlStr.append("`" + priKeyArray.get(k) + "`) USING BTREE \n");
							} else {
								sqlStr.append("`" + priKeyArray.get(k) + "`,");
							}
						}
						sqlStr.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
					}

					// 非主键，直接判断是否允许为空
				} else {
					// 表示没有主键，并且到最后一个了
					if (priKeyArray.size() <= 0 && i >= length - 1) {
						if (map.get("c4").equalsIgnoreCase("Y")) {// 允许为空
							sqlStr.append("DEFAULT NULL COMMENT '" + map.get("c5") + "'\n");
						} else {
							sqlStr.append("NOT NULL COMMENT '" + map.get("c5") + "'\n");
						}
						sqlStr.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8;");

						// 表示有主键，并且是到最后一行了
					} else if (priKeyArray.size() > 0 && i >= length - 1) {
						if (map.get("c4").equalsIgnoreCase("Y")) {// 允许为空
							sqlStr.append("DEFAULT NULL COMMENT '" + map.get("c5") + "',\n");
						} else {
							sqlStr.append("NOT NULL COMMENT '" + map.get("c5") + "',\n");
						}
						// 表示只有一个主键
						if (priKeyArray.size() == 1) {
							sqlStr.append("PRIMARY KEY (`" + priKeyArray.get(0) + "`)\n");
							sqlStr.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
							// 表示有多个主键
						} else {
							sqlStr.append("PRIMARY KEY (");
							// 遍历主键
							for (int k = 0; k < priKeyArray.size(); k++) {
								// 到最后一个主键时
								if (k == priKeyArray.size() - 1) {
									sqlStr.append("`" + priKeyArray.get(k) + "`) USING BTREE \n");
								} else {
									sqlStr.append("`" + priKeyArray.get(k) + "`,");
								}
							}
							sqlStr.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
						}

						// 没有到最后一行继续追加
					} else {
						if (map.get("c4").equalsIgnoreCase("Y")) {// 允许为空
							sqlStr.append("DEFAULT NULL COMMENT '" + map.get("c5") + "',\n");
						} else {
							sqlStr.append("NOT NULL COMMENT '" + map.get("c5") + "',\n");
						}
					}

				}//

			}// for end

			return sqlStr.toString();
		} else {
			return "";
		}
	}

	/**
	 * sqlserver数据库创建表SQL语句
	 *
	 * @param listSqlFiled
	 * @return
	 */
	public static String createMSSQL(List<Map<String, String>> listSqlFiled) {
		if (listSqlFiled != null && listSqlFiled.size() > 0) {
			StringBuilder sqlStr = new StringBuilder();
			// 获取第一个map，存在表名
			Map<String, String> mapFirst = listSqlFiled.get(0);
			sqlStr.append("IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[" + mapFirst.get("c0") + "]') AND type IN ('U'))\n");
			sqlStr.append("DROP TABLE [dbo].[" + mapFirst.get("c0") + "]\n");
			sqlStr.append("GO\n");
			sqlStr.append("CREATE TABLE " + mapFirst.get("c0") + " (\n");

			int length = listSqlFiled.size();
			// 遍历list集合：生成基本表结构阶段
			for (int i = 1; i < length; i++) {
				// 遍历map集合
				Map<String, String> map = listSqlFiled.get(i);
				if (map.size() == 0) {// 此处判断不准确，最好的办法就是把excle表的底部多余的行右键删除掉
					System.out.println("SQL语句不准确，请把excle表底部多余的行右键删除掉！");
					continue;
				}
				sqlStr.append("[" + map.get("c1") + "]\t " + map.get("c2") + "\t");
				// 是否为主键并且主键不能为空
				if (map.get("c3").equalsIgnoreCase("Y")) {
					if (i >= length - 1) {// 表示最后一个并且是主键
						sqlStr.append("primary key 	NOT NULL\n");
						sqlStr.append(")");
					} else {
						sqlStr.append("primary key 	NOT NULL ,\n");
					}

					// 非主键，直接判断是否允许为空
				} else {
					if (map.get("c4").equalsIgnoreCase("Y")) {// 允许为空
						if (i >= length - 1) {// 表示允许为空并且是最后一个
							sqlStr.append("DEFAULT NULL\n");
							sqlStr.append(")");
						} else {// 表示允许为空继续追加
							sqlStr.append("DEFAULT NULL ,\n");
						}
					} else {// 不允许为空
						if (i >= length - 1) {// 表示不允许为空并且是最后一个
							sqlStr.append("NOT NULL\n");
							sqlStr.append(")");
						} else {// 表示不允许为空继续追加
							sqlStr.append("NOT NULL ,\n");
						}
					}

				}//

			}// for end基本表结构生成完成

			// 开始追加注释阶段
			sqlStr.append("\n");
			for (int i = 1; i < length; i++) {
				Map<String, String> map = listSqlFiled.get(i);
				if (map.size() == 0) {// 此处判断不准确，最好的办法就是把excle表的底部多余的行右键删除掉
					System.out.println("SQL语句不准确，请把excle表底部多余的行右键删除掉！");
					continue;
				}
				sqlStr.append("EXEC sp_addextendedproperty\n");
				sqlStr.append("'MS_Description', N'" + map.get("c5") + "',\n");
				sqlStr.append("'SCHEMA', N'dbo',\n");
				sqlStr.append("'TABLE', N'" + mapFirst.get("c0") + "',\n");
				sqlStr.append("'COLUMN', N'" + map.get("c1") + "'\n");
				sqlStr.append("GO\n");
				sqlStr.append("\n");
			}
			return sqlStr.toString();
		} else {
			return "";
		}
	}


	/**
	 * Oracle数据创建表SQL语句
	 *
	 * @param listSqlFiled
	 * @param dbUserName
	 * @return
	 */
	public static String createORACLE(List<Map<String, String>> listSqlFiled, String dbUserName) {

		if (listSqlFiled != null && listSqlFiled.size() > 0) {
			List<String> priKeyArray = new ArrayList<String>();// 主键集合
			StringBuilder sqlStr = new StringBuilder();
			// 获取第一个map，存在表名
			Map<String, String> mapFirst = listSqlFiled.get(0);
			sqlStr.append("create table " + dbUserName + "." + mapFirst.get("c0") + "(\n");
			int length = listSqlFiled.size();
			// 遍历list集合
			for (int i = 1; i < length; i++) {
				// 遍历map集合
				Map<String, String> map = listSqlFiled.get(i);
				if (map.size() == 0) {// 此处判断不准确，最好的办法就是把excle表的底部多余的行右键删除掉
					System.out.println("SQL语句不准确，请把excle表底部多余的行右键删除掉！");
					continue;
				}
				sqlStr.append("" + map.get("c1") + "\t " + map.get("c2") + "\t");
				// 是否为主键并且主键不能为空
				if (map.get("c3").equalsIgnoreCase("Y")) {
					priKeyArray.add(map.get("c1"));
					sqlStr.append("NOT NULL,\n");
					//表示结束了到最后一行了，并且只有一个主键
					if (i >= length - 1 && priKeyArray.size() == 1) {// 只有一个主键时
						sqlStr.append("PRIMARY KEY (" + priKeyArray.get(0) + ")\n");
						sqlStr.append(");\n");
						// 表示到最后一行了，并且存在多个主键
					} else if (i >= length - 1 && priKeyArray.size() > 1) {// 多个主键时
						sqlStr.append("PRIMARY KEY (");
						// 遍历主键
						for (int k = 0; k < priKeyArray.size(); k++) {
							// 到最后一个主键时
							if (k == priKeyArray.size() - 1) {
								sqlStr.append("" + priKeyArray.get(k) + ")\n");
							} else {
								sqlStr.append("" + priKeyArray.get(k) + ",");
							}
						}
						sqlStr.append(");\n");
					}

					// 非主键，直接判断是否允许为空
				} else {
					// 表示没有主键，并且到最后一个了
					if (priKeyArray.size() <= 0 && i >= length - 1) {
						if (map.get("c4").equalsIgnoreCase("Y")) {// 允许为空
							sqlStr.append("\n");
						} else {
							sqlStr.append("NOT NULL\n");
						}
						sqlStr.append(");\n");

						// 表示有主键，并且是到最后一行了
					} else if (priKeyArray.size() > 0 && i >= length - 1) {
						if (map.get("c4").equalsIgnoreCase("Y")) {// 允许为空
							sqlStr.append(",\n");
						} else {
							sqlStr.append("NOT NULL,\n");
						}
						// 表示只有一个主键
						if (priKeyArray.size() == 1) {
							sqlStr.append("PRIMARY KEY (" + priKeyArray.get(0) + ")\n");
							sqlStr.append(");\n");
							// 表示有多个主键
						} else {
							sqlStr.append("PRIMARY KEY (");
							// 遍历主键
							for (int k = 0; k < priKeyArray.size(); k++) {
								// 到最后一个主键时
								if (k == priKeyArray.size() - 1) {
									sqlStr.append("" + priKeyArray.get(k) + ")\n");
								} else {
									sqlStr.append("" + priKeyArray.get(k) + ",");
								}
							}
							sqlStr.append(");\n");
						}

						// 没有到最后一行继续追加
					} else {
						if (map.get("c4").equalsIgnoreCase("Y")) {// 允许为空
							sqlStr.append(",\n");
						} else {
							sqlStr.append("NOT NULL,\n");
						}
					}

				}//

			}// for end

			sqlStr.append("\n");
			// 添加字段注释
			for (int i = 1; i < length; i++) {
				// 遍历map集合
				Map<String, String> map = listSqlFiled.get(i);
				if (map.size() == 0) {// 此处判断不准确，最好的办法就是把excle表的底部多余的行右键删除掉
					System.out.println("SQL语句不准确，请把excle表底部多余的行右键删除掉！");
					continue;
				}
				sqlStr.append("comment on column " + dbUserName + "." + mapFirst.get("c0") + "." + map.get("c1") + " is '" + map.get("c5") + "';\n");
			}
			return sqlStr.toString();
		} else {
			return "";
		}

	}


	/**
	 * PostgreSQL数据库创建表SQL语句
	 *
	 * @param listSqlFiled
	 * @return
	 */
	public static String createPSQL(List<Map<String, String>> listSqlFiled) {
		if (listSqlFiled != null && listSqlFiled.size() > 0) {
			List<String> priKeyArray = new ArrayList<String>();// 主键集合
			StringBuilder sqlStr = new StringBuilder();
			// 获取第一个map，存在表名
			Map<String, String> mapFirst = listSqlFiled.get(0);
			sqlStr.append("create table " + mapFirst.get("c0") + "(\n");
			int length = listSqlFiled.size();
			// 遍历list集合
			for (int i = 1; i < length; i++) {
				// 遍历map集合
				Map<String, String> map = listSqlFiled.get(i);
				if (map.size() == 0) {// 此处判断不准确，最好的办法就是把excle表的底部多余的行右键删除掉
					System.out.println("SQL语句不准确，请把excle表底部多余的行右键删除掉！");
					continue;
				}
				sqlStr.append("" + map.get("c1") + "\t " + map.get("c2") + "\t");
				// 是否为主键并且主键不能为空
				if (map.get("c3").equalsIgnoreCase("Y")) {
					priKeyArray.add(map.get("c1"));
					sqlStr.append("NOT NULL,\n");
					//表示结束了到最后一行了，并且只有一个主键
					if (i >= length - 1 && priKeyArray.size() == 1) {// 只有一个主键时
						sqlStr.append("PRIMARY KEY (" + priKeyArray.get(0) + ")\n");
						sqlStr.append(");\n");
						// 表示到最后一行了，并且存在多个主键
					} else if (i >= length - 1 && priKeyArray.size() > 1) {// 多个主键时
						sqlStr.append("PRIMARY KEY (");
						// 遍历主键
						for (int k = 0; k < priKeyArray.size(); k++) {
							// 到最后一个主键时
							if (k == priKeyArray.size() - 1) {
								sqlStr.append("" + priKeyArray.get(k) + ")\n");
							} else {
								sqlStr.append("" + priKeyArray.get(k) + ",");
							}
						}
						sqlStr.append(");\n");
					}

					// 非主键，直接判断是否允许为空
				} else {
					// 表示没有主键，并且到最后一个了
					if (priKeyArray.size() <= 0 && i >= length - 1) {
						if (map.get("c4").equalsIgnoreCase("Y")) {// 允许为空
							sqlStr.append("\n");
						} else {
							sqlStr.append("NOT NULL\n");
						}
						sqlStr.append(");\n");

						// 表示有主键，并且是到最后一行了
					} else if (priKeyArray.size() > 0 && i >= length - 1) {
						if (map.get("c4").equalsIgnoreCase("Y")) {// 允许为空
							sqlStr.append(",\n");
						} else {
							sqlStr.append("NOT NULL,\n");
						}
						// 表示只有一个主键
						if (priKeyArray.size() == 1) {
							sqlStr.append("PRIMARY KEY (" + priKeyArray.get(0) + ")\n");
							sqlStr.append(");\n");
							// 表示有多个主键
						} else {
							sqlStr.append("PRIMARY KEY (");
							// 遍历主键
							for (int k = 0; k < priKeyArray.size(); k++) {
								// 到最后一个主键时
								if (k == priKeyArray.size() - 1) {
									sqlStr.append("" + priKeyArray.get(k) + ")\n");
								} else {
									sqlStr.append("" + priKeyArray.get(k) + ",");
								}
							}
							sqlStr.append(");\n");
						}

						// 没有到最后一行继续追加
					} else {
						if (map.get("c4").equalsIgnoreCase("Y")) {// 允许为空
							sqlStr.append(",\n");
						} else {
							sqlStr.append("NOT NULL,\n");
						}
					}

				}//

			}// for end

			sqlStr.append("\n");
			// 添加字段注释
			for (int i = 1; i < length; i++) {
				// 遍历map集合
				Map<String, String> map = listSqlFiled.get(i);
				if (map.size() == 0) {// 此处判断不准确，最好的办法就是把excle表的底部多余的行右键删除掉
					System.out.println("SQL语句不准确，请把excle表底部多余的行右键删除掉！");
					continue;
				}
				sqlStr.append("comment on column " + mapFirst.get("c0") + "." + map.get("c1") + " is '" + map.get("c5") + "';\n");
			}
			return sqlStr.toString();
		} else {
			return "";
		}


	}


	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// 测试MySQL数据库
			List<Map<String, String>> excelXReadMYSQL = ExcelUtil.excelXRead("C:\\Users\\Lenovo\\Desktop\\临时文件\\tableUtils.xlsx", 7);
			System.out.println(createMYSQL(excelXReadMYSQL));

		/*		// 测试SQLSERVER数据库
			List<Map<String, String>> excelXReadMSSQL = ExcelUtil.excelXRead("F:/cs.xlsx",1);
			System.out.println(createMSSQL(excelXReadMSSQL));

			// 测试Oracle数据库
			List<Map<String, String>> excelXReadORCL = ExcelUtil.excelXRead("F:/cs.xlsx",2);
			System.out.println(createORACLE(excelXReadORCL, "SCOTT")); */

//			// 测试PostgreSQL数据库
//			List<Map<String, String>> excelXRead = ExcelUtil.excelXRead("F:/cs.xlsx",3);
//			System.out.println(createPSQL(excelXRead));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
