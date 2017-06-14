package com.ly.tuser.web;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.ly.cms.service.CmsMenuService;
import com.ly.tuser.domain.TestUser;
import com.ly.tuser.service.TestUserService;

/**
 * desc：测试用户控制器controller
 * ref ：
 * user：杨静
 * date：2017/6/12
 * time：16:25
 */
@Controller
@RequestMapping("/admin/tuser/")
public class TestUserController {
	
	@Resource
	private TestUserService testUserService;
	@Autowired
	private CmsMenuService cmsMenuService;
	
	/**
	 * 用户中心列表
	 * @param entity
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/get")
    public String get(TestUser entity, ModelMap modelMap) {
		Pageable pageable = new PageRequest(entity.getPageNo(), entity.getPageSize(),entity.getDts());
		modelMap.addAttribute("entity",entity);
		modelMap.addAttribute("page",testUserService.get(entity,pageable));
		modelMap.addAttribute("menu", cmsMenuService.getOne(entity.getMid()));
		return ".admin.testuser.list";
	}
	
	/**
	 * 获取数据跳转新增或者修改
	 * @param entity
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/edit")
    public String edit(TestUser entity, ModelMap modelMap) {
		if (entity.getUserId()!=null) {
			modelMap.addAttribute("entity", testUserService.getOne(entity.getUserId()));
			return ".admin.testuser.info";
		}
		modelMap.addAttribute("mid", entity.getMid());
		return ".admin.testuser.edit";
	}
	
	/**
	 * 验证该用户账号是否未注册
	 * @param username
	 * @return true 未注册 false 已注册 
	 */
	@RequestMapping("/valiUserRepeat")
	@ResponseBody
    public String valiUserRepeat(String  username) {
		Map<String, Object> resultMap = testUserService.valiUserRepeat(username);
		return JSON.toJSONString(resultMap);
		
	}
	
	/**
	 * 添加用户
	 * @param entity
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
    public String add(TestUser entity) {
		//验证表单内容
		Map<String, Object> resultMap = testUserService.valiUserValue(entity);
		if((Boolean)resultMap.get("result")){
			//验证账号是否未注册
			resultMap = testUserService.valiUserRepeat(entity.getUsername());
			if((Boolean)resultMap.get("result")){
				//保存用户
				resultMap = testUserService.add(entity);
			}
		}
		return JSON.toJSONString(resultMap);
		
	}
	
	/**
	 * 删除用户
	 * @param entity
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
    public String delete(TestUser entity) {
		Map<String, Object> resultMap = testUserService.delete(entity);
		return JSON.toJSONString(resultMap);
	}
	
	/**
	 * 修改用户
	 * @param entity
	 * @return
	 */
	@RequestMapping("/put")
	@ResponseBody
    public String put(TestUser entity) {
		Map<String, Object> resultMap = testUserService.valiUserValue(entity);
		if((Boolean)resultMap.get("result")){
			 resultMap = testUserService.update(entity);
		}
		return JSON.toJSONString(resultMap);
	}


}
