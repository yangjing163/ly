package com.ly.user.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ly.dao.base.BasePageDao;
import com.ly.user.domain.UserQxResource;

/**
 * desc：用户_菜单资源Dao
 * ref ：
 * user：刘咏
 * date：2016/4/27
 * time：12:18
 */
@Repository
public class UserQxResourceDao extends BasePageDao<UserQxResource, Serializable> {


	/***
	 * 根据用户名获取到用户的资源并封装成user_qx_resource集合
	 * @return List
     */
	public List<Map<String,String>> getURLResourceMapping(){

		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		String sql = "select url,marks from user_qx_resource";
		List<UserQxResource> result = get(sql, new UserQxResource());
        for(UserQxResource o : result) {
            Map<String,String> map = new HashMap<String,String>();
            map.put("resourcePath", o.getUrl());
            map.put("authorityMark", o.getMarks());
            list.add(map);
        }
		return list;
	}

}
