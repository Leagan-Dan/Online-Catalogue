package lab11.compulsory.Mapper;

import lab11.compulsory.DTOs.StudentDTOs.CreateStudentDTO;
import lab11.compulsory.DTOs.StudentDTOs.StudentDTO;
import lab11.compulsory.DTOs.SubjectDTOs.CreateSubjectDTO;
import lab11.compulsory.DTOs.SubjectDTOs.SubjectDTO;
import lab11.compulsory.Entities.Student;
import lab11.compulsory.Entities.Subject;

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
}
