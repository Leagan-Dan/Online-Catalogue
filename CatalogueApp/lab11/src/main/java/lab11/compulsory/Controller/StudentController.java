package lab11.compulsory.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @GetMapping("/get/test")
    public String getHello()
    {
        return "This is a test.";
    }

}
