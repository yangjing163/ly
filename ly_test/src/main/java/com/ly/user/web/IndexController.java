package com.ly.user.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * desc：用户Dao
 * ref ：
 * user：刘咏
 * date：2016/4/27
 * time：12:32
 */
@Controller
@RequestMapping("/admin/index/*")
public class IndexController {
	
	/***
	 * 首页
	 * 
	 * @return String
	 */
	@RequestMapping("/default")
	public String default1() {
		return ".admin.index.default";
	}
	
	/***
	 * 首页
	 * @return String
	 */
	@RequestMapping("/default2")
	public String default2() {
		return ".admin.index.default2";
	}
}
