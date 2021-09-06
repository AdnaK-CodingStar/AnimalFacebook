package business.facade;

import business.model.Pet;
import business.model.Post;
import business.model.User;
import java.util.List;

/**
 *
 * @author AdnaK
 */
public abstract class Facade
{
    public User login(String username, String password);
    
    public List<User> getAllUsers();
    
    public List<Pet> getAllPets();
    
    public List<Post> getAllPosts();
    
    public User findUserByUsername(String username);
    
    public User saveUser(User user);
}
