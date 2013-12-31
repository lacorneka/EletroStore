/**
 * 
 */
package EletroStore.dao;
import java.util.List;

import EletroStore.entity.Userroles;

/**
 * @author HNP
 * 
 */

public interface UserrolesDao {

	public void persist(Userroles transientInstance);

	public void attachDirty(Userroles instance);

	public void delete(Userroles persistentInstance);

	public Userroles merge(Userroles detachedInstance);
	
	public void update(Userroles detachedInstance);

	public Userroles findById(java.lang.Integer id);

	public List<?> getAllUserroles();

	public List<?> findByExample(Userroles instance);
}
