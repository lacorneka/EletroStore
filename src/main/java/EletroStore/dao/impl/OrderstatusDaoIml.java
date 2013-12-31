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

import EletroStore.dao.OrderstatusDao;
import EletroStore.entity.Orderstatus;


@Repository("orderstatusDao")
public class OrderstatusDaoIml implements OrderstatusDao {

	private static Logger logger = LoggerFactory.getLogger(OrderstatusDaoIml.class);
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void persist(Orderstatus transientInstance) {
		logger.debug("persisting Orderstatus instance");
		try {
			getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	@Transactional(readOnly=false)
	public void attachDirty(Orderstatus instance) {
		logger.debug("attaching dirty Orderstatus instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}
	
	@Transactional
	public List<?> getAllOrderstatus() {
		logger.debug("Get all Orderstatus item");
		try {
			List<?> orderstatuslist = getCurrentSession().createQuery("from Orderstatus").list();
			logger.debug("Get success!");
			return orderstatuslist;
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}


	@Transactional
	public void delete(Orderstatus persistentInstance) {
		logger.debug("deleting Orderstatus instance");
		try {
			getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}
	
	@Transactional
	public Orderstatus merge(Orderstatus detachedInstance) {
		logger.debug("merging Orderstatus instance");
		try {
			Orderstatus result = (Orderstatus) getCurrentSession().merge(
					detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	@Transactional
	public void update(Orderstatus detachedInstance) {
		logger.debug("updating Orderstatus instance");
		try {
			getCurrentSession().update(detachedInstance);
			logger.debug("update successful");			
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	@Transactional
	public Orderstatus findById(java.lang.Integer id) {
		logger.debug("getting Orderstatus instance with id: " + id);
		try {            
			Orderstatus instance = (Orderstatus) getCurrentSession().get(
					"EletroStore.entity.Orderstatus", id);
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
	public List<?> findByExample(Orderstatus instance) {
		logger.debug("finding Orderstatus instance by example");
		try {
			List<?> results = getCurrentSession()
					.createCriteria("EletroStore.entity.Orderstatus")
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
