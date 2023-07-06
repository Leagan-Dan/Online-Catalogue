package DAO;

import Entities.Grade;
import Entities.Student;
import Entities.Subject;
import Manager.Manager;

import javax.persistence.TypedQuery;
import java.util.List;

public class GradeDAO {

    public Grade FindById(int id){
        return Manager.getInstance().getManager().find(Grade.class,id);
    }


    public List<Grade> FindByStudentSubject(Student student, Subject subject){
        TypedQuery<Grade> query = Manager.getInstance().getManager().createNamedQuery("Grade.findByStudentSubject", Grade.class);
        query.setParameter("studentId", student);
        query.setParameter("subjectId", subject);
        return query.getResultList();
    }

    public List<Grade> FindAll(){
        TypedQuery<Grade> query = Manager.getInstance().getManager().createNamedQuery("Grade.findAll",Grade.class);
        return query.getResultList();
    }

    public void Create (Grade grade)
    {
        Manager.getInstance().getManager().getTransaction().begin();
        Manager.getInstance().getManager().persist(grade);
        Manager.getInstance().getManager().getTransaction().commit();
    }

    public void DeleteById(int id){
        Grade grade = Manager.getInstance().getManager().find(Grade.class, id);
        Manager.getInstance().getManager().remove(grade);
        Manager.getInstance().getManager().getTransaction().commit();
    }
}
