package com.ly.user.domain;

import com.ly.dao.base.BaseDomain;
import com.ly.dao.base.Table;
import com.ly.dao.base.TableField;

/**
 * desc：用户权限资源表
 * ref ：
 * user：刘咏
 * date：2016/4/27
 * time：12:28
 */
@Table(name="user_qx_resource")
public class UserQxResource extends BaseDomain implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	@TableField
	private static final long serialVersionUID = 3836928396111329536L;
	private Long rid;
	private String type;
	private String name;
	private String url;
	private String descript;
	private Short sort;
	private Short status;
	private Short isSystem;
	private String marks;

	// Constructors

	/** default constructor */
	public UserQxResource() {
	}

	/** full constructor */
	public UserQxResource(Long rid, String type, String name, String url,
			String descript, Short sort, Short status, Short isSystem,
			String marks) {
		this.rid = rid;
		this.type = type;
		this.name = name;
		this.url = url;
		this.descript = descript;
		this.sort = sort;
		this.status = status;
		this.isSystem = isSystem;
		this.marks = marks;
	}

	// Property accessors

	public Long getRid() {
		return this.rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescript() {
		return this.descript;
	}

	public void setDescript(String descript) {
		this.descript = descript;
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

	public Short getIsSystem() {
		return this.isSystem;
	}

	public void setIsSystem(Short isSystem) {
		this.isSystem = isSystem;
	}

	public String getMarks() {
		return this.marks;
	}

	public void setMarks(String marks) {
		this.marks = marks;
	}

}