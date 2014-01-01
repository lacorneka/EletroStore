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

import EletroStore.dao.WishlistDao;
import EletroStore.entity.User;
import EletroStore.entity.Wishlist;


@Repository("wishlistDao")
public class WishlistDaoIml implements WishlistDao {

	private static Logger logger = LoggerFactory.getLogger(WishlistDaoIml.class);
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void persist(Wishlist transientInstance) {
		logger.debug("persisting Wishlist instance");
		try {
			getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	@Transactional(readOnly = false)
	public void attachDirty(Wishlist instance) {
		logger.debug("attaching dirty Wishlist instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	@Transactional
	public List<?> getAllWishlist() {
		logger.debug("Get all Wishlist item");
		try {
			List<?> wishlistlist = getCurrentSession().createQuery("from Wishlist").list();
			logger.debug("Get success!");
			return wishlistlist;
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}


	@Transactional
	public void delete(Wishlist persistentInstance) {
		logger.debug("deleting Wishlist instance");
		try {
			getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	@Transactional
	public Wishlist merge(Wishlist detachedInstance) {
		logger.debug("merging Wishlist instance");
		try {
			Wishlist result = (Wishlist) getCurrentSession().merge(
					detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	@Transactional
	public void update(Wishlist detachedInstance) {
		logger.debug("updating Wishlist instance");
		try {
			getCurrentSession().update(detachedInstance);
			logger.debug("update successful");
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	@Transactional
	public Wishlist findById(java.lang.Integer id) {
		logger.debug("getting Wishlist instance with id: " + id);
		try {
			Wishlist instance = (Wishlist) getCurrentSession().get(
					"EletroStore.entity.Wishlist", id);
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
	public List<?> findByExample(Wishlist instance) {
		logger.debug("finding Wishlist instance by example");
		try {
			List<?> results = getCurrentSession()
					.createCriteria("EletroStore.entity.Wishlist")
					.add(Example.create(instance)).list();
			logger.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			logger.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Wishlist> getWishlListByUser(User user) {
		logger.debug("finding Wishlist instance by user");
		try {
			List<Wishlist> wishlists =  getCurrentSession().createQuery(
					"from Wishlist w where w.user.memberid= "
							+ user.getMemberid()).list();
			for(Wishlist w : wishlists) {
				Hibernate.initialize(w.getUser());
				Hibernate.initialize(w.getProduct());
			}
			return wishlists;
		} catch (RuntimeException re) {
			logger.error("find by user failed", re);
			throw re;
		}
	}

	@Transactional
	public boolean removeWishListByProductid(String productid) {
		String hql = "delete from Wishlist w where w.product.productid = "
				+ productid;
		try {
			getCurrentSession().createQuery(hql).executeUpdate();
			logger.info("Delete wishlist from database completed");
			return true;
		} catch (RuntimeException e) {
			logger.info("Delete wishlist from database failed,error:", e);
			System.err.print(e);
		}
		return false;
	}

}
