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

import EletroStore.dao.BrandDao;
import EletroStore.entity.Brand;


@Repository("brandDao")
public class BrandDaoIml implements BrandDao {

	private static Logger logger = LoggerFactory.getLogger(BrandDaoIml.class);
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void persist(Brand transientInstance) {
		logger.debug("persisting Brand instance");
		try {
			getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	@Transactional(readOnly=false)
	public void attachDirty(Brand instance) {
		logger.debug("attaching dirty Brand instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}
	
	@Transactional
	public List<?> getAllBrand() {
		logger.debug("Get all Brand item");
		try {
			List<?> brandlist = getCurrentSession().createQuery("from Brand").list();
			logger.debug("Get success!");
			return brandlist;
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}


	@Transactional
	public void delete(Brand persistentInstance) {
		logger.debug("deleting Brand instance");
		try {
			getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}
	
	@Transactional
	public Brand merge(Brand detachedInstance) {
		logger.debug("merging Brand instance");
		try {
			Brand result = (Brand) getCurrentSession().merge(
					detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	@Transactional
	public void update(Brand detachedInstance) {
		logger.debug("updating Brand instance");
		try {
			getCurrentSession().update(detachedInstance);
			logger.debug("update successful");			
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	@Transactional
	public Brand findById(java.lang.Integer id) {
		logger.debug("getting Brand instance with id: " + id);
		try {            
			Brand instance = (Brand) getCurrentSession().get(
					"EletroStore.entity.Brand", id);
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
	public List<?> findByExample(Brand instance) {
		logger.debug("finding Brand instance by example");
		try {
			List<?> results = getCurrentSession()
					.createCriteria("EletroStore.entity.Brand")
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
