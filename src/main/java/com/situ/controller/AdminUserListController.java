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
import com.situ.model.User;
import com.situ.model.UserSearchBean;
import com.situ.service.LoginService;
import com.situ.service.UserListService;

/**
 * 后端管理user表
 * 
 * @author 浅墨~~
 * @date 2021年12月27日
 */

@Controller
@RequestMapping("/admin")
public class AdminUserListController {

	@Autowired
	private UserListService service;
	@Autowired
	private LoginService loginService;

	@RequestMapping("/userlist")
	public String userlist(Map<String, Object> map, Integer pageNo, Integer pageSize, UserSearchBean usb) {
		System.out.println(usb);
		if (pageNo == null || pageNo < 1) {
			pageNo = 1;
		}
		if (pageSize == null || pageSize == 0) {
			pageSize = 5;
		}

		PageHelper.startPage(pageNo, pageSize);

		List<User> list = service.findAllUser(usb);
		PageInfo<User> p = new PageInfo<>(list);

		Integer count = service.findCount(usb);
//		for (User user : list) {
//			System.out.println(user);
//		}
		map.put("count", count);
		map.put("p", p);
		map.put("users", list);
		map.put("usb", usb);
		return "backstage/user_list";
	}

	@GetMapping("/useradd")
	public String gotoadd() {

		return "backstage/user_add";
	}

	@PostMapping("/useradd")
	public String gotoadd2(Map<String, Object> map, User user) {
		System.out.println(user);

		// 是否已经存在该用户
		User checkuser = loginService.findUsername(user);
		if (checkuser != null) {
			System.out.println("该用户存在");
			map.put("error", "该用户存在");
			map.put("user", user);
			return "backstage/user_add";
		}

		boolean success = false;
		success = service.save(user);
		if (success) {
			return "redirect:/admin/userlist";
		} else {
			map.put("error", "您的操作出现异常，请检查后稍候再试，或联系管理员");
			map.put("user", user);
			return "backstage/user_add";
		}

	}

	@GetMapping("/useredit")
	public String gotoedit(Integer id, Map<String, Object> map) {
		User user = service.findById(id);

		if (user != null) {
			map.put("user", user);
			return "backstage/user_edit";
		} else {
			map.put("error", "沒有該用户");
			return "redirect:/admin/userlist";
		}

	}

	@PostMapping("/useredit")
	public String gotoedit2(Map<String, Object> map, User user,
			@RequestParam(name = "portrait-pic") MultipartFile file) {
		
		System.out.println(user);
		// 是否已经存在该用户
		User checkuser = loginService.findUsername(user);

		/**
		 * 修改后用户名冲突问题没有解决 可以设置用户名不变（不然密码就不知道了）
		 */
		if (checkuser != null && !checkuser.getUsername().equals(user.getUsername())) {
			System.out.println("该用户存在");
			map.put("error", "该用户存在");
			map.put("user", user);
			return "backstage/user_edit";
		}

		String uid = UUID.randomUUID().toString();// 保证不重复
		String originalName = file.getOriginalFilename();// 原始文件名
		System.out.println(originalName);
		int lidx = originalName.lastIndexOf(".");
		String ext = originalName.substring(lidx + 1);// 上传文件的扩展名
		// 用户可自定义位置
		String fullName = Global.UPLOAD_PORTRAIT_PATH + "/" + uid + "." + ext;// 文件全名

		File target = new File(fullName);
		try {
			file.transferTo(target);
			user.setPortrait("/upload/image/portrait/" + uid + "." + ext);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		boolean success = false;
		success = service.update(user);
		if (success) {
			return "redirect:/admin/userlist";
		} else {
			map.put("error", "您的操作出现异常，请检查后稍候再试，或联系管理员");
			map.put("user", user);
			return "backstage/user_edit";
		}

	}

	/**
	 * 实现批量删除
	 * 
	 * @param ids
	 * @return
	 */
	@PostMapping(value = "/userdelete", produces = "application/json;charset=utf-8")
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
