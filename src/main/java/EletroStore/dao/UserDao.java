/**
 * 
 */
package EletroStore.dao;
import java.util.List;

import EletroStore.entity.User;

/**
 * @author HNP
 * 
 */

public interface UserDao {

	public void persist(User transientInstance);

	public void attachDirty(User instance);

	public void delete(User persistentInstance);

	public User merge(User detachedInstance);
	
	public void update(User detachedInstance);

	public User findById(java.lang.Integer id);

	public List<?> getAllUser();

	public List<?> findByExample(User instance);
	
	public Object uniqueQuery(String hql);
	
	public List<?> listQuery(String hql);
}
