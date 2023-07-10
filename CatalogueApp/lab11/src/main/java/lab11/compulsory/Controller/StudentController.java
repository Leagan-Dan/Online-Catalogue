package lab11.compulsory.Controller;

import lab11.compulsory.Entities.Student;
import lab11.compulsory.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }
    @GetMapping("/get/test")
    public String GetHello()
    {
        return "This is a test.";
    }

    @GetMapping("/get/students")
    public List<Student> GetStudents() {
       return studentService.FindAll();
    }

    @PostMapping("/add/student")
    public boolean AddStudent(@RequestParam(name = "firstName") String firstName,
                              @RequestParam(name = "lastName") String lastName,
                              @RequestParam(name = "year") int year,
                              @RequestParam(name = "semester") int semester,
                              @RequestParam(name = "email") String email){
        studentService.AddStudent(firstName, lastName, year, semester, email);
        return true;
    }
}
