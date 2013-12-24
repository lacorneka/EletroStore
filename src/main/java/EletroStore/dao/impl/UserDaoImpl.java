
package EletroStore.dao.impl;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import EletroStore.dao.UserDao;
import EletroStore.entity.*;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional(readOnly=false)
	public boolean addUser(User user) {
		try {
		Userroles roles = new Userroles();
		user.setEnable(true);
		Md5PasswordEncoder md5 = new Md5PasswordEncoder();
		String encodedPass = md5.encodePassword(user.getPassword(),null);
		user.setPassword(encodedPass);
		Session session = sessionFactory.openSession(); 
		session.save(user);
		roles.setUser(user);
		roles.setRole("ROLE_USER");
		session.save(roles);
		session.close();
		return true;
		} catch (Exception e) {
			logger.trace("Exception: " + e.getMessage() );
			return false;
		}
	}

	public void updateUser(User user) {
		User userToUpdate = getUser(user.getMemberid());
		getCurrentSession().update(userToUpdate);
	}

	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return getCurrentSession().createQuery("from User").list();
	}

	public User getUser(int memberid) {
		User user = (User) getCurrentSession().get(User.class, memberid);
		if (user == null) {
			logger.trace("User not found: " + memberid);
		} else {
			logger.trace("User found: " + memberid);
			Iterator<Userroles> roleIterator = user.getUserroleses().iterator();
            while(roleIterator.hasNext()) {
                Userroles role = roleIterator.next();
                logger.trace("\tUser role: " + role.getRole());
            }
		}
		return user;
	}

	public void deleteUser(int id) {
		User user = getUser(id);
		if (user != null) {
			getCurrentSession().delete(user);
		}
	}

	public User getUser(String username) {
		if (username==null || username.isEmpty()){
			logger.trace("Empty name is passed !!! ");
			return null;
		}
		User user = (User) getCurrentSession()
				.createQuery("from User user where user.email=?")
				.setParameter(0, username).uniqueResult();

		if (user == null) {
			logger.trace("User not found: " + username);
		} else {
			logger.trace("User found: " + username);
			Iterator<Userroles> roleIterator = user.getUserroleses().iterator();
            while(roleIterator.hasNext()) {
                Userroles role = roleIterator.next();
                logger.trace("\tUser role: " + role.getRole());
            }
		}
		return user;
	}
}
