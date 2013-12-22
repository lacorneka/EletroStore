/**
 * 
 */
package EletroStore.dao;
import java.util.List;

import EletroStore.entity.*;

/**
 * @author HNP
 * 
 */

public interface RoleDao {

	public void persist(Userroles transientInstance);

	public void attachDirty(Userroles instance);

	public void delete(Userroles persistentInstance);

	public Userroles merge(Userroles detachedInstance);

	public Userroles findById(java.lang.Integer id);

	public List<?> findByExample(Userroles instance);
}
