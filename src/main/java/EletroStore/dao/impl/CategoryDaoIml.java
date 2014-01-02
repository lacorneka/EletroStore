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

import EletroStore.dao.CategoryDao;
import EletroStore.entity.Productcatalog;


@Repository("categoryDao")
public class CategoryDaoIml implements CategoryDao{

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
	public void persist(Productcatalog transientInstance) {
		logger.debug("persisting Productcatalog instance");
		try {
			getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	@Transactional
	public void attachDirty(Productcatalog instance) {
		logger.debug("attaching dirty Productcatalog instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}
	
	@Transactional
	public List<?> getAllCategory() {
		logger.debug("Get all Productcatalog item");
		try {
			List<?> categorylist = getCurrentSession().createQuery("from Productcatalog").list();
			logger.debug("Get success!");
			return categorylist;
		} catch (RuntimeException re) {
			logger.error("Failed", re);
			throw re;
		}
	}

	@Transactional
	public void delete(Productcatalog persistentInstance) {
		logger.debug("deleting Productcatalog instance");
		try {
			getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	@Transactional
	public Productcatalog merge(Productcatalog detachedInstance) {
		logger.debug("merging Productcatalog instance");
		try {
			Productcatalog result = (Productcatalog) sessionFactory
					.getCurrentSession().merge(detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}
	
	@Transactional
	public void update(Productcatalog detachedInstance) {
		logger.debug("updating Category instance");
		try {
			getCurrentSession().update(detachedInstance);
			logger.debug("update successful");			
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	@Transactional
	public Productcatalog findById(java.lang.Integer id) {
		logger.debug("getting Productcatalog instance with id: " + id);
		try {
			Productcatalog instance = (Productcatalog) sessionFactory
					.getCurrentSession().get("EletroStore.entity.Productcatalog",
							id);
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
	public List<?> findByExample(Productcatalog instance) {
		logger.debug("finding Productcatalog instance by example");
		try {
			List<?> results = getCurrentSession()
					.createCriteria("EletroStore.entity.Productcatalog")
					.add(Example.create(instance)).list();
			logger.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			logger.error("find by example failed", re);
			throw re;
		}
	}

	public int pagecount(String productname, String productcatalog,
			String[] brands, String[] conditions, String rating,
			int productonpage, String minprice, String maxprice) {
		// TODO Auto-generated method stub
		return 0;
	}
}
