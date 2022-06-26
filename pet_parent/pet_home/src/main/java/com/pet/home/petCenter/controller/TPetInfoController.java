package com.pet.home.petCenter.controller;


import com.pet.home.common.ResponseVo;
import com.pet.home.petCenter.entity.TPetInfo;
import com.pet.home.petCenter.service.TPetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 宠物领养信息控制器
 *
 * @author miller.ou
 * @since 2021-08-26
 */
@RestController
@RequestMapping("/petInfo")
public class TPetInfoController {

	@Autowired
	private TPetInfoService tPetInfoService;

	@PostMapping("/add")
	public ResponseVo addPetInfo(@RequestBody TPetInfo tPetInfo) {
		boolean save = tPetInfoService.save(tPetInfo);
		if (save) {
			return ResponseVo.ok().data("id", tPetInfo.getId());
		}
		return ResponseVo.error();
	}

	@DeleteMapping("{id}")
	public boolean deletePetInfo(@PathVariable Integer id) {
		return tPetInfoService.removeById(id);
	}

	@PostMapping("update")
	public ResponseVo updatePetInfo(@RequestBody TPetInfo tPetInfo) {
		return ResponseVo.ok();
	}

}

