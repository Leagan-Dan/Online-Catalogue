package lab11.compulsory.Repository;

import lab11.compulsory.Entities.Grade;
import lab11.compulsory.Entities.Student;
import lab11.compulsory.Entities.Subject;
import lab11.compulsory.IRepository.IGradeRepository;
import lab11.compulsory.Manager.Manager;
import lab11.compulsory.IRepository.IGradeRepository;

import javax.persistence.TypedQuery;
import java.util.List;

public class GradeRepository implements IGradeRepository {

    public Grade FindById(int id){
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
        Grade grade = Manager.getInstance().getManager().find(Grade.class, id);
        Manager.getInstance().getManager().remove(grade);
        Manager.getInstance().getManager().getTransaction().commit();
    }
}
