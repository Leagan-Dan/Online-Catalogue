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
        System.out.println(subjectDAO.FindAll());


        StudentDAO studentDAO = new StudentDAO();
        Student student = new Student("Andrei", "Raulescu", 2,2,"andreiraulescu@outlook.com");
        //studentDAO.Create(student);
        System.out.println(studentDAO.FindAll());

        UserDAO userDAO = new UserDAO();
        User user = new User("AndreiBB", "pass");
        //userDAO.Create(user);
        System.out.println(userDAO.FindAll());

        GradeDAO gradeDAO = new GradeDAO();
        Grade grade = new Grade(student,subject, 7);
        //gradeDAO.Create(grade);
        System.out.println(gradeDAO.FindAll());


    }
}
