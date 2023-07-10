package lab11.compulsory.IRepository;

import lab11.compulsory.Entities.Grade;
import lab11.compulsory.Entities.Student;
import lab11.compulsory.Entities.Subject;

import java.util.List;

public interface IGradeRepository {
    public Grade FindById(int id);
    public Grade FindByStudentSubject(Student student, Subject subject);
    public List<Grade> FindAll();
    public void Create(Grade grade);
    public void DeleteById(long id);
}
