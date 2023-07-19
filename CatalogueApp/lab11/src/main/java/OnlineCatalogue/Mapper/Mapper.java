package OnlineCatalogue.Mapper;

import OnlineCatalogue.DTOs.SubjectDTOs.CreateSubjectDTO;
import OnlineCatalogue.DTOs.GradeDTOs.CreateGradeDTO;
import OnlineCatalogue.DTOs.GradeDTOs.GradeDTO;
import OnlineCatalogue.DTOs.StudentDTOs.CreateStudentDTO;
import OnlineCatalogue.DTOs.StudentDTOs.StudentDTO;
import OnlineCatalogue.DTOs.SubjectDTOs.SubjectDTO;
import OnlineCatalogue.DTOs.UserDTOs.CreateUserDTO;
import OnlineCatalogue.DTOs.UserDTOs.UserDTO;
import OnlineCatalogue.Entities.Grade;
import OnlineCatalogue.Entities.Student;
import OnlineCatalogue.Entities.Subject;
import OnlineCatalogue.Entities.User;
import OnlineCatalogue.IRepository.IStudentRepository;
import OnlineCatalogue.IRepository.ISubjectRepository;
import OnlineCatalogue.Repository.StudentRepository;
import OnlineCatalogue.Repository.SubjectRepository;

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
        gradeDTO.grade = grade.getGrade();
        return gradeDTO;
    }

    public Grade ToGrade(CreateGradeDTO createGradeDTO){return new Grade(studentRepository.FindById(createGradeDTO.studentId),
                                                                         subjectRepository.FindById(createGradeDTO.subjectId),
                                                                          createGradeDTO.grade);}


}
