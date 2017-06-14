package com.ly.user.domain;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ly.dao.base.BaseDomain;
import com.ly.dao.base.Table;
import com.ly.dao.base.TableField;

/**
 * desc：用户表
 * ref ：
 * user：刘咏
 * date：2016/4/27
 * time：12:23
 */
@Table(name = "user")
public class User extends BaseDomain implements UserDetails, java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	@TableField
	private static final long serialVersionUID = -6240130095017274090L;
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
	private Short businessType;
	private Short userStatus;//用户状态1未激活 2正常 3删除 4冻结 5监控
	private String regSource;
	private Date createDate;
	private Date lastLoginDate;
	private String lastLoginIp;
	private Integer loginTimes;
	private Short errorLoginTimes;
	private String openId;
	private Long yyId;
	private Long cid;
	private String roomNo;
	
	private String token;//token标识
	private Date tokenDate;//token标识时间

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(Long userId, String username, String name, String password,
			String nick, String avatar, String idcard, String email,
			String mobile, Short userType, Short businessType,
			Short userStatus, String regSource, Date createDate,
			Date lastLoginDate, String lastLoginIp, Integer loginTimes,
			Short errorLoginTimes, String openId, Long yyId) {
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
		this.businessType = businessType;
		this.userStatus = userStatus;
		this.regSource = regSource;
		this.createDate = createDate;
		this.lastLoginDate = lastLoginDate;
		this.lastLoginIp = lastLoginIp;
		this.loginTimes = loginTimes;
		this.errorLoginTimes = errorLoginTimes;
		this.openId = openId;
		this.yyId = yyId;
	}

	@TableField
	private Collection<GrantedAuthority> ex_authorities;
	@TableField
	private Set<UserQxRole> ex_roles = new HashSet<UserQxRole>(0);  

	// Property accessors

	public Long getUserId() {
		return this.userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNick() {
		return this.nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getAvatar() {
		return this.avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Short getUserType() {
		return this.userType;
	}

	public void setUserType(Short userType) {
		this.userType = userType;
	}

	public Short getBusinessType() {
		return this.businessType;
	}

	public void setBusinessType(Short businessType) {
		this.businessType = businessType;
	}

	public Short getUserStatus() {
		return this.userStatus;
	}

	public void setUserStatus(Short userStatus) {
		this.userStatus = userStatus;
	}

	public String getRegSource() {
		return this.regSource;
	}

	public void setRegSource(String regSource) {
		this.regSource = regSource;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastLoginDate() {
		return this.lastLoginDate;
	}

	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}

	public String getLastLoginIp() {
		return this.lastLoginIp;
	}

	public void setLastLoginIp(String lastLoginIp) {
		this.lastLoginIp = lastLoginIp;
	}

	public Integer getLoginTimes() {
		return this.loginTimes;
	}

	public void setLoginTimes(Integer loginTimes) {
		this.loginTimes = loginTimes;
	}

	public Short getErrorLoginTimes() {
		return this.errorLoginTimes;
	}

	public void setErrorLoginTimes(Short errorLoginTimes) {
		this.errorLoginTimes = errorLoginTimes;
	}

	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public Long getYyId() {
		return this.yyId;
	}

	public void setYyId(Long yyId) {
		this.yyId = yyId;
	}

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getTokenDate() {
		return tokenDate;
	}

	public void setTokenDate(Date tokenDate) {
		this.tokenDate = tokenDate;
	}

	// 账户没有过期(激活)
	@Override
	public boolean isAccountNonExpired() {
		return (userStatus != 1);
	}

	// 账户没有被锁定
	@Override
	public boolean isAccountNonLocked() {
		return (userStatus != 4);
	}

	// 证书没有过期
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 账户是否有效
	@Override
	public boolean isEnabled() {
		return true;
	}

	public Collection<GrantedAuthority> getEx_authorities() {
		return ex_authorities;
	}

	public void setEx_authorities(Collection<GrantedAuthority> ex_authorities) {
		this.ex_authorities = ex_authorities;
	}

	public Set<UserQxRole> getEx_roles() {
		return ex_roles;
	}

	public void setEx_roles(Set<UserQxRole> ex_roles) {
		this.ex_roles = ex_roles;
	}

	// 权限集合
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.ex_authorities;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.ex_authorities = authorities;
	}

}