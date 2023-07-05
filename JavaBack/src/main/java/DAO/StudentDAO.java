package DAO;

import Entities.Student;
import Entities.Subject;
import Manager.Manager;

import javax.persistence.TypedQuery;
import java.util.List;

public class StudentDAO {

    public List<Student> findAll(){
        try {
            return Manager.getInstance().getManager().createNamedQuery("Student.findAll", Student.class).getResultList();
        }catch (Exception e){
            return null;
        }
    }

    public void Create(Student student){
        Manager.getInstance().getManager().persist(student);
        Manager.getInstance().getManager().getTransaction().commit();
    }

    public void DeleteById(int id){
        Student student = Manager.getInstance().getManager().find(Student.class,id);
        Manager.getInstance().getManager().remove(student);
        Manager.getInstance().getManager().getTransaction().commit();
    }
}