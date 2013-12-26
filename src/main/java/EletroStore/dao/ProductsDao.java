/**
 * 
 */
package EletroStore.dao;
import java.util.List;

import EletroStore.entity.Products;

/**
 * @author HNP
 * 
 */

public interface ProductsDao {

	public void persist(Products transientInstance);

	public void attachDirty(Products instance);

	public void delete(Products persistentInstance);

	public Products merge(Products detachedInstance);
	
	public void update(Products detachedInstance);

	public Products findById(java.lang.Integer id);

	public List<?> getAllProducts();

	public List<?> findByExample(Products instance);
}
