package lab11.compulsory.Service;

import lab11.compulsory.DTOs.SubjectDTOs.CreateSubjectDTO;
import lab11.compulsory.Entities.Subject;
import lab11.compulsory.IRepository.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    private ISubjectRepository subjectRepository;

    @Autowired
    public SubjectService(ISubjectRepository subjectRepository){
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> FindAll(){
        return subjectRepository.FindAll();
    }

    public Subject FindById(int id){
        return subjectRepository.FindById(id);
    }

    public void AddSubject(Subject subject){
        subjectRepository.Create(subject);
    }

    public void DeleteSubject(int id){
        subjectRepository.DeleteById(id);
    }

    public Subject UpdateSubject(int id, CreateSubjectDTO createSubjectDTO){
        Subject subject = FindById(id);
        subject.setName(createSubjectDTO.name);
        subject.setCredits(createSubjectDTO.credits);
        subject.setSubjectGrades(createSubjectDTO.subjectGrades);
        AddSubject(subject);
        return subject;
    }
}
