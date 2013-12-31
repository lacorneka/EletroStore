/**
 * 
 */
package EletroStore.dao;
import java.util.List;

import EletroStore.entity.Wishlist;

/**
 * @author HNP
 * 
 */

public interface WishlistDao {

	public void persist(Wishlist transientInstance);

	public void attachDirty(Wishlist instance);

	public void delete(Wishlist persistentInstance);

	public Wishlist merge(Wishlist detachedInstance);
	
	public void update(Wishlist detachedInstance);

	public Wishlist findById(java.lang.Integer id);

	public List<?> getAllWishlist();

	public List<?> findByExample(Wishlist instance);

	public boolean removeWishListByProductid(String productid);
}
