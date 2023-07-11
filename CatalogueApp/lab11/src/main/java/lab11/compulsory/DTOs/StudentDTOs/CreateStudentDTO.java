package lab11.compulsory.DTOs.StudentDTOs;

import lab11.compulsory.Entities.Grade;

import java.util.List;

public class CreateStudentDTO {
    public String firstName;
    public String lastName;
    public int year;
    public int semester;
    public String email;
    public List<Grade> grades;

    public CreateStudentDTO(String firstName, String lastName, int year, int semester, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.semester = semester;
        this.email = email;
    }
}
