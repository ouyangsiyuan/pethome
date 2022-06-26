package com.pet.home.utils.tableUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * excle工具类
 *
 * @author xieh 2019/11/24 使用的jar包是：poi-4.1.0.jar 和 poi-ooxml-4.1.0.jar
 *
 */
public class ExcelUtil {

	/**
	 * 读取excle内容：注意此方法不兼容.xlsx文件
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static List<Map<String, String>> excelRead() throws Exception {
		//用流的方式先读取到你想要的excel的文件
		//FileInputStream fis=new FileInputStream(new File(System.getProperty("user.dir")+"/src/excel.xls"));
		FileInputStream fis = new FileInputStream(new File("D:/a.xls"));
		// 解析excel
		POIFSFileSystem pSystem = new POIFSFileSystem(fis);
		// 获取整个excel
		HSSFWorkbook hb = new HSSFWorkbook(pSystem);
		System.out.println(hb.getNumCellStyles());
		// 获取第一个表单sheet
		HSSFSheet sheet = hb.getSheetAt(0);
		// 获取第一行
		int firstrow = sheet.getFirstRowNum();
		// 获取最后一行
		int lastrow = sheet.getLastRowNum();
		// 存取最后结果
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		// 循环行数依次获取列数
		for (int i = firstrow; i < lastrow + 1; i++) {
			// 获取哪一行i
			Row row = sheet.getRow(i);
			// 存放每行的键值对结果
			Map<String, String> tempMap = new HashMap<String, String>();
			if (row != null) {
				// 获取这一行的第一列
				int firstcell = row.getFirstCellNum();
				// 获取这一行的最后一列
				int lastcell = row.getLastCellNum();
				// 创建一个集合，用处将每一行的每一列数据都存入集合中
				//List<String> list = new ArrayList<String>();
				for (int j = firstcell; j < lastcell; j++) {
					// 获取第j列
					Cell cell = row.getCell(j);
					if (cell != null && !("").equals(cell.toString())) {
						//System.out.print(cell + "\t");
						//list.add(cell.toString());
						tempMap.put("c" + j, cell.toString().trim());
					}
				}
				// 存放每行的结果
				result.add(tempMap);
			}// row if end

		}// for end
		fis.close();
		System.out.println(result.toString());
		return result;
	}




	/**
	 * 此方法兼容.xls 和 .xlsx格式，建议使用
	 * @param path excle文件路径
	 * @param sheetIndex  excle文件的Sheet页的下标，从0开始
	 * @return excle表中的内容
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static List<Map<String, String>> excelXRead(String path,int sheetIndex) throws Exception {
		//用流的方式先读取到你想要的excel的文件
		//FileInputStream fis=new FileInputStream(new File(System.getProperty("user.dir")+"/src/excel.xls"));
		File excel = new File(path);
		String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义
		Workbook wb = null;
		FileInputStream  fis = null;

		//根据文件后缀（xls/xlsx）进行判断
		if ( "xls".equals(split[1])){
			fis = new FileInputStream(excel);   //文件流对象
			wb = new HSSFWorkbook(fis);

		}else if ("xlsx".equals(split[1])){
			wb = new XSSFWorkbook(OPCPackage.open(excel));

		}else {
			System.out.println("文件类型错误!");
			return new ArrayList<>();

		}
		//开始解析
		Sheet sheet = wb.getSheetAt(sheetIndex);     //读取sheet 0
		// 获取第一行
		int firstrow = sheet.getFirstRowNum() + 1; //第一行是列名，所以不读
		// 获取最后一行
		int lastrow = sheet.getLastRowNum();
		// 存取最后结果
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		// 循环行数依次获取列数
		for (int i = firstrow; i < lastrow + 1; i++) {
			// 获取哪一行i
			Row row = sheet.getRow(i);
			// 存放每行的键值对结果
			Map<String, String> tempMap = new HashMap<String, String>();
			if (row != null) {
				// 获取这一行的第一列
				int firstcell = row.getFirstCellNum();
				// 获取这一行的最后一列
				int lastcell = row.getLastCellNum();
				// 创建一个集合，用处将每一行的每一列数据都存入集合中
				//List<String> list = new ArrayList<String>();
				for (int j = firstcell; j < lastcell; j++) {
					// 获取第j列
					Cell cell = row.getCell(j);
					if (cell != null && !("").equals(cell.toString())) {
						//System.out.print(cell + "\t");
						//list.add(cell.toString());
						tempMap.put("c" + j, cell.toString().trim());
					}
				}
				// 存放每行的结果
				result.add(tempMap);
			}// row if end

		}// for end

		if(null != fis){
			fis.close();
		}
		System.out.println(result.toString());
		return result;
	}


	/**
	 * 创建和写入excle内容
	 * @param exportList 实体类list
	 * @param file 生成的文件路径
	 * @throws Exception
	 */
	public static void writeXls(List<Test> exportList, File file) throws Exception {

		String[] options = { "ID", "内容", "名字" };
		XSSFWorkbook book = new XSSFWorkbook();

		CreationHelper createHelper = book.getCreationHelper();

		XSSFCellStyle style = book.createCellStyle();
		XSSFCellStyle dateStyle = book.createCellStyle();
		XSSFDataFormat format = book.createDataFormat();
		style.setWrapText(true);
		dateStyle.setWrapText(true);

		XSSFSheet sheet = book.createSheet("sheet");

		sheet.setColumnWidth(3, 13000);
		sheet.setDefaultColumnWidth(20);

		XSSFRow firstRow = sheet.createRow(0);
		XSSFCell[] firstCells = new XSSFCell[3];

		CellStyle styleBlue = book.createCellStyle(); // 样式对象
		// 设置单元格的背景颜色为淡蓝色
		styleBlue.setWrapText(true);// 指定当单元格内容显示不下时自动换行

		Font font = book.createFont();
		//font.setBoldweight(Font.BOLDWEIGHT_BOLD);
		font.setFontName("宋体");
		font.setFontHeight((short) 280);
		style.setFont(font);
		dateStyle.setFont(font);
		dateStyle.setDataFormat(format.getFormat("yyyy-mm-dd"));
		styleBlue.setFont(font);

		for (int j = 0; j < options.length; j++) {
			firstCells[j] = firstRow.createCell(j);
			firstCells[j].setCellStyle(styleBlue);
			firstCells[j].setCellValue(new XSSFRichTextString(options[j]));
		}
		getExport(sheet, style, createHelper, exportList, dateStyle);
		if (file.exists()) {
			file.delete();
		}
		file.createNewFile();

		OutputStream os = new FileOutputStream(file);
		book.write(os);
		os.close();
	}






	/**
	 * excle实体数据写入
	 * @param sheet
	 * @param style
	 * @param createHelper
	 * @param exportList
	 * @param dateStyle
	 */
	private static void getExport(XSSFSheet sheet, XSSFCellStyle style, CreationHelper createHelper, List<Test> exportList,
	                              XSSFCellStyle dateStyle) {
		// 遍历实例类的list集合
		for (int i = 0; i < exportList.size(); i++) {
			// 创建行
			XSSFRow row = sheet.createRow(i + 1);

			// 实体类
			Test export = exportList.get(i);

			// 第一列
			XSSFCell hotelId = row.createCell(0);
			hotelId.setCellStyle(style);

			// 第二列
			XSSFCell hotelName = row.createCell(1);
			hotelName.setCellStyle(dateStyle);

			// 第三列
			XSSFCell chargeCount = row.createCell(2);
			chargeCount.setCellStyle(style);

			// 设置值
			hotelId.setCellValue(export.getId());
			hotelName.setCellValue("测试");
			chargeCount.setCellValue(export.getName());

			// ta.append("写入excel开始,行数是" + (i + 1) + "\n");
		}// for end

	}





	/**
	 * 测试
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			ExcelUtil.excelRead();
			ExcelUtil.excelXRead("D:/柱子.xlsx",0);
			ExcelUtil.excelXRead("D:/a.xls",0);
			List<Test> show = new ArrayList<Test>();
			Test test1 = new Test();
			test1.setId(1);
			test1.setName("xieh");

			Test test2 = new Test();
			test2.setId(2);
			test2.setName("xieh");
			show.add(test1);
			show.add(test2);
			ExcelUtil.writeXls(show, new File("D:/bbb.xls"));
			ExcelUtil.writeXls(show, new File("D:/aaa.xlsx"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}