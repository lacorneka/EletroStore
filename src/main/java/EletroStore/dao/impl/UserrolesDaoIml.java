package EletroStore.dao.impl;

// Generated Dec 22, 2013 12:58:45 PM by Hibernate Tools 4.0.0

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import EletroStore.dao.UserrolesDao;
import EletroStore.entity.Userroles;


@Repository("userrolesDao")
public class UserrolesDaoIml implements UserrolesDao {

	private static Logger logger = LoggerFactory.getLogger(UserrolesDaoIml.class);
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void persist(Userroles transientInstance) {
		logger.debug("persisting Userroles instance");
		try {
			getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	@Transactional(readOnly=false)
	public void attachDirty(Userroles instance) {
		logger.debug("attaching dirty Userroles instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}
	
	@Transactional
	public List<?> getAllUserroles() {
		logger.debug("Get all Userroles item");
		try {
			List<?> userroleslist = getCurrentSession().createQuery("from Userroles").list();
			logger.debug("Get success!");
			return userroleslist;
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}


	@Transactional
	public void delete(Userroles persistentInstance) {
		logger.debug("deleting Userroles instance");
		try {
			getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}
	
	@Transactional
	public Userroles merge(Userroles detachedInstance) {
		logger.debug("merging Userroles instance");
		try {
			Userroles result = (Userroles) getCurrentSession().merge(
					detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	@Transactional
	public void update(Userroles detachedInstance) {
		logger.debug("updating Userroles instance");
		try {
			getCurrentSession().update(detachedInstance);
			logger.debug("update successful");			
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	@Transactional
	public Userroles findById(java.lang.Integer id) {
		logger.debug("getting Userroles instance with id: " + id);
		try {            
			Userroles instance = (Userroles) getCurrentSession().get(
					"EletroStore.entity.Userroles", id);
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

	@Transactional
	public List<?> findByExample(Userroles instance) {
		logger.debug("finding Userroles instance by example");
		try {
			List<?> results = getCurrentSession()
					.createCriteria("EletroStore.entity.Userroles")
					.add(Example.create(instance)).list();
			logger.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			logger.error("find by example failed", re);
			throw re;
		}
	}
}
