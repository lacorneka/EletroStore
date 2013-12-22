/**
 * 
 */
package EletroStore.dao;
import java.util.List;
import EletroStore.entity.*;

/**
 * @author HNP
 * 
 */

public interface UserDao {

	public boolean addUser(User user);

	public void updateUser(User user);

	public User getUser(int memberid);

	public User getUser(String email);

	public void deleteUser(int id);

	public List<User> getUsers();
}
