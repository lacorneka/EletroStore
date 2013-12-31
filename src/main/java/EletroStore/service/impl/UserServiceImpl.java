package EletroStore.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import EletroStore.dao.UserDao;
import EletroStore.entity.User;
import EletroStore.entity.Userroles;
import EletroStore.service.UserService;

@Service("userDetailsService")
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {

	@Autowired
	UserDao userDao;

	private static Logger logger = LoggerFactory
			.getLogger(UserServiceImpl.class);

	/**
	 * Implementation of UserDetailsService interface's loadUserByUsername
	 * method. The returned User object facilitate spring security to validate
	 * user credentials and decide on access to resources.
	 * 
	 * @param username
	 *            username of the logged in user
	 * @return Spring security user object for the logged in user
	 */

	/**
	 * This method returns the User entity object of the session's signed in
	 * user
	 * 
	 * @return User entity object of the current session's signed in user
	 */

	public EletroStore.entity.User getCurrentUser() {
		logger.info("Current User: "
				+ SecurityContextHolder.getContext().getAuthentication()
						.getPrincipal().toString());

		try {
			org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User) SecurityContextHolder
					.getContext().getAuthentication().getPrincipal();
			String hql = "from User user where user.email='"
					+ user.getUsername() + "'";
			User u = (User) userDao.uniqueQuery(hql);
			if (u.getEnable()) {
				return u;
			} else {
				return null;
			}
		} catch (Exception e) {
			return null;
		}
	}

	public org.springframework.security.core.userdetails.User loadUserByUsername(
			String username) {
		logger.debug("Spring security loading user details for user: "
				+ username);
		String hql = "from User user where user.email= '" + username + "'";
		User user = (User) userDao.uniqueQuery(hql);
		if (user.getEnable()) {
		Collection<Userroles> roles = user.getUserroleses();
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		Iterator<Userroles> iterator = roles.iterator();
		while (iterator.hasNext()) {
			authorities.add(new SimpleGrantedAuthority(iterator.next()
					.getRole()));
		}
			return new org.springframework.security.core.userdetails.User(
					username, user.getPassword(), authorities);
	}
		return null;
}
}
