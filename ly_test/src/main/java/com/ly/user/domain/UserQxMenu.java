package com.ly.user.domain;

import java.util.List;

import com.ly.dao.base.BaseDomain;
import com.ly.dao.base.TableField;

/**
 * desc：用户权限菜单表
 * ref ：
 * user：刘咏
 * date：2016/4/27
 * time：12:28
 */
public class UserQxMenu extends BaseDomain implements java.io.Serializable {

	// Fields
	@TableField
	private static final long serialVersionUID = -1550458871098520636L;
	private Integer menuId;
	private Integer parentId;
	private Short isParent;
	private String name;
	private String mark;
	private String url;
	private String icon;
	private Short sort;
	private Short status;
	
	//extend
	@TableField
	private List<UserQxMenu> list;

	// Constructors

	/** default constructor */
	public UserQxMenu() {
	}

	/** full constructor */
	public UserQxMenu(Integer menuId, Integer parentId, Short isParent,
			String name, String mark, String url, String icon, Short sort,
			Short status) {
		this.menuId = menuId;
		this.parentId = parentId;
		this.isParent = isParent;
		this.name = name;
		this.mark = mark;
		this.url = url;
		this.icon = icon;
		this.sort = sort;
		this.status = status;
	}

	// Property accessors

	public Integer getMenuId() {
		return this.menuId;
	}

	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}

	public Integer getParentId() {
		return this.parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Short getIsParent() {
		return this.isParent;
	}

	public void setIsParent(Short isParent) {
		this.isParent = isParent;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getIcon() {
		return this.icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Short getSort() {
		return this.sort;
	}

	public void setSort(Short sort) {
		this.sort = sort;
	}

	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	public List<UserQxMenu> getList() {
		return list;
	}

	public void setList(List<UserQxMenu> list) {
		this.list = list;
	}

}