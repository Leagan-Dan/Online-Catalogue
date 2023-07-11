package lab11.compulsory.Repository;

import lab11.compulsory.Entities.Subject;
import lab11.compulsory.Manager.Manager;
import lab11.compulsory.IRepository.ISubjectRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectRepository implements ISubjectRepository {
    public Subject FindByName(String name){
        try{
            return Manager.getInstance().getManager().createQuery("select a from Subject a.name='\" + name + \"'\"", Subject.class).getResultList().get(0);
        }catch (Exception e){
            return null;
        }
    }

    public Subject FindById(int id){
        try{
            return Manager.getInstance().getManager().find(Subject.class,id);
        }catch (Exception e) {
            return null;
        }
    }

    public void Create(Subject subject){
        if(!Manager.getInstance().getManager().getTransaction().isActive()) {
            Manager.getInstance().getManager().getTransaction().begin();
        }
        Manager.getInstance().getManager().persist(subject);
        Manager.getInstance().getManager().getTransaction().commit();
    }

    public List<Subject> FindAll(){
        try{
            return Manager.getInstance().getManager().createNamedQuery("Subject.findAll",Subject.class).getResultList();
        }catch (Exception e){
            return null;
        }
    }

    public void DeleteById(int id){
        if(!Manager.getInstance().getManager().getTransaction().isActive()) {
            Manager.getInstance().getManager().getTransaction().begin();
        }
        Subject subject = Manager.getInstance().getManager().find(Subject.class,id);
        System.out.println(subject);
        Manager.getInstance().getManager().remove(subject);
        Manager.getInstance().getManager().getTransaction().commit();
    }
}
