/**
 * 
 */
package EletroStore.dao;
import java.util.List;

import EletroStore.entity.Advertisement;

/**
 * @author HNP
 * 
 */

public interface AdvertisementDao {

	public void persist(Advertisement transientInstance);

	public void attachDirty(Advertisement instance);

	public void delete(Advertisement persistentInstance);

	public Advertisement merge(Advertisement detachedInstance);
	
	public void update(Advertisement detachedInstance);

	public Advertisement findById(java.lang.Integer id);

	public List<?> getAllAdvertisement();

	public List<?> findByExample(Advertisement instance);
}
