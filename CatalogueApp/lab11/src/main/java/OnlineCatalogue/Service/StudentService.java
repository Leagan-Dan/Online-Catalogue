package OnlineCatalogue.Service;

import OnlineCatalogue.DTOs.StudentDTOs.CreateStudentDTO;
import OnlineCatalogue.Entities.Student;
import OnlineCatalogue.IRepository.IStudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final IStudentRepository studentRepository;

    @Autowired
    public StudentService(IStudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    public List<Student> FindAll(){
        return studentRepository.FindAll();
    }

    public Student FindById(int id){
        return studentRepository.FindById(id);
    }

    public void PostDummyStudent(){
        Student student = new Student("Andrei", "Lupu", 2, 2, "mail@yahoo.com");
        studentRepository.Create(student);
    }

    public void AddStudent(String firstName, String lastName, int year, int semester, String email){
        Student student = new Student(firstName, lastName, year, semester,email);
        studentRepository.Create(student);
    }

    public void AddStudent(Student student){
        studentRepository.Create(student);
    }

    public void DeleteStudentById(int id){
        studentRepository.DeleteById(id);
    }

    public Student UpdateStudent(int id, CreateStudentDTO createStudentDTO){
        Student student = FindById(id);
        student.setFirstName(createStudentDTO.firstName);
        student.setLastName(createStudentDTO.lastName);
        student.setYear(createStudentDTO.year);
        student.setSemester(createStudentDTO.semester);
        student.setEmail(createStudentDTO.email);
        AddStudent(student);
        return student;
    }
}
