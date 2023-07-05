package DAO;

import Entities.Subject;
import Entities.User;
import Manager.Manager;

import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAO {
    public User FindById(int id){
        TypedQuery<User> query = Manager.getInstance().getManager().createNamedQuery("User.findById", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    public User FindByUsername(String username){
        TypedQuery<User> query = Manager.getInstance().getManager().createNamedQuery("User.findByUsername", User.class);
        query.setParameter("username", username);
        return query.getResultList().get(0);
    }

    public List<User> FindAll(){
        return Manager.getInstance().getManager().createNamedQuery("User.findAll", User.class).getResultList();
    }

    public void Create(User user){
        Manager.getInstance().getManager().persist(user);
        Manager.getInstance().getManager().getTransaction().commit();
    }

    public void DeleteById(int id){
        User user = Manager.getInstance().getManager().find(User.class,id);
        Manager.getInstance().getManager().remove(user);
        Manager.getInstance().getManager().getTransaction().commit();
    }
}
