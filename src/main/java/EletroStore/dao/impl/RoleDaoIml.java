package EletroStore.dao.impl;

// Generated Dec 22, 2013 12:58:45 PM by Hibernate Tools 4.0.0

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import EletroStore.dao.RoleDao;
import EletroStore.entity.Userroles;


/**
 * Home object for domain model class Userroles.
 * @see EletroStore.dao.Userroles
 * @author Hibernate Tools
 */
@Repository("roleDao")
public class RoleDaoIml implements RoleDao{

	private static Logger log = LoggerFactory.getLogger(RoleDaoIml.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void persist(Userroles transientInstance) {
		log.debug("persisting Userroles instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Userroles instance) {
		log.debug("attaching dirty Userroles instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Userroles persistentInstance) {
		log.debug("deleting Userroles instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Userroles merge(Userroles detachedInstance) {
		log.debug("merging Userroles instance");
		try {
			Userroles result = (Userroles) sessionFactory.getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Userroles findById(java.lang.Integer id) {
		log.debug("getting Userroles instance with id: " + id);
		try {
			Userroles instance = (Userroles) sessionFactory.getCurrentSession()
					.get("EletroStore.dao.Userroles", id);
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

	public List<?> findByExample(Userroles instance) {
		log.debug("finding Userroles instance by example");
		try {
			List<?> results = sessionFactory.getCurrentSession()
					.createCriteria("EletroStore.dao.Userroles")
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
