/**
 * 
 */
package EletroStore.dao;
import java.util.List;

import EletroStore.entity.Comment;

/**
 * @author HNP
 * 
 */

public interface CommentDao {

	public void persist(Comment transientInstance);

	public void attachDirty(Comment instance);

	public void delete(Comment persistentInstance);

	public Comment merge(Comment detachedInstance);
	
	public void update(Comment detachedInstance);

	public Comment findById(java.lang.Integer id);

	public List<?> getAllComment();

	public List<?> findByExample(Comment instance);

	public List<?> getListCommentByProductid(String productid);
}
