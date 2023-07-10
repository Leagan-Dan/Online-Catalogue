package lab11.compulsory.IRepository;

import lab11.compulsory.Entities.Subject;

import java.util.List;

public interface ISubjectRepository {
    public Subject FindById(int id);
    public Subject FindByName(String name);
    public List<Subject> FindAll();
    public void Create(Subject subject);
    public void DeleteById(int id);
}
