/**
 * 
 */
package EletroStore.dao;
import java.util.List;

import EletroStore.entity.Orderdetail;

/**
 * @author HNP
 * 
 */

public interface OrderdetailDao {

	public void persist(Orderdetail transientInstance);

	public void attachDirty(Orderdetail instance);

	public void delete(Orderdetail persistentInstance);

	public Orderdetail merge(Orderdetail detachedInstance);
	
	public void update(Orderdetail detachedInstance);

	public Orderdetail findById(java.lang.Integer id);

	public List<?> getAllOrderdetail();

	public List<?> findByExample(Orderdetail instance);
	
	public List<Orderdetail> findByOrderId(java.lang.Integer id);
}
