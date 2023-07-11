package lab11.compulsory.Service;

import lab11.compulsory.DTOs.GradeDTOs.CreateGradeDTO;
import lab11.compulsory.Entities.Grade;
import lab11.compulsory.IRepository.IGradeRepository;
import lab11.compulsory.IRepository.IStudentRepository;
import lab11.compulsory.IRepository.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    private final IGradeRepository gradeRepository;
    private final IStudentRepository studentRepository;
    private final ISubjectRepository subjectRepository;

    @Autowired
    public GradeService(IGradeRepository gradeRepository, IStudentRepository studentRepository, ISubjectRepository subjectRepository) {
        this.gradeRepository = gradeRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
    }

    public Grade FindById(long id) {return gradeRepository.FindById(id);}

    public List<Grade> FindAll(){return gradeRepository.FindAll();}

    public void AddGrade(Grade grade) {gradeRepository.Create(grade);}

    public void DeleteGradeById(int id) {gradeRepository.DeleteById(id);}

    public Grade UpdateGrade(long id, CreateGradeDTO createGradeDTO){
        Grade grade = FindById(id);
        grade.setStudent(studentRepository.FindById(createGradeDTO.studentId));
        grade.setSubject(subjectRepository.FindById(createGradeDTO.subjectId));
        grade.setGrade(createGradeDTO.grade);
        return grade;
    }
}

