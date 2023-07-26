package OnlineCatalogue.Validator;

import OnlineCatalogue.DTOs.SubjectDTOs.CreateSubjectDTO;
import OnlineCatalogue.Entities.Grade;
import OnlineCatalogue.Entities.Subject;
import OnlineCatalogue.Manager.Manager;
import org.springframework.http.ResponseEntity;

public class SubjectValidator {
    public ResponseEntity<?> Validate(CreateSubjectDTO createSubjectDTO){
        if(createSubjectDTO.credits < 4 || createSubjectDTO.credits > 6){
            return ResponseEntity.badRequest().body("Credits must be between 4 and 6.");
        }
        return ResponseEntity.ok("Subject added successfully.");
    }

    public ResponseEntity<?> Validate(int id, CreateSubjectDTO createSubjectDTO){
        if(!VerifyId(id)){
            return ResponseEntity.badRequest().body("There is no subject with id " + id);
        }
        if(createSubjectDTO.credits < 4 || createSubjectDTO.credits > 6){
            return ResponseEntity.badRequest().body("Credits must be between 4 and 6.");
        }
        return ResponseEntity.ok("Subject updated successfully.");
    }

    public ResponseEntity<?> ValidateId(int id){
        if(!VerifyId(id)){
            return ResponseEntity.badRequest().body("There is no subject with id " + id);
        }
        return ResponseEntity.ok("Id found.");
    }

    private boolean VerifyId(int id){
        return Manager.getInstance().getManager().find(Subject.class, id) != null;
    }

}
