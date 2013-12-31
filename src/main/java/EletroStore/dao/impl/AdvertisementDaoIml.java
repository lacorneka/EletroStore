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

import EletroStore.dao.AdvertisementDao;
import EletroStore.entity.Advertisement;


@Repository("advertisementDao")
public class AdvertisementDaoIml implements AdvertisementDao {

	private static Logger logger = LoggerFactory.getLogger(AdvertisementDaoIml.class);
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void persist(Advertisement transientInstance) {
		logger.debug("persisting Advertisement instance");
		try {
			getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	@Transactional(readOnly=false)
	public void attachDirty(Advertisement instance) {
		logger.debug("attaching dirty Advertisement instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}
	
	@Transactional
	public List<?> getAllAdvertisement() {
		logger.debug("Get all Advertisement item");
		try {
			List<?> advertisementlist = getCurrentSession().createQuery("from Advertisement").list();
			logger.debug("Get success!");
			return advertisementlist;
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}


	@Transactional
	public void delete(Advertisement persistentInstance) {
		logger.debug("deleting Advertisement instance");
		try {
			getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}
	
	@Transactional
	public Advertisement merge(Advertisement detachedInstance) {
		logger.debug("merging Advertisement instance");
		try {
			Advertisement result = (Advertisement) getCurrentSession().merge(
					detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	@Transactional
	public void update(Advertisement detachedInstance) {
		logger.debug("updating Advertisement instance");
		try {
			getCurrentSession().update(detachedInstance);
			logger.debug("update successful");			
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	@Transactional
	public Advertisement findById(java.lang.Integer id) {
		logger.debug("getting Advertisement instance with id: " + id);
		try {            
			Advertisement instance = (Advertisement) getCurrentSession().get(
					"EletroStore.entity.Advertisement", id);
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
	public List<?> findByExample(Advertisement instance) {
		logger.debug("finding Advertisement instance by example");
		try {
			List<?> results = getCurrentSession()
					.createCriteria("EletroStore.entity.Advertisement")
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
