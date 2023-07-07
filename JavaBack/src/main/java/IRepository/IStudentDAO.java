package IRepository;

import Entities.Student;

import java.util.List;

public interface IStudentDAO {
    public Student FindById(int id);
    public Student FindByName(String firstName, String lastName);
    public List<Student> FindAll();
    public void Create(Student student);
    public void DeleteById(int id);
}
