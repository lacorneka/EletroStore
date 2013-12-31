/**
 * 
 */
package EletroStore.dao;
import java.util.List;

import EletroStore.entity.Product;

/**
 * @author HNP
 * 
 */

public interface ProductDao {

	public void persist(Product transientInstance);

	public void attachDirty(Product instance);

	public void delete(Product persistentInstance);

	public Product merge(Product detachedInstance);
	
	public void update(Product detachedInstance);

	public Product findById(java.lang.Integer id);

	public List<?> getAllProduct();

	public List<?> findByExample(Product instance);
	
	public List<Product> getProductList(String productcatalogid);

}
