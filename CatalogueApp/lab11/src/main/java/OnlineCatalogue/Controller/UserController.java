package OnlineCatalogue.Controller;

import OnlineCatalogue.Mapper.Mapper;
import OnlineCatalogue.DTOs.UserDTOs.CreateUserDTO;
import OnlineCatalogue.DTOs.UserDTOs.UserDTO;
import OnlineCatalogue.Response.ApiResponse;
import OnlineCatalogue.Service.UserService;
import OnlineCatalogue.Validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
    public ApiResponse<UserDTO> GetUser(@RequestParam(name = "id") int id){
        UserValidator userValidator = new UserValidator();
        if(userValidator.ValidateId(id).equals(ResponseEntity.ok("Id found."))){
            return new ApiResponse<UserDTO>("User found", mapper.ToUserDTO(userService.FindById(id)));
        }
        return new ApiResponse<UserDTO>("User not found.");
    }

    @PostMapping("/add/user")
    public boolean AddUser(@RequestParam(name = "username") String username,
                           @RequestParam(name = "password") String password){
        CreateUserDTO createUserDTO = new CreateUserDTO(username, password);
        userService.AddUser(mapper.ToUser(createUserDTO));
        return true;
    }

    @PutMapping("/update/user")
    public ResponseEntity<?> UpdateUser(@RequestParam(name = "id") int id,
                                             @RequestParam(name = "username") String username,
                                             @RequestParam(name = "password") String password){
        UserValidator userValidator = new UserValidator();
        if(userValidator.ValidateId(id).equals(ResponseEntity.ok("Id found."))) {
           userService.UpdateUser(id, new CreateUserDTO(username, password));
           return ResponseEntity.ok().body("User updated successfully.");
        }
        return ResponseEntity.badRequest().body("There is no user with id " + id);
    }

    @DeleteMapping("/delete/user")
    public ResponseEntity<?> DeleteUser(@RequestParam(name = "id") int id){
        UserValidator userValidator = new UserValidator();
        ResponseEntity<?> userResponse = userValidator.ValidateId(id);
        if(userResponse.equals(ResponseEntity.ok("Id found."))) {
            userService.DeleteUSer(id);
            return ResponseEntity.ok("User deleted successfully.");
        }
        return userResponse;
    }
}
