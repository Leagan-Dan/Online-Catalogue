package lab11.compulsory.Mapper;

import lab11.compulsory.DTOs.CreateStudentDTO;
import lab11.compulsory.DTOs.StudentDTO;
import lab11.compulsory.Entities.Student;

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
}
