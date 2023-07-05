package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Student")
@NamedQueries({
        @NamedQuery(name="Student.findAll", query = "select e from Student e order by e.lastName")
})
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "year")
    private int year;
    @Column(name = "semester")
    private int semester;
    @Column(name = "email")
    private String email;

    public Student(){

    }

    public Student(String firstName, String lastName, int year, int semester, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.semester = semester;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", year=" + year +
                ", semester=" + semester +
                ", email='" + email + '\'' +
                '}';
    }
}