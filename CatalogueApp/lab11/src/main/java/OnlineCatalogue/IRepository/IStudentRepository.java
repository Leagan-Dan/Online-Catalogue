package OnlineCatalogue.IRepository;

import OnlineCatalogue.Entities.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStudentRepository {
    public Student FindById(int id);
    public Student FindByName(String firstName, String lastName);
    public List<Student> FindAll();
    public void Create(Student student);
    public void DeleteById(int id);
}
