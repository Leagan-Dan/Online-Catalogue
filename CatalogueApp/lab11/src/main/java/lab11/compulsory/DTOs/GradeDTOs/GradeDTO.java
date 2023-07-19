package lab11.compulsory.DTOs.GradeDTOs;

import lab11.compulsory.DTOs.StudentDTOs.StudentDTO;
import lab11.compulsory.DTOs.SubjectDTOs.SubjectDTO;
import lab11.compulsory.Entities.Student;
import lab11.compulsory.Entities.Subject;


public class GradeDTO {
    public long id;
    public StudentDTO student;
    public SubjectDTO subject;
    public int grade;
}

