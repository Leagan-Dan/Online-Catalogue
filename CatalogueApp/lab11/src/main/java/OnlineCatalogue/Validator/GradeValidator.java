package OnlineCatalogue.Validator;

import OnlineCatalogue.DTOs.GradeDTOs.CreateGradeDTO;
import org.springframework.http.ResponseEntity;

public class GradeValidator {

    public ResponseEntity<?> Validate(CreateGradeDTO createGradeDTO){
        if(createGradeDTO.grade < 1 || createGradeDTO.grade > 10){
            return ResponseEntity.badRequest().body("Grade must be between 1 and 10.");
        }
        return ResponseEntity.ok("Grade added successfully.");
    }
}
