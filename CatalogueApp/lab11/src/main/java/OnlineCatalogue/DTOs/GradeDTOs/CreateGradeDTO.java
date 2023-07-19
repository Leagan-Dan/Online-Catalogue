package OnlineCatalogue.DTOs.GradeDTOs;


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

