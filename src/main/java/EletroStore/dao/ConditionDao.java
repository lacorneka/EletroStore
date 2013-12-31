/**
 * 
 */
package EletroStore.dao;
import java.util.List;

import EletroStore.entity.Condition;

/**
 * @author HNP
 * 
 */

public interface ConditionDao {

	public void persist(Condition transientInstance);

	public void attachDirty(Condition instance);

	public void delete(Condition persistentInstance);

	public Condition merge(Condition detachedInstance);
	
	public void update(Condition detachedInstance);

	public Condition findById(java.lang.Integer id);

	public List<?> getAllCondition();

	public List<?> findByExample(Condition instance);
}
