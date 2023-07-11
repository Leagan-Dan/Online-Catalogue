package lab11.compulsory.Controller;

import lab11.compulsory.DTOs.SubjectDTOs.CreateSubjectDTO;
import lab11.compulsory.DTOs.SubjectDTOs.SubjectDTO;
import lab11.compulsory.Mapper.Mapper;
import lab11.compulsory.Service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public SubjectDTO GetSubject(@RequestParam(name = "id") int id){
        return mapper.ToSubjectDTO(subjectService.FindById(id));
    }


    @PostMapping("/add/subject")
    public boolean AddSubject(@RequestParam(name = "name") String name,
                              @RequestParam(name = "credits") int credits){
        CreateSubjectDTO createSubjectDTO = new CreateSubjectDTO(name, credits);
        subjectService.AddSubject(mapper.ToSubject(createSubjectDTO));
        return true;
    }

    @PutMapping("/update/subject")
    public SubjectDTO UpdateSubject(@RequestParam(name = "id") int id,
                                    @RequestParam(name = "name") String name,
                                    @RequestParam(name = "credits") int credits){
        return mapper.ToSubjectDTO(subjectService.UpdateSubject(id, new CreateSubjectDTO(name,credits)));
    }

    @DeleteMapping("/delete/subject")
    public boolean DeleteSubject(@RequestParam(name = "id") int id){
        subjectService.DeleteSubject(id);
        return true;
    }

}
