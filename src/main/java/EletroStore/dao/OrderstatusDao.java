/**
 * 
 */
package EletroStore.dao;
import java.util.List;

import EletroStore.entity.Orderstatus;

/**
 * @author HNP
 * 
 */

public interface OrderstatusDao {

	public void persist(Orderstatus transientInstance);

	public void attachDirty(Orderstatus instance);

	public void delete(Orderstatus persistentInstance);

	public Orderstatus merge(Orderstatus detachedInstance);
	
	public void update(Orderstatus detachedInstance);

	public Orderstatus findById(java.lang.Integer id);

	public List<?> getAllOrderstatus();

	public List<?> findByExample(Orderstatus instance);
}
