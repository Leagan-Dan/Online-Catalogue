package lab11.compulsory.DTOs.SubjectDTOs;

import lab11.compulsory.Entities.Grade;

import java.util.List;

public class SubjectDTO {
    public int id;
    public String name;
    public int credits;
    public List<Grade> subjectGrades;
}
