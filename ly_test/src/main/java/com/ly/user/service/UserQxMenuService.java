package com.ly.user.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ly.user.dao.UserQxMenuDao;
import com.ly.user.domain.UserQxMenu;

/**
 * desc：权限菜单service
 * ref ：
 * user：刘咏
 * date：2016/4/27
 * time：12:29
 */
@Service
public class UserQxMenuService {

	@Autowired
	private UserQxMenuDao userQxMenuDao;

	/****
	 * 组合用户权限菜单
	 * @param username String
	 * @return List
     */
	public List<UserQxMenu> getForMenu(String username) {
		List<UserQxMenu> sessionList = userQxMenuDao.getByUsername(username);

		List<UserQxMenu> allList = new ArrayList<UserQxMenu>();

		for(UserQxMenu node1 : sessionList){
			boolean mark = false;
			for(UserQxMenu node2 : sessionList){
				if(node1.getParentId()!=0 && node1.getParentId().equals(node2.getMenuId())){
					mark = true;
					if(node2.getList() == null)
						node2.setList(new ArrayList<UserQxMenu>());
					node2.getList().add(node1);
					break;
				}
			}
			if(!mark){
				allList.add(node1); 
			}
		}
		return allList;
	}

}
