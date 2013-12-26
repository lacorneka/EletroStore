/**
 * 
 */
package EletroStore.dao;
import java.util.List;

import EletroStore.entity.Deals;

/**
 * @author HNP
 * 
 */

public interface DealsDao {

	public void persist(Deals transientInstance);

	public void attachDirty(Deals instance);

	public void delete(Deals persistentInstance);

	public Deals merge(Deals detachedInstance);
	
	public void update(Deals detachedInstance);

	public Deals findById(java.lang.Integer id);

	public List<?> getAllDeals();

	public List<?> findByExample(Deals instance);
}
