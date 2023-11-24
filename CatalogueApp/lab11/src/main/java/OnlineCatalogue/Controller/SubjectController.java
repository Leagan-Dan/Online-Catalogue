package OnlineCatalogue.Controller;

import OnlineCatalogue.DTOs.SubjectDTOs.CreateSubjectDTO;
import OnlineCatalogue.DTOs.SubjectDTOs.SubjectDTO;
import OnlineCatalogue.Mapper.Mapper;
import OnlineCatalogue.Response.ApiResponse;
import OnlineCatalogue.Service.SubjectService;
import OnlineCatalogue.Validator.SubjectValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SubjectController {

    private final Mapper mapper = new Mapper();
    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService){
        this.subjectService = subjectService;
    }

    @GetMapping("/get/subjects")
    public List<SubjectDTO> GetSubjects(){
        return subjectService.FindAll().stream().map(mapper::ToSubjectDTO).toList();
    }

    @GetMapping("/get/subject")
    public ApiResponse<SubjectDTO> GetSubject(@RequestParam(name = "id") int id){
        SubjectValidator subjectValidator = new SubjectValidator();
        if(subjectValidator.ValidateId(id).equals(ResponseEntity.ok("Id found."))){
            return new ApiResponse<SubjectDTO>("Subject found.", mapper.ToSubjectDTO(subjectService.FindById(id)));
        }
        return new ApiResponse<SubjectDTO>("Subject not found.");
    }


    @PostMapping("/add/subject")
    public ResponseEntity<?> AddSubject(@RequestParam(name = "name") String name,
                              @RequestParam(name = "credits") int credits){
        CreateSubjectDTO createSubjectDTO = new CreateSubjectDTO(name,credits);
        SubjectValidator subjectValidator = new SubjectValidator();
        ResponseEntity<?> subjectResponse = subjectValidator.Validate(createSubjectDTO);
        if(subjectResponse.equals(ResponseEntity.ok("Subject added successfully."))) {
            subjectService.AddSubject(mapper.ToSubject(createSubjectDTO));
        }
        return subjectResponse;
    }

    @PutMapping("/update/subject")
    public ResponseEntity<?> UpdateSubject(@RequestParam(name = "id") int id,
                                    @RequestParam(name = "name") String name,
                                    @RequestParam(name = "credits") int credits){
        CreateSubjectDTO createSubjectDTO = new CreateSubjectDTO(name,credits);
        SubjectValidator subjectValidator = new SubjectValidator();
        ResponseEntity<?> subjectResponse = subjectValidator.Validate(id, createSubjectDTO);
        if(subjectResponse.equals(ResponseEntity.ok("Subject updated successfully."))) {
            subjectService.UpdateSubject(id, new CreateSubjectDTO(name, credits));
        }
        return subjectResponse;
    }

    @DeleteMapping("/delete/subject")
    public ResponseEntity<?> DeleteSubject(@RequestParam(name = "id") int id){
        SubjectValidator subjectValidator = new SubjectValidator();
        ResponseEntity<?> subjectResponse = subjectValidator.ValidateId(id);
        if(subjectResponse.equals(ResponseEntity.ok("Id found."))) {
            subjectService.DeleteSubject(id);
            return ResponseEntity.ok("Subject deleted successfully.");
        }
        return subjectResponse;
    }

}
