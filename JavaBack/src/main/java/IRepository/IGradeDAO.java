package IRepository;

import Entities.Grade;
import Entities.Student;
import Entities.Subject;

import java.util.List;

public interface IGradeDAO {
    public Grade FindById(int id);
    public Grade FindByStudentSubject(Student student, Subject subject);
    public List<Grade> FindAll();
    public void Create(Grade grade);
    public void DeleteById(long id);
}
