package lab11.compulsory.Controller;

import lab11.compulsory.Entities.Student;
import lab11.compulsory.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/update/student")
    public boolean UpdateStudent(@RequestParam(name = "id") int id,
                                 @RequestParam(name = "firstName") String firstName,
                                 @RequestParam(name = "lastName") String lastName,
                                 @RequestParam(name = "year") int year,
                                 @RequestParam(name = "semester") int semester,
                                 @RequestParam(name = "email") String email){
        Student student = studentService.FindById(id);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setYear(year);
        student.setSemester(semester);
        student.setEmail(email);
        studentService.AddStudent(student);
        return true;
    }

    @DeleteMapping("/delete/student")
    public boolean DeleteStudent(@RequestParam(name = "id") int id){
        studentService.DeleteStudentById(id);
        return true;
    }
}
