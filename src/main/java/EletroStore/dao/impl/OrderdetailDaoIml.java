package EletroStore.dao.impl;

// Generated Dec 22, 2013 12:58:45 PM by Hibernate Tools 4.0.0

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import EletroStore.dao.OrderdetailDao;
import EletroStore.entity.Comment;
import EletroStore.entity.Orderdetail;


@Repository("orderdetailDao")
public class OrderdetailDaoIml implements OrderdetailDao {

	private static Logger logger = LoggerFactory.getLogger(OrderdetailDaoIml.class);
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void persist(Orderdetail transientInstance) {
		logger.debug("persisting Orderdetail instance");
		try {
			getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	@Transactional(readOnly=false)
	public void attachDirty(Orderdetail instance) {
		logger.debug("attaching dirty Orderdetail instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}
	
	@Transactional
	public List<?> getAllOrderdetail() {
		logger.debug("Get all Orderdetail item");
		try {
			List<?> orderdetaillist = getCurrentSession().createQuery("from Orderdetail").list();
			logger.debug("Get success!");
			return orderdetaillist;
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}


	@Transactional
	public void delete(Orderdetail persistentInstance) {
		logger.debug("deleting Orderdetail instance");
		try {
			getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}
	
	@Transactional
	public Orderdetail merge(Orderdetail detachedInstance) {
		logger.debug("merging Orderdetail instance");
		try {
			Orderdetail result = (Orderdetail) getCurrentSession().merge(
					detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	@Transactional
	public void update(Orderdetail detachedInstance) {
		logger.debug("updating Orderdetail instance");
		try {
			getCurrentSession().update(detachedInstance);
			logger.debug("update successful");			
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	@Transactional
	public Orderdetail findById(java.lang.Integer id) {
		logger.debug("getting Orderdetail instance with id: " + id);
		try {            
			Orderdetail instance = (Orderdetail) getCurrentSession().get(
					"EletroStore.entity.Orderdetail", id);
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
	public List<Orderdetail> findByOrderId(java.lang.Integer id) {
		logger.debug("getting Orderdetail instance with id: " + id);
		try {  
			String hql = "from Orderdetail o where o.orders.orderid =" + id;		
			List<Orderdetail> OrderdetailList = getCurrentSession().createQuery(hql).list();
			for (Orderdetail o:OrderdetailList) {
				Hibernate.initialize(o.getProduct());
			}
			return OrderdetailList;
		} catch (RuntimeException re) {
			logger.error("get failed", re);
			throw re;
		}
	}


	@Transactional
	public List<?> findByExample(Orderdetail instance) {
		logger.debug("finding Orderdetail instance by example");
		try {
			List<?> results = getCurrentSession()
					.createCriteria("EletroStore.entity.Orderdetail")
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
