package lab11.compulsory.Mapper;

import lab11.compulsory.DTOs.StudentDTOs.CreateStudentDTO;
import lab11.compulsory.DTOs.StudentDTOs.StudentDTO;
import lab11.compulsory.DTOs.SubjectDTOs.CreateSubjectDTO;
import lab11.compulsory.DTOs.SubjectDTOs.SubjectDTO;
import lab11.compulsory.DTOs.UserDTOs.CreateUserDTO;
import lab11.compulsory.DTOs.UserDTOs.UserDTO;
import lab11.compulsory.Entities.Student;
import lab11.compulsory.Entities.Subject;
import lab11.compulsory.Entities.User;

public class Mapper {
    public StudentDTO ToStudentDTO(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.id = student.getId();
        studentDTO.firstName = student.getFirstName();
        studentDTO.lastName = student.getLastName();
        studentDTO.year = student.getYear();
        studentDTO.semester = student.getSemester();
        studentDTO.email = student.getEmail();
        studentDTO.grades = student.getStudentGrades();
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
}
