package OnlineCatalogue.IRepository;

import OnlineCatalogue.Entities.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserRepository {
    public User FindById(int id);
    public User FindByUsername(String username);
    public List<User> FindAll();
    public void Create(User user);
    public void DeleteById(int id);
}