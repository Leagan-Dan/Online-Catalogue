package IRepository;

import Entities.User;

import java.util.List;

public interface IUserDAO {
    public User FindById(int id);
    public User FindByUsername(String username);
    public List<User> FindAll();
    public void Create(User user);
    public void DeleteById(int id);
}
