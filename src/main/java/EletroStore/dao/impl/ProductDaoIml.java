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

import EletroStore.dao.ProductDao;
import EletroStore.entity.Product;


@Repository("productDao")
public class ProductDaoIml implements ProductDao {

	private static Logger logger = LoggerFactory.getLogger(ProductDaoIml.class);
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void persist(Product transientInstance) {
		logger.debug("persisting Product instance");
		try {
			getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	@Transactional(readOnly=false)
	public void attachDirty(Product instance) {
		logger.debug("attaching dirty Product instance");
		Session session = sessionFactory.openSession();

		try {
			session.save(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}
	
	@Transactional
	public List<?> getAllProduct() {
		logger.debug("Get all Product item");
		try {
			List<?> Productslist = getCurrentSession().createQuery("from Product").list();
			for (Object o : Productslist) {
				Product instance = (Product) o;
				Hibernate.initialize(instance.getComments());
				Hibernate.initialize(instance.getOrderdetails());
				Hibernate.initialize(instance.getBrand());
				Hibernate.initialize(instance.getCondition());
				Hibernate.initialize(instance.getProductcatalog());
				Hibernate.initialize(instance.getUservoteproducts());

			}
			logger.debug("Get success!");
			return Productslist;
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}


	@Transactional
	public void delete(Product persistentInstance) {
		logger.debug("deleting Product instance");
		try {
			getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}
	
	@Transactional
	public Product merge(Product detachedInstance) {
		logger.debug("merging Product instance");
		try {
			Product result = (Product) getCurrentSession().merge(
					detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	@Transactional
	public void update(Product detachedInstance) {
		logger.debug("updating Product instance");
		try {
			getCurrentSession().update(detachedInstance);
			logger.debug("update successful");			
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	@Transactional
	public Product findById(java.lang.Integer id) {
		logger.debug("getting Product instance with id: " + id);
		try {            
			Product instance = (Product) getCurrentSession().get(
					"EletroStore.entity.Product", id);
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
	public List<?> findByExample(Product instance) {
		logger.debug("finding Product instance by example");
		try {
			List<?> results = getCurrentSession()
					.createCriteria("EletroStore.entity.Product")
					.add(Example.create(instance)).list();
			logger.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			logger.error("find by example failed", re);
			throw re;
		}
	}
	
	@Transactional
	public List<Product> getProductList(String productcatalogid) {
		logger.debug("getting Product instance by catalog");
		try {
			Session session = sessionFactory.getCurrentSession();
			String hql = "from Product p where p.productcatalog.catalogid = '"
					+ productcatalogid + "'";
			return session.createQuery(hql).list();
		} catch (RuntimeException re) {
			logger.error("get Product by catalog failed", re);
			throw re;
		}
	}
}
