package OnlineCatalogue.Repository;

import OnlineCatalogue.Entities.Grade;
import OnlineCatalogue.Entities.Student;
import OnlineCatalogue.Entities.Subject;
import OnlineCatalogue.IRepository.IGradeRepository;
import OnlineCatalogue.Manager.Manager;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class GradeRepository implements IGradeRepository {

    public Grade FindById(long id){
        return Manager.getInstance().getManager().find(Grade.class,id);
    }


    public Grade FindByStudentSubject(Student student, Subject subject){
        TypedQuery<Grade> query = Manager.getInstance().getManager().createNamedQuery("Grade.findByStudentSubject", Grade.class);
        query.setParameter("studentId", student);
        query.setParameter("subjectId", subject);
        return query.getResultList().get(0);
    }

    public List<Grade> FindAll(){
        TypedQuery<Grade> query = Manager.getInstance().getManager().createNamedQuery("Grade.findAll",Grade.class);
        return query.getResultList();
    }

    public void Create (Grade grade)
    {
        if(!Manager.getInstance().getManager().getTransaction().isActive()) {
            Manager.getInstance().getManager().getTransaction().begin();
        }
        Manager.getInstance().getManager().persist(grade);
        Manager.getInstance().getManager().getTransaction().commit();
    }

    public void DeleteById(long id){
        if(!Manager.getInstance().getManager().getTransaction().isActive()) {
            Manager.getInstance().getManager().getTransaction().begin();
        }
        Grade grade = Manager.getInstance().getManager().find(Grade.class, id);
        Manager.getInstance().getManager().remove(grade);
        Manager.getInstance().getManager().getTransaction().commit();
    }
}
