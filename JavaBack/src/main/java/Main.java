import DAO.SubjectDAO;
import Entities.Subject;

public class Main {
    public static void main(String[] args) {
        SubjectDAO subjectDAO = new SubjectDAO();
        Subject subject = new Subject("Mathematics",5);
       //subjectDAO.Create(subject);
        subjectDAO.DeleteById(921);
        System.out.println(subjectDAO.findAll());
    }
}
