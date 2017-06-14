package com.ly.user.dao;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.ly.dao.base.BasePageDao;
import com.ly.user.domain.User;

/**
 * desc：用户Dao
 * ref ：
 * user：刘咏
 * date：2016/4/27
 * time：12:14
 */
@Repository
public class UserDao extends BasePageDao<User, Serializable> {

	private static final Logger log = LoggerFactory.getLogger(UserDao.class);

	/***
	 * 用户登录
	 * 
	 * @param entity User
	 * @return User
	 */
	public User getOneForLogin(User entity) {
		String sql = "select * from user where username=:username or mobile=:username or email=:username";
		try {
            entity = super.getOne(sql, entity);
			return entity;
		} catch (RuntimeException re) {
			log.error("用户登录.", re);
			throw re;
		}
	}
}
