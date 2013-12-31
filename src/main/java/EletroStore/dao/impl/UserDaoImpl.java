package EletroStore.dao.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import EletroStore.dao.UserDao;
import EletroStore.entity.User;
import EletroStore.entity.Userroles;

@Repository("userDao")
public class UserDaoImpl implements UserDao {

	private static Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void persist(User transientInstance) {
		logger.debug("persisting User instance");
		try {
			getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	@Transactional(readOnly = false)
	public void attachDirty(User instance) {
		logger.debug("attaching dirty User instance");
		try {
			Userroles roles = new Userroles();
			instance.setEnable(true);
			Md5PasswordEncoder md5 = new Md5PasswordEncoder();
			String encodedPass = md5.encodePassword(instance.getPassword(),
					null);
			instance.setPassword(encodedPass);
			roles.setUser(instance);
			roles.setRole("ROLE_USER");
			getCurrentSession().save(instance);
			getCurrentSession().save(roles);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	@Transactional
	public List<?> getAllUser() {
		logger.debug("Get all User item");
		try {
			List<?> userlist = getCurrentSession().createQuery("from User")
					.list();
			for (Object u : userlist) {
				User instance = (User) u;
				Hibernate.initialize(instance.getComments());
				Hibernate.initialize(instance.getOrderses());
				Hibernate.initialize(instance.getUserroleses());
				Hibernate.initialize(instance.getUservoteproducts());
				Hibernate.initialize(instance.getWishlists());

			}
			logger.debug("Get success!");
			return userlist;
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	@Transactional
	public void delete(User persistentInstance) {
		logger.debug("deleting User instance");
		try {
			getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	@Transactional
	public User merge(User detachedInstance) {
		logger.debug("merging User instance");
		try {
			User result = (User) getCurrentSession().merge(detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	@Transactional
	public void update(User detachedInstance) {
		logger.debug("updating User instance");
		try {
			getCurrentSession().update(detachedInstance);
			logger.debug("update successful");
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	@Transactional
	public User findById(java.lang.Integer id) {
		logger.debug("getting User instance with id: " + id);
		try {
			User instance = (User) getCurrentSession().get(
					"EletroStore.entity.User", id);
			Hibernate.initialize(instance.getComments());
			Hibernate.initialize(instance.getOrderses());
			Hibernate.initialize(instance.getUserroleses());
			Hibernate.initialize(instance.getUservoteproducts());
			Hibernate.initialize(instance.getWishlists());
			logger.debug("get successful, instance found");
			return instance;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	@Transactional
	public List<?> findByExample(User instance) {
		logger.debug("finding User instance by example");
		try {
			List<?> results = getCurrentSession()
					.createCriteria("EletroStore.entity.User")
					.add(Example.create(instance)).list();
			logger.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			logger.error("find by example failed", re);
			throw re;
		}
	}

	public Object uniqueQuery(String hql) {
		logger.debug("Query: " + hql);
		try {
			Object instance = (User) getCurrentSession().createQuery(hql)
					.uniqueResult();
			if (instance == null) {
				logger.debug("get successful, no instance found");
			} else {
				logger.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	public List<?> listQuery(String hql) {
		logger.debug("Query: " + hql);
		try {
			List<?> instance = getCurrentSession().createQuery(hql).list();
			if (instance == null) {
				logger.debug("get successful, no instance found");
			} else {
				logger.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}

	public User getUser(String email) {
		String hql = "from User user where user.email='"
				+ email + "'";
		return (User)uniqueQuery(hql);
	}
}
