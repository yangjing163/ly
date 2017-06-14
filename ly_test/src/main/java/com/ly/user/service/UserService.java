package com.ly.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ly.user.dao.UserDao;
import com.ly.user.domain.User;

/**
 * desc：用户service
 * ref ：
 * user：刘咏
 * date：2016/4/27
 * time：12:29
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	/***
	 * 单个对象
	 * @param userId Long
	 * @return User
     */
	public User getOne(Long userId) {
		User entity = new User();
		entity.setUserId(userId);
		entity.setIdName("userId");
		return userDao.getOne(entity);
	}

	/***
	 * 列表
	 * @param entity User
	 * @param pageable Pageable
     * @return Page
     */
	public Page<User> get(User entity,Pageable pageable) {
		StringBuilder sb = new StringBuilder("select * from user");
		if(entity!=null && entity.getUsername()!= null) {
			sb.append(" where locate(:nick,username)>0 or locate(:nick,nick)>0 or locate(:nick,mobile)>0 or locate(:nick,name)>0");
		}
		return userDao.get(sb.toString(),entity, pageable);
	}

	/***
	 * 增加
	 * @param entity User
	 * @return int
     */
	@Transactional
	public int post(User entity) {
		entity.setUserId(userDao.getKey("user", new User()));
		return userDao.post(entity);
	}

	/***
	 * 修改
	 * @param entity User
	 * @return int
     */
	public int put(User entity) {
		entity.setIdName("userId");
		return userDao.put(entity);
	}

	/***
	 * 删除
	 * @param userId v
	 * @return int
     */
	public int delete(Long userId) {
		User entity = new User();
		entity.setUserId(userId);
		entity.setIdName("userId");
		return userDao.delete(entity);
	}

	/***
	 * 用户登录
	 * 
	 * @param username String
	 * @return User
	 */
	public User getOneForLogin(String username) {
		User entity = new User();
		entity.setUsername(username);
		return userDao.getOneForLogin(entity);
	}

}
