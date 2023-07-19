package OnlineCatalogue.Service;

import OnlineCatalogue.Entities.User;
import OnlineCatalogue.IRepository.IUserRepository;
import OnlineCatalogue.DTOs.UserDTOs.CreateUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private IUserRepository userRepository;

    @Autowired
    public UserService(IUserRepository userRepository) { this.userRepository = userRepository;}

    public List<User> FindAll() {return userRepository.FindAll();}

    public User FindById(int id) {return userRepository.FindById(id);}

    public void AddUser(User user) {userRepository.Create(user);}

    public void DeleteUSer(int id) {userRepository.DeleteById(id);}

    public User UpdateUser(int id, CreateUserDTO createUserDTO){
        User user = FindById(id);
        user.setUsername(createUserDTO.username);
        user.setPassword(createUserDTO.password);
        AddUser(user);
        return user;
    }
}
