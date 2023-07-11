package lab11.compulsory.IRepository;

import lab11.compulsory.Entities.Subject;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISubjectRepository {
    public Subject FindById(int id);
    public Subject FindByName(String name);
    public List<Subject> FindAll();
    public void Create(Subject subject);
    public void DeleteById(int id);
}
