package lab11.compulsory.Controller;

import lab11.compulsory.DTOs.CreateStudentDTO;
import lab11.compulsory.DTOs.StudentDTO;
import lab11.compulsory.Entities.Student;
import lab11.compulsory.Mapper.Mapper;
import lab11.compulsory.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private final Mapper mapper= new Mapper();
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
    public List<StudentDTO> GetStudents() {
       return studentService.FindAll().stream().map(mapper::ToStudentDTO).toList();
    }

    @GetMapping("/get/student")
    public StudentDTO GetStudent(@RequestParam(name = "id") int id){
        return mapper.ToStudentDTO(studentService.FindById(id));
    }

    @PostMapping("/add/student")
    public boolean AddStudent(@RequestParam(name = "firstName") String firstName,
                              @RequestParam(name = "lastName") String lastName,
                              @RequestParam(name = "year") int year,
                              @RequestParam(name = "semester") int semester,
                              @RequestParam(name = "email") String email){
        CreateStudentDTO createStudentDTO = new CreateStudentDTO(firstName, lastName, year, semester, email);
        studentService.AddStudent(mapper.ToStudent(createStudentDTO));
        return true;
    }

    @PutMapping("/update/student")
    public StudentDTO UpdateStudent(@RequestParam(name = "id") int id,
                                 @RequestParam(name = "firstName") String firstName,
                                 @RequestParam(name = "lastName") String lastName,
                                 @RequestParam(name = "year") int year,
                                 @RequestParam(name = "semester") int semester,
                                 @RequestParam(name = "email") String email){
        return mapper.ToStudentDTO(studentService.UpdateStudent(id, new CreateStudentDTO(firstName,lastName,year,semester,email)));
    }

    @DeleteMapping("/delete/student")
    public boolean DeleteStudent(@RequestParam(name = "id") int id){
        studentService.DeleteStudentById(id);
        return true;
    }
}
