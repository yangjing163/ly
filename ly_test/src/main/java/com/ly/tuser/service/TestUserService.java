package com.ly.tuser.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ly.tuser.dao.TestUserDao;
import com.ly.tuser.domain.TestUser;

/**
 * desc：测试用户service
 * ref ：
 * user：杨静
 * date：2017/6/12
 * time：16:25
 */
@Service
public class TestUserService {
	
	@Resource
	private TestUserDao testUserDao;
	
	/***
	 * 分页查询所有数据
	 * @param pageable Pageable
	 * @return Page
	 */
	public Page<TestUser> get(TestUser entity,Pageable pageable) {
		return testUserDao.get(entity, pageable);
	}

	/**
	 * 根据userId 获取 用户信息
	 * @param userId
	 * @return testUser
	 */
	public TestUser getOne(Long userId) {
		TestUser entity = new TestUser();
		entity.setUserId(userId);
		entity.setIdName("userId");
		return testUserDao.getOne(entity);
	}

	/**
	 * 添加用户
	 * @param entity
	 * @return map
	 */
	@Transactional
	public synchronized Map<String, Object> add(TestUser entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true);
		//创建userId
		Long userId = testUserDao.createUserID();
		//对初始密码加密
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		String pwssword=md5.encodePassword(entity.getUsername(), "123456");
		entity.setUserId(userId);
		entity.setPassword(pwssword);
		entity.setCreateDate(new Date());
		testUserDao.post(entity);
		map.put("msg", "添加成功");
		return map;
	}
	
	/**
	 * 验证表单数据
	 * @param entity
	 * @return
	 */
	public Map<String, Object> valiUserValue(TestUser entity){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true);
		if(StringUtils.isBlank(entity.getUsername())){
			map.put("result", false);
			map.put("msg", "请输入用户账号");
			return map;
		}
		if(StringUtils.isBlank(entity.getName())){
			map.put("result", false);
			map.put("msg", "请输入真实姓名");
			return map;
		}
		if(StringUtils.isBlank(entity.getNick())){
			map.put("result", false);
			map.put("msg", "请输入昵称");
			return map;
		}
		if(StringUtils.isBlank(entity.getAvatar())){
			map.put("result", false);
			map.put("msg", "请上传头像");
			return map;
		}
		if(StringUtils.isBlank(entity.getIdcard())){
			map.put("result", false);
			map.put("msg", "请输入身份证");
			return map;
		}
		if(StringUtils.isBlank(entity.getEmail())){
			map.put("result", false);
			map.put("msg", "请输入邮箱");
			return map;
		}
		if(StringUtils.isBlank(entity.getMobile())){
			map.put("result", false);
			map.put("msg", "请输入手机");
			return map;
		}
		if(null==entity.getUserType()){
			map.put("result", false);
			map.put("msg", "请选择用户类型");
			return map;
		}else if(entity.getUserType()!=1&&entity.getUserType()!=2){
			map.put("result", false);
			map.put("msg", "请选择合法的用户类型");
			return map;
		}
		return map;
	}
	
	/**
	 * 验证 userName 是否未注册
	 * @param userName
	 * @return map
	 */
	public Map<String, Object> valiUserRepeat(String userName){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true);
		int userCount = testUserDao.getUserCount(userName);
		if(userCount>0){
			map.put("result", false);
			map.put("msg", "该用户账号已存在！");
		}
		return map;
	}

	/**
	 * 通过userId删除用户
	 * @param entity( userId  )
	 * @return map
	 */
	@Transactional
	public Map<String, Object> delete(TestUser entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true);
		if(entity.getUserId()==null){
			map.put("result", false);
			map.put("msg", "删除失败");
			return map;
		}
		entity.setIdName("userId");
		testUserDao.delete(entity);
		map.put("msg", "删除成功");
		return map;
	}

	/**
	 * 修改用户信息
	 * @param entity
	 * @return
	 */
	@Transactional
	public Map<String, Object> update(TestUser entity) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", true);
		testUserDao.put(entity);
		map.put("msg", "修改成功");
		return map;
	}
	

}
