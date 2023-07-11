package lab11.compulsory.DTOs.UserDTOs;

public class CreateUserDTO {
    public String username;
    public String password;

    public CreateUserDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
