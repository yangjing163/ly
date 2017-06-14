package com.ly.user.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import com.ly.dao.base.BasePageDao;
import com.ly.user.domain.UserQxRole;

/**
 * desc：用户_权限Dao
 * ref ：
 * user：刘咏
 * date：2016/4/27
 * time：12:22
 */
@Repository
public class UserQxRoleDao extends BasePageDao<UserQxRole, Serializable> {

	/**
	 * 根据用户名获取到用户的权限并封装成GrantedAuthority集合
	 * @param username String
	 */
	public Collection<GrantedAuthority> getForGrant(String username){
		UserQxRole entity = new UserQxRole();
		entity.setName(username);
		String sql = "SELECT * FROM user_qx_role s1 JOIN user_qx_user_role s2 ON s1.roleId = s2.roleId AND s2.username=:name";
		List<UserQxRole> list = get(sql, entity);
		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		
		for (UserQxRole role : list) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getMark());
			roles.add(grantedAuthority);
		}
		return roles;
	}

}
