package com.ly.a.service.tools;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ly.user.dao.UserDao;
import com.ly.user.dao.UserQxRoleDao;
import com.ly.user.domain.User;

/**
 * desc：用户service
 * ref ：
 * user：刘咏
 * date：2016/4/27
 * time：11:48
 */
@Service("userDetailsImpService")
public class UserDetailsImpService implements UserDetailsService {

	private static final Logger log = LoggerFactory.getLogger(UserDao.class);
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private UserQxRoleDao userQxRoleDao;

	@Autowired
	private MessageSource messageSource;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {

		Collection<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();

        User entity = new User();
        entity.setUsername(username);
        User user = userDao.getOneForLogin(entity);
		if (user == null)
			throw new UsernameNotFoundException(this.messageSource.getMessage(
					"UserDetailsService.userNotFount",
					new Object[] { username }, null));
		// 得到用户的权限
		roles = userQxRoleDao.getForGrant(username);
		user.setAuthorities(roles);
		
		log.info("*********************"+username+"***********************");
		log.info(user.getAuthorities().toString());
		log.info("********************************************************"); 
		return user;
	}

}
