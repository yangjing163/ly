package com.ly.tuser.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.ly.dao.base.BasePageDao;
import com.ly.tuser.domain.TestUser;

/**
 * desc：测试用户Dao
 * ref ：
 * user：杨静
 * date：2017/6/12
 * time：16:25
 */
@Repository
public class TestUserDao extends BasePageDao<TestUser, Serializable>{

	
	/***
	 * 分页查询所有数据
	 * @param pageable Pageable
	 * @return Page
	 */
	public Page<TestUser> get(TestUser entity,Pageable pageable) {
		StringBuilder sb = new StringBuilder("select * from test_user where mid=:mid ");
		if(entity.getName()!=null)
			sb.append(" and locate(:name,name)>0");
		return super.get(sb.toString(),entity, pageable);
	}

	
	/**
	 * 获取新的userId
	 * @return long
	 */
	public Long createUserID(){
		List<Map<String,Object>> list = get("Select max(userId) as maxId from test_user ", new HashMap<>());
		if(list.size()==1){
			Map<String, Object> map = list.get(0);
			try{
				Long maxId = Long.valueOf(map.get("maxId").toString());
				return maxId+1L;
			}catch(Exception e){
				return 0L;
			}
		}
		return 0L;
	}
	
	/**
	 * 查询当前userName的用户数量
	 * @param userName
	 * @return
	 */
	public int getUserCount(String userName){
		Map<String, Object> map =  new HashMap<String, Object>();
		map.put("username", userName);
		List<Map<String,Object>> list = get("Select userId from test_user where username = :username", map);
		return list.size();
	}
	

	/***
	 * 通过userId修改用户信息
	 * @param entity 
	 * @return int
	 */
	public int put(TestUser entity) {
		String sql = "UPDATE test_user SET name=:name, nick=:nick, avatar=:avatar, idcard=:idcard,email=:email,mobile=:mobile,userType=:userType where userId = :userId ";
		return super.put(sql, entity);
	}
}
