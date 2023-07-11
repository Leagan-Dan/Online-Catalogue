package lab11.compulsory.DTOs.GradeDTOs;

import lab11.compulsory.Entities.Student;
import lab11.compulsory.Entities.Subject;


public class CreateGradeDTO {
    public int studentId;
    public int subjectId;
    public int grade;

    public CreateGradeDTO(int studentId, int subjectId, int grade) {
        this.studentId = studentId;
        this.subjectId = subjectId;
        this.grade = grade;
    }
}

