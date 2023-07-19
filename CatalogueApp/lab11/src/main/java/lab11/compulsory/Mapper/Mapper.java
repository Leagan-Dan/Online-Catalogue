package lab11.compulsory.Mapper;

import lab11.compulsory.DTOs.GradeDTOs.CreateGradeDTO;
import lab11.compulsory.DTOs.GradeDTOs.GradeDTO;
import lab11.compulsory.DTOs.StudentDTOs.CreateStudentDTO;
import lab11.compulsory.DTOs.StudentDTOs.StudentDTO;
import lab11.compulsory.DTOs.SubjectDTOs.CreateSubjectDTO;
import lab11.compulsory.DTOs.SubjectDTOs.SubjectDTO;
import lab11.compulsory.DTOs.UserDTOs.CreateUserDTO;
import lab11.compulsory.DTOs.UserDTOs.UserDTO;
import lab11.compulsory.Entities.Grade;
import lab11.compulsory.Entities.Student;
import lab11.compulsory.Entities.Subject;
import lab11.compulsory.Entities.User;
import lab11.compulsory.IRepository.IStudentRepository;
import lab11.compulsory.IRepository.ISubjectRepository;
import lab11.compulsory.Repository.StudentRepository;
import lab11.compulsory.Repository.SubjectRepository;

import java.util.Map;

public class Mapper {

    private final ISubjectRepository subjectRepository = new SubjectRepository();
    private final IStudentRepository studentRepository = new StudentRepository();


    public StudentDTO ToStudentDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.id = student.getId();
        studentDTO.firstName = student.getFirstName();
        studentDTO.lastName = student.getLastName();
        studentDTO.year = student.getYear();
        studentDTO.semester = student.getSemester();
        studentDTO.email = student.getEmail();
        return studentDTO;
    }

    public Student ToStudent(CreateStudentDTO createStudentDTO){
        return new Student(createStudentDTO.firstName, createStudentDTO.lastName, createStudentDTO.year, createStudentDTO.semester, createStudentDTO.email);
    }

    public SubjectDTO ToSubjectDTO(Subject subject){
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.id = subject.getId();
        subjectDTO.name = subject.name();
        subjectDTO.credits = subject.credits();
        return subjectDTO;
    }

    public Subject ToSubject(CreateSubjectDTO createSubjectDTO){
        return new Subject(createSubjectDTO.name, createSubjectDTO.credits);
    }

    public UserDTO ToUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.id = user.getId();
        userDTO.username = user.getUsername();
        userDTO.password = user.getPassword();
        return userDTO;
    }

    public User ToUser(CreateUserDTO createUserDTO){
        return new User(createUserDTO.username, createUserDTO.password);
    }


    public GradeDTO ToGradeDTO(Grade grade){
        GradeDTO gradeDTO = new GradeDTO();
        gradeDTO.id = grade.getId();
        gradeDTO.student = ToStudentDTO(grade.getStudent());
        gradeDTO.subject = ToSubjectDTO(grade.getSubject());
        return gradeDTO;
    }

    public Grade ToGrade(CreateGradeDTO createGradeDTO){return new Grade(studentRepository.FindById(createGradeDTO.studentId),
                                                                         subjectRepository.FindById(createGradeDTO.subjectId),
                                                                          createGradeDTO.grade);}


}
