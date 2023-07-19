package OnlineCatalogue.DTOs.GradeDTOs;

import OnlineCatalogue.DTOs.SubjectDTOs.SubjectDTO;
import OnlineCatalogue.DTOs.StudentDTOs.StudentDTO;


public class GradeDTO {
    public long id;
    public StudentDTO student;
    public SubjectDTO subject;
    public int grade;
}

