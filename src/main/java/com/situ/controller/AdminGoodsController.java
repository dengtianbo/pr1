package com.situ.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.global.Global;
import com.situ.model.Goods;
import com.situ.model.GoodsSearchBean;
import com.situ.service.GoodsService;

/**
 * 后端商品管理（增删改查）
 * @author 浅墨~~
 * @date  2021年12月29日
 */
@Controller
@RequestMapping("/admin")
public class AdminGoodsController {

	@Autowired
	private GoodsService service;
	
	@RequestMapping("/goods_list")
	public String list(Map<String, Object>map ,Integer pageNo, Integer pageSize, GoodsSearchBean gsb ) {
		System.out.println(gsb);
		if (pageNo == null || pageNo < 1) {
			pageNo = 1;
		}
		if (pageSize == null || pageSize == 0) {
			pageSize = 5;
		}

		PageHelper.startPage(pageNo, pageSize);
		
		List<Goods> list = service.findAllGoods(gsb);
		PageInfo<Goods> p =new PageInfo<>(list);

		Integer count = service.findCount(gsb);
		
		map.put("list", list);
		map.put("count", count);
		map.put("p", p);
		
		
		return "backstage/goods_list";
	}
	
	@GetMapping("/goods_add")
	public String gotoadd() {

		return "backstage/goods_add";
	}

	@PostMapping("/goods_add")
	public String gotoadd2(Map<String, Object> map, Goods goods,
			@RequestParam(name = "picture-pic") MultipartFile file) {
		System.out.println(goods);

		// 是否已经存在该商品
		Goods checkgoods = service.findUsername(goods);
		if (checkgoods != null) {
			System.out.println("该用户存在");
			map.put("error", "该用户存在");
			map.put("goods", goods);
			return "backstage/goods_add";
		}
		
		
		String uid = UUID.randomUUID().toString();// 保证不重复
		String originalName = file.getOriginalFilename();// 原始文件名
		System.out.println(originalName);
		int lidx = originalName.lastIndexOf(".");
		String ext = originalName.substring(lidx + 1);// 上传文件的扩展名
		// 用户可自定义位置
		String fullName = Global.UPLOAD_GOODS_PATH + "/" + uid + "." + ext;// 文件全名

		File target = new File(fullName);
		try {
			file.transferTo(target);
			goods.setPicture("/upload/image/goods/" + uid + "." + ext);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		

		boolean success = false;
		success = service.save(goods);
		if (success) {
			return "redirect:/admin/goods_list";
		} else {
			map.put("error", "您的操作出现异常，请检查后稍候再试，或联系管理员");
			map.put("goods", goods);
			return "backstage/goods_add";
		}

	}

	@GetMapping("/goods_edit")
	public String gotoedit(Integer id, Map<String, Object> map) {
		Goods goods = service.findById(id);

		if (goods != null) {
			map.put("goods", goods);
			return "backstage/goods_edit";
		} else {
			map.put("error", "沒有該用户");
			return "redirect:/admin/goods_list";
		}

	}

	@PostMapping("/goods_edit")
	public String gotoedit2(Map<String, Object> map, Goods goods,
			@RequestParam(name = "picture-pic") MultipartFile file) {
		System.out.println(goods);
		// 是否已经存在该用户
		Goods checkgoods =service.findUsername(goods);

		/**
		 * 修改后用户名冲突问题没有解决 可以设置用户名不变（不然密码就不知道了）
		 */
		if (checkgoods != null && !checkgoods.getName().equals(goods.getName())) {
			System.out.println("该用户存在");
			map.put("error", "该用户存在");
			map.put("goods", goods);
			return "backstage/goods_edit";
		}

		String uid = UUID.randomUUID().toString();// 保证不重复
		String originalName = file.getOriginalFilename();// 原始文件名
		System.out.println(originalName);
		int lidx = originalName.lastIndexOf(".");
		String ext = originalName.substring(lidx + 1);// 上传文件的扩展名
		// 用户可自定义位置
		String fullName = Global.UPLOAD_GOODS_PATH + "/" + uid + "." + ext;// 文件全名

		File target = new File(fullName);
		try {
			file.transferTo(target);
			goods.setPicture("/upload/image/goods/" + uid + "." + ext);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		boolean success = false;
		success = service.update(goods);
		if (success) {
			return "redirect:/admin/goods_list";
		} else {
			map.put("error", "您的操作出现异常，请检查后稍候再试，或联系管理员");
			map.put("goods", goods);
			return "backstage/goods_edit";
		}

	}

	/**
	 * 实现批量删除
	 * 
	 * @param ids
	 * @return
	 */
	@PostMapping(value = "/goodsdelete", produces = "application/json;charset=utf-8")
	@ResponseBody
	public Map<String, Object> delete(Integer[] ids) {

		System.out.println("+++++++");
		for (Integer integer : ids) {
			System.out.println(integer);
		}
		System.out.println("+++++++");
		Map<String, Object> resp = new HashMap<>();
		int rows = service.deleteByIds(ids);
		if (rows > 0) {
			resp.put("success", true);
			resp.put("rows", rows);
		} else {
			resp.put("success", false);
			resp.put("error", "删除数据时异常");
		}
		return resp;

	}
	
	
}
