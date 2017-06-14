package com.ly.user.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import com.ly.dao.base.BasePageDao;
import com.ly.user.domain.UserQxMenu;

/**
 * desc：用户_权限菜单Dao
 * ref ：
 * user：刘咏
 * date：2016/4/27
 * time：12:17
 */
@Repository
public class UserQxMenuDao extends BasePageDao<UserQxMenu, Serializable> {

	/**
	 * 先根据用户名获取到user_qx_menu集合
	 * @param username String
	 * @return List
	 */
	public List<UserQxMenu> getByUsername(String username) {
		UserQxMenu entity = new UserQxMenu();
		entity.setName(username);
		String sql = "SELECT * FROM user_qx_menu WHERE menuId IN(SELECT DISTINCT menuId FROM user_qx_role_menu s1 JOIN user_qx_user_role s2 ON s1.roleId = s2.roleId JOIN user s3 ON s3.username = s2.username AND s3.username=:name)";
		return super.get(sql, entity);
	}

	/**
	 * 根据用户名获取到用户的权限并封装成GrantedAuthority集合
	 * @param username String
	 */
	public Collection<GrantedAuthority> loadUserMenus(String username){
		List<UserQxMenu> list = this.getByUsername(username);
		List<GrantedAuthority> menus = new ArrayList<GrantedAuthority>();
		
		for (UserQxMenu menu : list) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(menu.getMark());
			menus.add(grantedAuthority);
		}
		return menus;
	}

}
