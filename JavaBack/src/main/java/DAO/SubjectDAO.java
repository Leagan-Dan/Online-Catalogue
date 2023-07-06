package DAO;

import Entities.Subject;
import Manager.Manager;

import java.util.List;

public class SubjectDAO {
    public Subject findByName(String name){
        try{
            return Manager.getInstance().getManager().createQuery("select a from Subject a.name='\" + name + \"'\"", Subject.class).getResultList().get(0);
        }catch (Exception e){
            return null;
        }
    }

    public Subject findById(int id){
        try{
            return Manager.getInstance().getManager().find(Subject.class,id);
        }catch (Exception e) {
            return null;
        }
    }

    public void Create(Subject subject){
        //Manager.getInstance().getManager().getTransaction().begin();
        Manager.getInstance().getManager().persist(subject);
        Manager.getInstance().getManager().getTransaction().commit();
    }

    public List<Subject> findAll(){
        try{
            return Manager.getInstance().getManager().createNamedQuery("Subject.findAll",Subject.class).getResultList();
        }catch (Exception e){
            return null;
        }
    }

    public void DeleteById(int id){
        Subject subject = Manager.getInstance().getManager().find(Subject.class,id);
        Manager.getInstance().getManager().remove(subject);
        Manager.getInstance().getManager().getTransaction().commit();
    }
}
