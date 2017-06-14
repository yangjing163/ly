package com.ly.tuser.domain;

import java.io.Serializable;
import java.util.Date;

import com.ly.dao.base.BaseDomain;
import com.ly.dao.base.Table;
import com.ly.dao.base.TableField;

/**
 * desc：测试用户
 * ref ：
 * user：杨静
 * date：2017/6/12
 * time：16:25
 */
@Table(name = "test_user")
public class TestUser extends BaseDomain implements Serializable{

	@TableField
	private static final long serialVersionUID = 7932993816784578235L;
	private Long userId;
	private String username;
	private String name;
	private String password;
	private String nick;
	private String avatar;
	private String idcard;
	private String email;
	private String mobile;
	private Short userType;
	private Date createDate;
	private Long mid;
	
	
	
	public TestUser() {
		this.dt = "desc";
		this.dtn = "userId";
		this.pageSize = 10;
	}
	
	public TestUser(Long userId, String username, String name, String password, String nick, String avatar,
			String idcard, String email, String mobile, Short userType, Date createDate) {
		super();
		this.userId = userId;
		this.username = username;
		this.name = name;
		this.password = password;
		this.nick = nick;
		this.avatar = avatar;
		this.idcard = idcard;
		this.email = email;
		this.mobile = mobile;
		this.userType = userType;
		this.createDate = createDate;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public Short getUserType() {
		return userType;
	}
	public void setUserType(Short userType) {
		this.userType = userType;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getMid() {
		return mid;
	}
	public void setMid(Long mid) {
		this.mid = mid;
	}
	
	
	@Override
	public String toString(String s) {
//		System.out.println(s+"---------------------");
		StringBuilder sb = new StringBuilder("?");
		if(mid!=null && s.contains("mid")) 
			sb.append("mid="+mid);		
		if(pageNo!=null && s.contains("pageNo")) 
			sb.append("&pageNo="+pageNo);
		if(pageSize!=null && s.contains("pageSize")) 
			sb.append("&pageSize="+pageSize);
		if(dt!=null && s.contains("dt")) 
			sb.append("&dt="+dt);
		if(dtn!=null && s.contains("dtn")) 
			sb.append("&dtn="+dtn);		
		if(name!=null && s.contains("name"))
			sb.append("&name="+name);
		return sb.toString();
	}
	
}
