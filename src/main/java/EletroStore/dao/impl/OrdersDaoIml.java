package EletroStore.dao.impl;

// Generated Dec 22, 2013 12:58:45 PM by Hibernate Tools 4.0.0

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import EletroStore.dao.OrdersDao;
import EletroStore.entity.Orders;
import EletroStore.entity.User;

@Repository("ordersDao")
public class OrdersDaoIml implements OrdersDao {

	private static Logger logger = LoggerFactory.getLogger(OrdersDaoIml.class);
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void persist(Orders transientInstance) {
		logger.debug("persisting Orders instance");
		try {
			getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	@Transactional(readOnly = false)
	public void attachDirty(Orders instance) {
		logger.debug("attaching dirty Orders instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	@Transactional
	public List<?> getAllOrders() {
		logger.debug("Get all Orders item");
		try {
			List<?> orderslist = getCurrentSession().createQuery("from Orders")
					.list();
			logger.debug("Get success!");
			for (Object o : orderslist) {
				Orders instance = (Orders)o;
				Hibernate.initialize(instance.getOrderdetails());
				Hibernate.initialize(instance.getUser());
				Hibernate.initialize(instance.getOrderstatus());
			}
			return orderslist;
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	@Transactional
	public void delete(Orders persistentInstance) {
		logger.debug("deleting Orders instance");
		try {
			getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	@Transactional
	public Orders merge(Orders detachedInstance) {
		logger.debug("merging Orders instance");
		try {
			Orders result = (Orders) getCurrentSession()
					.merge(detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	@Transactional
	public void update(Orders detachedInstance) {
		logger.debug("updating Orders instance");
		try {
			getCurrentSession().update(detachedInstance);
			logger.debug("update successful");
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	@Transactional
	public Orders findById(java.lang.Integer id) {
		logger.debug("getting Orders instance with id: " + id);
		try {
			Orders instance = (Orders) getCurrentSession().get(
					"EletroStore.entity.Orders", id);
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
	public List<?> findByExample(Orders instance) {
		logger.debug("finding Orders instance by example");
		try {
			List<?> results = getCurrentSession()
					.createCriteria("EletroStore.entity.Orders")
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
	public List<Orders> getListOrderByUser(User user, int filterorder) {

		Session session = sessionFactory.getCurrentSession();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();

		String hql = String.format("from Orders o where o.user.email ='%s' ",
				user.getEmail());
		
		if (filterorder == 0) {
			c.add(Calendar.DAY_OF_YEAR, -7);
			Date thisweek = c.getTime();
			String formattedweek = formatter.format(thisweek);
			hql += " and o.orderdate > '" + formattedweek + "'";
		}

		if (filterorder == 1) {
			c.add(Calendar.DAY_OF_YEAR, -30);
			Date thismonth = c.getTime();
			String formattedmonth = formatter.format(thismonth);
			hql += " and o.orderdate >'" + formattedmonth + "'";
		}

		if (filterorder == 2) {
			c.add(Calendar.DAY_OF_YEAR, -365);
			Date thisyear = c.getTime();
			String formattedyear = formatter.format(thisyear);
			hql += " and o.orderdate >'" + formattedyear + "'";
		}

		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<Orders> listOrders = query.list();
		for (Orders o : listOrders) {
			Hibernate.initialize(o.getOrderdetails());
			Hibernate.initialize(o.getUser());
			Hibernate.initialize(o.getOrderstatus());
		}
		return listOrders;
	}
}
