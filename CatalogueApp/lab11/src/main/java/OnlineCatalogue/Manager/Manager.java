package OnlineCatalogue.Manager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Manager {
    private EntityManagerFactory factory;
    private EntityManager manager;
    private static Manager managerInstance = null;

    private Manager() {
        this.factory = Persistence.createEntityManagerFactory("PersistenceCatalogue");
        this.manager = factory.createEntityManager();
    }

    public static Manager getInstance() {
        if (managerInstance == null) {
            managerInstance = new Manager();
            managerInstance.getManager().getTransaction().begin();
        }
        return managerInstance;
    }

    public EntityManager getManager() {
        return manager;
    }

}
