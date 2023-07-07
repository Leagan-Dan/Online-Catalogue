package IRepository;

import Entities.Subject;

import java.util.List;

public interface ISubjectDAO {
    public Subject FindById(int id);
    public Subject FindByName(String name);
    public List<Subject> FindAll();
    public void Create(Subject subject);
    public void DeleteById(int id);
}
