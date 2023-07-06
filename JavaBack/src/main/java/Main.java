import DAO.GradeDAO;
import DAO.StudentDAO;
import DAO.SubjectDAO;
import DAO.UserDAO;
import Entities.Grade;
import Entities.Student;
import Entities.Subject;
import Entities.User;

public class Main {
    public static void main(String[] args) {
        SubjectDAO subjectDAO = new SubjectDAO();
        Subject subject = new Subject("Biology",5);
        //subjectDAO.Create(subject);
        //subjectDAO.DeleteById(921);
        System.out.println(subjectDAO.findAll());


        StudentDAO studentDAO = new StudentDAO();
        Student student = new Student("Andrei", "Raulescu", 2,2,"andreiraulescu@outlook.com");
        //studentDAO.Create(student);
        System.out.println(studentDAO.findAll());
        //System.out.println("Find by id: " + studentDAO.findById(960));
        //System.out.println("Find by name: " + studentDAO.findByName("Andrei", "Raulescu"));

        UserDAO userDAO = new UserDAO();
        User user = new User("AndreiBB", "pass");
        //userDAO.Create(user);
        //System.out.println("Find by id: " + userDAO.FindById(966));
        //System.out.println("Find by username: " + userDAO.FindByUsername("AndreiBB"));
        System.out.println(userDAO.FindAll());

        GradeDAO gradeDAO = new GradeDAO();
        Grade grade = new Grade(student,subject, 7);
        //gradeDAO.Create(grade);
        System.out.println(gradeDAO.FindAll());
        //System.out.println(gradeDAO.FindByStudentSubject(student, subject));

    }
}
