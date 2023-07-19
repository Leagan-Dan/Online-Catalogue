package OnlineCatalogue.Controller;

import OnlineCatalogue.Mapper.Mapper;
import OnlineCatalogue.DTOs.UserDTOs.CreateUserDTO;
import OnlineCatalogue.DTOs.UserDTOs.UserDTO;
import OnlineCatalogue.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final Mapper mapper = new Mapper();
    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/get/users")
    public List<UserDTO> GetUsers(){
        return userService.FindAll().stream().map(mapper::ToUserDTO).toList();
    }

    @GetMapping("/get/user")
    public UserDTO GetUser(@RequestParam(name = "id") int id){
        return mapper.ToUserDTO(userService.FindById(id));
    }

    @PostMapping("/add/user")
    public boolean AddUser(@RequestParam(name = "username") String username,
                           @RequestParam(name = "password") String password){
        CreateUserDTO createUserDTO = new CreateUserDTO(username, password);
        userService.AddUser(mapper.ToUser(createUserDTO));
        return true;
    }

    @PutMapping("/update/user")
    public UserDTO UpdateUser(@RequestParam(name = "id") int id,
                              @RequestParam(name = "username") String username,
                              @RequestParam(name = "password") String password){
        return mapper.ToUserDTO(userService.UpdateUser(id, new CreateUserDTO(username,password)));
    }

    @DeleteMapping("/delete/user")
    public boolean DeleteUser(@RequestParam(name = "id") int id){
        userService.DeleteUSer(id);
        return true;
    }
}
