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

import EletroStore.dao.UservoteproductDao;
import EletroStore.entity.Uservoteproduct;


@Repository("uservoteproductDao")
public class UservoteproductDaoIml implements UservoteproductDao {

	private static Logger logger = LoggerFactory.getLogger(UservoteproductDaoIml.class);
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void persist(Uservoteproduct transientInstance) {
		logger.debug("persisting Uservoteproduct instance");
		try {
			getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	@Transactional(readOnly=false)
	public void attachDirty(Uservoteproduct instance) {
		logger.debug("attaching dirty Uservoteproduct instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}
	
	@Transactional
	public List<?> getAllUservoteproduct() {
		logger.debug("Get all Uservoteproduct item");
		try {
			List<?> uservoteproductlist = getCurrentSession().createQuery("from Uservoteproduct").list();
			logger.debug("Get success!");
			return uservoteproductlist;
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}


	@Transactional
	public void delete(Uservoteproduct persistentInstance) {
		logger.debug("deleting Uservoteproduct instance");
		try {
			getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}
	
	@Transactional
	public Uservoteproduct merge(Uservoteproduct detachedInstance) {
		logger.debug("merging Uservoteproduct instance");
		try {
			Uservoteproduct result = (Uservoteproduct) getCurrentSession().merge(
					detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	@Transactional
	public void update(Uservoteproduct detachedInstance) {
		logger.debug("updating Uservoteproduct instance");
		try {
			getCurrentSession().update(detachedInstance);
			logger.debug("update successful");			
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	@Transactional
	public Uservoteproduct findById(java.lang.Integer id) {
		logger.debug("getting Uservoteproduct instance with id: " + id);
		try {            
			Uservoteproduct instance = (Uservoteproduct) getCurrentSession().get(
					"EletroStore.entity.Uservoteproduct", id);
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
	public List<?> findByExample(Uservoteproduct instance) {
		logger.debug("finding Uservoteproduct instance by example");
		try {
			List<?> results = getCurrentSession()
					.createCriteria("EletroStore.entity.Uservoteproduct")
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
