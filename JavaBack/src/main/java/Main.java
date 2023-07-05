import DAO.StudentDAO;
import DAO.SubjectDAO;
import DAO.UserDAO;
import Entities.Student;
import Entities.Subject;
import Entities.User;

public class Main {
    public static void main(String[] args) {
        /*
        SubjectDAO subjectDAO = new SubjectDAO();
        Subject subject = new Subject("Biology",5);
        //subjectDAO.Create(subject);
        //subjectDAO.DeleteById(921);
        System.out.println(subjectDAO.findAll());
        */

        System.out.println("student");
        StudentDAO studentDAO = new StudentDAO();
        Student student = new Student("Andrei", "Raulescu", 2,2,"andreiraulescu@outlook.com");
        studentDAO.Create(student);
        System.out.println(studentDAO.findAll());

    }
}
