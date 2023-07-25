package OnlineCatalogue.Validator;

import OnlineCatalogue.DTOs.GradeDTOs.CreateGradeDTO;
import OnlineCatalogue.DTOs.GradeDTOs.GradeDTO;
import OnlineCatalogue.Entities.Grade;
import OnlineCatalogue.Entities.Student;
import OnlineCatalogue.Entities.Subject;
import OnlineCatalogue.Manager.Manager;
import org.springframework.http.ResponseEntity;

public class GradeValidator {

    public ResponseEntity<?> Validate(CreateGradeDTO createGradeDTO){
        if(createGradeDTO.grade < 1 || createGradeDTO.grade > 10){
            return ResponseEntity.badRequest().body("Grade must be between 1 and 10.");
        }
        if(!VerifyStudent(createGradeDTO.studentId)){
            return ResponseEntity.badRequest().body("There is no student with id " + createGradeDTO.studentId);
        }
        if(!VerifySubject(createGradeDTO.subjectId)){
            return ResponseEntity.badRequest().body("There is no subject with id " + createGradeDTO.subjectId);
        }
        return ResponseEntity.ok("Grade added successfully.");
    }

    public ResponseEntity<?> ValidateUpdate(long id, CreateGradeDTO createGradeDTO){
        if(createGradeDTO.grade < 1 || createGradeDTO.grade > 10){
            return ResponseEntity.badRequest().body("Grade must be between 1 and 10.");
        }
        if(!VerifyId(id)){
            return ResponseEntity.badRequest().body("There is no grade with id " + id);
        }
        if(!VerifyStudent(createGradeDTO.studentId)){
            return ResponseEntity.badRequest().body("There is no student with id " + createGradeDTO.studentId);
        }
        if(!VerifySubject(createGradeDTO.subjectId)){
            return ResponseEntity.badRequest().body("There is no subject with id " + createGradeDTO.subjectId);
        }
        return ResponseEntity.ok("Grade updated successfully.");
    }

    public ResponseEntity<?> ValidateId(long id){
        if(!VerifyId(id)){
            return ResponseEntity.badRequest().body("There is no grade with id " + id);
        }
        return ResponseEntity.ok("Id found.");
    }

    private boolean VerifyStudent(int id){
        return Manager.getInstance().getManager().find(Student.class, id) != null;
    }

    private boolean VerifySubject(int id){
        return Manager.getInstance().getManager().find(Subject.class, id) != null;
    }

    private boolean VerifyId(long id){
        return Manager.getInstance().getManager().find(Grade.class, id) != null;
    }
}
