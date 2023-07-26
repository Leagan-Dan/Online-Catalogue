package OnlineCatalogue.Controller;

import OnlineCatalogue.DTOs.StudentDTOs.CreateStudentDTO;
import OnlineCatalogue.Entities.Student;
import OnlineCatalogue.Mapper.Mapper;
import OnlineCatalogue.DTOs.StudentDTOs.StudentDTO;
import OnlineCatalogue.Response.ApiResponse;
import OnlineCatalogue.Service.StudentService;
import OnlineCatalogue.Validator.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ApiResponse<StudentDTO> GetStudent(@RequestParam(name = "id") int id){
        StudentValidator studentValidator = new StudentValidator();
        if(studentValidator.ValidateId(id).equals(ResponseEntity.ok("Id found."))){
            return new ApiResponse<StudentDTO>("Student found.", mapper.ToStudentDTO(studentService.FindById(id)));
        }
        return new ApiResponse<StudentDTO>("Student not found.");
    }

    @PostMapping("/add/student")
    public ResponseEntity<?> AddStudent(@RequestParam(name = "firstName") String firstName,
                              @RequestParam(name = "lastName") String lastName,
                              @RequestParam(name = "year") int year,
                              @RequestParam(name = "semester") int semester,
                              @RequestParam(name = "email") String email){
        CreateStudentDTO createStudentDTO = new CreateStudentDTO(firstName, lastName, year, semester, email);
        StudentValidator studentValidator = new StudentValidator();
        ResponseEntity<?> studentResponse = studentValidator.Validate(createStudentDTO);
        if(studentResponse.equals(ResponseEntity.ok("Student added successfully."))) {
            studentService.AddStudent(mapper.ToStudent(createStudentDTO));
        }
        return studentResponse;
    }

    @PutMapping("/update/student")
    public ResponseEntity<?> UpdateStudent(@RequestParam(name = "id") int id,
                                 @RequestParam(name = "firstName") String firstName,
                                 @RequestParam(name = "lastName") String lastName,
                                 @RequestParam(name = "year") int year,
                                 @RequestParam(name = "semester") int semester,
                                 @RequestParam(name = "email") String email){
        CreateStudentDTO createStudentDTO = new CreateStudentDTO(firstName,lastName,year,semester,email);
        StudentValidator studentValidator = new StudentValidator();
        ResponseEntity<?> studentResponse = studentValidator.Validate(id, createStudentDTO);
        if(studentResponse.equals(ResponseEntity.ok("Student updated successfully."))){
            studentService.UpdateStudent(id, createStudentDTO);
        }
        return studentResponse;
    }

    @DeleteMapping("/delete/student")
    public ResponseEntity<?> DeleteStudent(@RequestParam(name = "id") int id){
        StudentValidator studentValidator = new StudentValidator();
        ResponseEntity<?> studentResponse = studentValidator.ValidateId(id);
        if(studentResponse.equals(ResponseEntity.ok("Id found."))){
            studentService.DeleteStudentById(id);
            return ResponseEntity.ok("Student deleted successfully.");
        }
        return studentResponse;
    }
}
