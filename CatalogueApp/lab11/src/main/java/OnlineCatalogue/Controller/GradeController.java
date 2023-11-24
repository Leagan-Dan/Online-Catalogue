package OnlineCatalogue.Controller;

import OnlineCatalogue.DTOs.GradeDTOs.CreateGradeDTO;
import OnlineCatalogue.DTOs.GradeDTOs.GradeDTO;
import OnlineCatalogue.Entities.Grade;
import OnlineCatalogue.Mapper.Mapper;
import OnlineCatalogue.Response.ApiResponse;
import OnlineCatalogue.Service.GradeService;
import OnlineCatalogue.Validator.GradeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class GradeController {

    private final Mapper mapper = new Mapper();
    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService){
        this.gradeService = gradeService;
    }

    @GetMapping("/get/grades")
    public List<GradeDTO> GetGrades(){
        return gradeService.FindAll().stream().map(mapper::ToGradeDTO).toList();
    }

    @GetMapping("/get/grade")
    public ApiResponse<GradeDTO> GetGrade(@RequestParam(name = "id") int id){
        GradeValidator gradeValidator = new GradeValidator();
        if(gradeValidator.ValidateId(id).equals(ResponseEntity.ok("Id found."))){
            return new ApiResponse<GradeDTO>("Grade found.",  mapper.ToGradeDTO(gradeService.FindById(id)));
        }
        return new ApiResponse<GradeDTO>("Grade not found.");
    }

    @PostMapping("/add/grade")
    public ResponseEntity<?> AddGrade(@RequestParam(name = "studentId") int studentId,
                                   @RequestParam(name = "subjectId") int subjectId,
                                   @RequestParam(name = "grade") int grade){
        CreateGradeDTO createGradeDTO = new CreateGradeDTO(studentId, subjectId, grade);
        GradeValidator gradeValidator = new GradeValidator();
        ResponseEntity<?> gradeResponse = gradeValidator.Validate(createGradeDTO);
        if(gradeResponse.equals(ResponseEntity.ok("Grade added successfully."))) {
            gradeService.AddGrade(mapper.ToGrade(createGradeDTO));
        }
        return gradeResponse;
    }

    @PutMapping("/update/grade")
    public ResponseEntity<?> UpdateGrade(@RequestParam(name = "id") long id,
                                @RequestParam(name = "studentId") int studentId,
                                @RequestParam(name = "subjectId") int subjectId,
                                @RequestParam(name = "grade") int grade){
        CreateGradeDTO createGradeDTO = new CreateGradeDTO(studentId,subjectId,grade);
        GradeValidator gradeValidator = new GradeValidator();
        ResponseEntity<?> gradeResponse = gradeValidator.ValidateUpdate(id, createGradeDTO);
        if(gradeResponse.equals(ResponseEntity.ok("Grade updated successfully."))) {
            gradeService.UpdateGrade(id, createGradeDTO);
        }
        return gradeResponse;
    }

    @DeleteMapping("/delete/grade")
    public ResponseEntity<?> DeleteGrade(@RequestParam(name = "id") int id){
        GradeValidator gradeValidator = new GradeValidator();
        ResponseEntity<?> gradeResponse = gradeValidator.ValidateId(id);
        if(gradeResponse.equals(ResponseEntity.ok("Id found."))){
            gradeService.DeleteGradeById(id);
            return ResponseEntity.ok("Grade deleted successfully.");
        }
        return gradeResponse;
    }
}