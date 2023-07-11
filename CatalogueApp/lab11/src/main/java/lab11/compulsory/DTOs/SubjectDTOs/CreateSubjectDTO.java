package lab11.compulsory.DTOs.SubjectDTOs;

import lab11.compulsory.Entities.Grade;

import java.util.List;

public class CreateSubjectDTO {
    public String name;
    public int credits;
    public List<Grade> subjectGrades;

    public CreateSubjectDTO(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }
}
