package lab11.compulsory.Repository;

import lab11.compulsory.Entities.Student;
import lab11.compulsory.IRepository.IStudentRepository;
import lab11.compulsory.Manager.Manager;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {

    public Student FindById(int id){
        return Manager.getInstance().getManager().find(Student.class,id);
    }

    public Student FindByName(String firstName, String lastName){
        TypedQuery<Student> query = Manager.getInstance().getManager().createNamedQuery("Student.findByName",Student.class);
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        return query.getResultList().get(0);
    }

    public List<Student> FindAll(){
        try {
            return Manager.getInstance().getManager().createNamedQuery("Student.findAll", Student.class).getResultList();
        }catch (Exception e){
            return null;
        }
    }

    public void Create(Student student){
        if(!Manager.getInstance().getManager().getTransaction().isActive()) {
            Manager.getInstance().getManager().getTransaction().begin();
        }
        Manager.getInstance().getManager().persist(student);
        Manager.getInstance().getManager().getTransaction().commit();
    }

    public void DeleteById(int id){
        Student student = Manager.getInstance().getManager().find(Student.class,id);
        Manager.getInstance().getManager().remove(student);
        Manager.getInstance().getManager().getTransaction().commit();
    }
}
