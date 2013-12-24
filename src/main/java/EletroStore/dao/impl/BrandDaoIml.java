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

	private static Logger log = LoggerFactory.getLogger(BrandDaoIml.class);

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void persist(Brand transientInstance) {
		log.debug("persisting Brand instance");
		try {
			getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	@Transactional(readOnly=false)
	public void attachDirty(Brand instance) {
		log.debug("attaching dirty Brand instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	@Transactional
	public void delete(Brand persistentInstance) {
		log.debug("deleting Brand instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	@Transactional
	public Brand merge(Brand detachedInstance) {
		log.debug("merging Brand instance");
		try {
			Brand result = (Brand) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	
	@Transactional
	public Brand findById(java.lang.Integer id) {
		log.debug("getting Brand instance with id: " + id);
		try {
			Brand instance = (Brand) getCurrentSession().get(
					"EletroStore.dao.Brand", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Transactional
	public List<?> findByExample(Brand instance) {
		log.debug("finding Brand instance by example");
		try {
			List<?> results = getCurrentSession()
					.createCriteria("EletroStore.dao.Brand")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
