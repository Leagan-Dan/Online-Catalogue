package lab11.compulsory.Controller;

import lab11.compulsory.DTOs.GradeDTOs.CreateGradeDTO;
import lab11.compulsory.DTOs.GradeDTOs.GradeDTO;
import lab11.compulsory.Entities.Student;
import lab11.compulsory.Entities.Subject;
import lab11.compulsory.Mapper.Mapper;
import lab11.compulsory.Service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
    public GradeDTO GetGrade(@RequestParam(name = "id") int id){
        return mapper.ToGradeDTO(gradeService.FindById(id));
    }

    @PostMapping("/add/grade")
    public boolean AddGrade(@RequestParam(name = "studentId") int studentId,
                            @RequestParam(name = "subjectId") int subjectId,
                            @RequestParam(name = "grade") int grade){
        CreateGradeDTO createGradeDTO = new CreateGradeDTO(studentId, subjectId, grade);
        gradeService.AddGrade(mapper.ToGrade(createGradeDTO));
        return true;
    }

    @PutMapping("/update/grade")
    public GradeDTO UpdateGrade(@RequestParam(name = "id") long id,
                                @RequestParam(name = "student") int studentId,
                                @RequestParam(name = "subject") int subjectId,
                                @RequestParam(name = "grade") int grade){
        return mapper.ToGradeDTO(gradeService.UpdateGrade(id, new CreateGradeDTO(studentId,subjectId,grade)));
    }

    @DeleteMapping("/delete/grade")
    public boolean DeleteGrade(@RequestParam(name = "id") int id){
        gradeService.DeleteGradeById(id);
        return true;
    }
}