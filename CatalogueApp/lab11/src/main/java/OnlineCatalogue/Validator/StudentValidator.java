package OnlineCatalogue.Validator;

import OnlineCatalogue.DTOs.GradeDTOs.CreateGradeDTO;
import OnlineCatalogue.DTOs.StudentDTOs.CreateStudentDTO;
import OnlineCatalogue.Entities.Student;
import OnlineCatalogue.Manager.Manager;
import org.springframework.http.ResponseEntity;

public class StudentValidator {

    public ResponseEntity<?> Validate(CreateStudentDTO createStudentDTO){
        if(createStudentDTO.semester < 1 || createStudentDTO.semester > 2){
            return ResponseEntity.badRequest().body("Invalid semester.");
        }
        if(createStudentDTO.year < 1 || createStudentDTO.year > 3){
            return ResponseEntity.badRequest().body("Invalid year.");
        }
        return ResponseEntity.ok("Student added successfully.");
    }

    public ResponseEntity<?> Validate(int id, CreateStudentDTO createStudentDTO){
        if(!VerifyId(id)){
            return ResponseEntity.badRequest().body("There is no student with id " + id);
        }
        if(createStudentDTO.semester < 1 || createStudentDTO.semester > 2){
            return ResponseEntity.badRequest().body("Invalid semester.");
        }
        if(createStudentDTO.year < 1 || createStudentDTO.year > 3){
            return ResponseEntity.badRequest().body("Invalid year.");
        }
        return ResponseEntity.ok("Student updated successfully.");
    }

    public ResponseEntity<?> ValidateId(int id) {
        if (!VerifyId(id)) {
            return ResponseEntity.badRequest().body("There is no student with id " + id);
        }
        return ResponseEntity.ok("Id found.");
    }

    private boolean VerifyId(int id){
        return Manager.getInstance().getManager().find(Student.class, id) != null;}

}

