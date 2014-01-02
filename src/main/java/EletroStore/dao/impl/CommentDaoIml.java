package EletroStore.dao.impl;

// Generated Dec 22, 2013 12:58:45 PM by Hibernate Tools 4.0.0

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

import EletroStore.dao.CommentDao;
import EletroStore.entity.Comment;
import EletroStore.entity.Product;

@Repository("commentDao")
public class CommentDaoIml implements CommentDao {

	private static Logger logger = LoggerFactory.getLogger(CommentDaoIml.class);
	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	public void persist(Comment transientInstance) {
		logger.debug("persisting Comment instance");
		try {
			getCurrentSession().persist(transientInstance);
			logger.debug("persist successful");
		} catch (RuntimeException re) {
			logger.error("persist failed", re);
			throw re;
		}
	}

	@Transactional(readOnly = false)
	public void attachDirty(Comment instance) {
		logger.debug("attaching dirty Comment instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			logger.debug("attach successful");
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	@Transactional
	public List<?> getAllComment() {
		logger.debug("Get all Comment item");
		try {
			List<?> commentlist = getCurrentSession().createQuery(
					"from Comment").list();
			logger.debug("Get success!");
			return commentlist;
		} catch (RuntimeException re) {
			logger.error("attach failed", re);
			throw re;
		}
	}

	@Transactional
	public void delete(Comment persistentInstance) {
		logger.debug("deleting Comment instance");
		try {
			getCurrentSession().delete(persistentInstance);
			logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	@Transactional
	public Comment merge(Comment detachedInstance) {
		logger.debug("merging Comment instance");
		try {
			Comment result = (Comment) getCurrentSession().merge(
					detachedInstance);
			logger.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("merge failed", re);
			throw re;
		}
	}

	@Transactional
	public void update(Comment detachedInstance) {
		logger.debug("updating Comment instance");
		try {
			getCurrentSession().update(detachedInstance);
			logger.debug("update successful");
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	@Transactional
	public Comment findById(java.lang.Integer id) {
		logger.debug("getting Comment instance with id: " + id);
		try {
			Comment instance = (Comment) getCurrentSession().get(
					"EletroStore.entity.Comment", id);
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
	public List<?> findByExample(Comment instance) {
		logger.debug("finding Comment instance by example");
		try {
			List<?> results = getCurrentSession()
					.createCriteria("EletroStore.entity.Comment")
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
	public List<?> getListCommentByProductid(String productid) {
		Query query = getCurrentSession().createQuery(
				"from Comment c where c.product.productid =" + productid);
		List<?> commentList = query.list();
		for (Object o:commentList) {
			Comment instance = (Comment) o;
			Hibernate.initialize(instance.getProduct());
			Hibernate.initialize(instance.getUser());
		}
		return commentList;
	}
}
