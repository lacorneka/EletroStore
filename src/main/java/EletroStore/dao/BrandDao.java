/**
 * 
 */
package EletroStore.dao;
import java.util.List;

import EletroStore.entity.Brand;

/**
 * @author HNP
 * 
 */

public interface BrandDao {

	public void persist(Brand transientInstance);

	public void attachDirty(Brand instance);

	public void delete(Brand persistentInstance);

	public Brand merge(Brand detachedInstance);

	public Brand findById(java.lang.Integer id);

	public List<?> findByExample(Brand instance);
}
