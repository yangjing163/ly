package com.ly.a.service.tools;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.ly.user.dao.UserDao;
import com.ly.user.dao.UserQxResourceDao;

/**
 * 描述：Spring Security 资源过滤
 * 
 * @author 刘咏
 * @version 1.1
 * 
 * @日期：2014-10-27
 */
public class URLFilterInvocationSecurityMetadataSource implements
		FilterInvocationSecurityMetadataSource, InitializingBean {

	private static final Logger log = LoggerFactory.getLogger(UserDao.class);

	private final static List<ConfigAttribute> NULL_CONFIG_ATTRIBUTE = Collections
			.emptyList();

	// 权限集合
	private Map<RequestMatcher, Collection<ConfigAttribute>> requestMap;

	@Autowired
	private UserQxResourceDao userQxResourceDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.SecurityMetadataSource#getAttributes
	 * (java.lang.Object)
	 */
	@Override
	public Collection<ConfigAttribute> getAttributes(Object object)
			throws IllegalArgumentException {
		final HttpServletRequest request = ((FilterInvocation) object)
				.getRequest();

		Collection<ConfigAttribute> attrs = NULL_CONFIG_ATTRIBUTE;

		for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap
				.entrySet()) {
			if (entry.getKey().matches(request)) {
				attrs = entry.getValue();
				break;
			}
		}
		log.info("URL资源：" + request.getRequestURI() + " -> " + attrs);
		return attrs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.access.SecurityMetadataSource#
	 * getAllConfigAttributes()
	 */
	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		Set<ConfigAttribute> allAttributes = new HashSet<ConfigAttribute>();

		for (Map.Entry<RequestMatcher, Collection<ConfigAttribute>> entry : requestMap
				.entrySet()) {
			allAttributes.addAll(entry.getValue());
		}

		return allAttributes;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.SecurityMetadataSource#supports(java
	 * .lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return FilterInvocation.class.isAssignableFrom(clazz);
	}

	private Map<String, String> loadResuorce() {
		Map<String, String> map = new LinkedHashMap<String, String>();

		List<Map<String, String>> list = this.userQxResourceDao
				.getURLResourceMapping();
		Iterator<Map<String, String>> it = list.iterator();
		while (it.hasNext()) {
			Map<String, String> rs = it.next();
			String resourcePath = rs.get("resourcePath");
			String authorityMark = rs.get("authorityMark");

			if (map.containsKey(resourcePath)) {
				String mark = map.get("resourcePath");
				map.put(resourcePath, mark + "," + authorityMark);
			} else {
				map.put(resourcePath, authorityMark);
			}
		}
		return map;
	}

	protected Map<RequestMatcher, Collection<ConfigAttribute>> bindRequestMap() {
		Map<RequestMatcher, Collection<ConfigAttribute>> map = new LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>>();

		Map<String, String> resMap = this.loadResuorce();
		for (Map.Entry<String, String> entry : resMap.entrySet()) {
			String key = entry.getKey();
			Collection<ConfigAttribute> atts = new ArrayList<ConfigAttribute>();
			atts = SecurityConfig.createListFromCommaDelimitedString(entry
					.getValue());
			map.put(new AntPathRequestMatcher(key), atts);
		}

		return map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		this.requestMap = this.bindRequestMap();
		log.info("资源权限列表" + this.requestMap);
	}

	public void refreshResuorceMap() {
		this.requestMap = this.bindRequestMap();
	}

}
