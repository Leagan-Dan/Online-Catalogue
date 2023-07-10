package lab11.compulsory.Service;

import lab11.compulsory.Entities.Student;
import lab11.compulsory.IRepository.IStudentRepository;
import lab11.compulsory.Repository.StudentRepository;
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

    public void PostDummyStudent(){
        Student student = new Student("Andrei", "Lupu", 2, 2, "mail@yahoo.com");
        studentRepository.Create(student);
    }

    public void AddStudent(String firstName, String lastName, int year, int semester, String email){
        Student student = new Student(firstName, lastName, year, semester,email);
        studentRepository.Create(student);
    }
}
