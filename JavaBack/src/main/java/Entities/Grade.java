package Entities;

import javax.persistence.*;

@Entity
@Table(name = "grade")
@NamedQueries({
        @NamedQuery(name="Grade.findAll", query = "select e from Grade e"),
        @NamedQuery(name = "Grade.findByStudentSubject", query = "select e from Grade e where e.student = :studentId and e.subject = :subjectId")
})
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "studentId")
    Student student;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "subjectId")
    Subject subject;
    @Column(name = "grade")
    int grade;

    public Grade(){

    }

    public Grade(Student student, Subject subject, int grade) {
        this.student = student;
        this.subject = subject;
        this.grade = grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", student=" + student +
                ", subject=" + subject +
                ", grade=" + grade +
                '}' + '\n';
    }
}
