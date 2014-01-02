/**
 * 
 */
package EletroStore.dao;
import java.util.List;

import EletroStore.entity.Orders;
import EletroStore.entity.User;

/**
 * @author HNP
 * 
 */

public interface OrdersDao {

	public void persist(Orders transientInstance);

	public void attachDirty(Orders instance);

	public void delete(Orders persistentInstance);

	public Orders merge(Orders detachedInstance);
	
	public void update(Orders detachedInstance);

	public Orders findById(java.lang.Integer id);

	public List<?> getAllOrders();

	public List<?> findByExample(Orders instance);

	public List<Orders> getListOrderByUser(User user, int filterorder);
}
