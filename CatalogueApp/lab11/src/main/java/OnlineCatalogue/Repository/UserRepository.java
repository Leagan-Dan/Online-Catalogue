package OnlineCatalogue.Repository;

import OnlineCatalogue.Manager.Manager;
import OnlineCatalogue.Entities.User;
import OnlineCatalogue.IRepository.IUserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserRepository implements IUserRepository {
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
        if(!Manager.getInstance().getManager().getTransaction().isActive()) {
            Manager.getInstance().getManager().getTransaction().begin();
        }
        Manager.getInstance().getManager().persist(user);
        Manager.getInstance().getManager().getTransaction().commit();
    }

    public void DeleteById(int id){
        if(!Manager.getInstance().getManager().getTransaction().isActive()) {
            Manager.getInstance().getManager().getTransaction().begin();
        }
        User user = Manager.getInstance().getManager().find(User.class,id);
        Manager.getInstance().getManager().remove(user);
        Manager.getInstance().getManager().getTransaction().commit();
    }
}
