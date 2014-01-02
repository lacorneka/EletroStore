/**
 * 
 */
package EletroStore.dao;
import java.util.List;

import EletroStore.entity.Productcatalog;

/**
 * @author HNP
 * 
 */

public interface CategoryDao {
	
	public void persist(Productcatalog transientInstance);
	
	public void attachDirty(Productcatalog instance);	
	
	public List<?> getAllCategory();
	
	public void delete(Productcatalog persistentInstance);
	
	public Productcatalog merge(Productcatalog detachedInstance);
	
	public void update(Productcatalog detachedInstance);
	
	public Productcatalog findById(java.lang.Integer id);
	
	public List<?> findByExample(Productcatalog instance);

	public int pagecount(String productname, String productcatalog,
			String[] brands, String[] conditions, String rating,
			int productonpage, String minprice, String maxprice);

}
