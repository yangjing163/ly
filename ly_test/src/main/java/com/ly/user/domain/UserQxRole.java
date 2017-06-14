package com.ly.user.domain;

import com.ly.dao.base.BaseDomain;
import com.ly.dao.base.Table;
import com.ly.dao.base.TableField;

/**
 * desc：用户权限表
 * ref ：
 * user：刘咏
 * date：2016/4/27
 * time：12:28
 */
@Table(name = "user_qx_role")
public class UserQxRole extends BaseDomain implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	@TableField
	private static final long serialVersionUID = -7628139534577976806L;
	private Integer roleId;
	private String name;
	private String mark;
	private String note;

	// Constructors

	/** default constructor */
	public UserQxRole() {
	}

	/** full constructor */
	public UserQxRole(Integer roleId, String name, String roles, String note) {
		this.roleId = roleId;
		this.name = name;
		this.mark = roles;
		this.note = note;
	}

	// Property accessors

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}