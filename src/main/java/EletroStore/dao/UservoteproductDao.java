/**
 * 
 */
package EletroStore.dao;
import java.util.List;

import EletroStore.entity.Uservoteproduct;

/**
 * @author HNP
 * 
 */

public interface UservoteproductDao {

	public void persist(Uservoteproduct transientInstance);

	public void attachDirty(Uservoteproduct instance);

	public void delete(Uservoteproduct persistentInstance);

	public Uservoteproduct merge(Uservoteproduct detachedInstance);
	
	public void update(Uservoteproduct detachedInstance);

	public Uservoteproduct findById(java.lang.Integer id);

	public List<?> getAllUservoteproduct();

	public List<?> findByExample(Uservoteproduct instance);
}
