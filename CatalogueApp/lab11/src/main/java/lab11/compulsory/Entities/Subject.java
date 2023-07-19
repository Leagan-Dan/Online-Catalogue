package lab11.compulsory.Entities;

import javax.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="Subject")
@NamedQueries({
        @NamedQuery(name = "Subject.findAll",
                query = "select e from Subject e order by e.name"),
})
public class Subject implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="credits")
    private int credits;
    @OneToMany(mappedBy = "subject",  cascade = CascadeType.ALL)
    private List<Grade> subjectGrades;

    public Subject(){

    }

    public Subject(String name, int credits){
        this.name=name;
        this.credits=credits;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String name(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int credits(){
        return credits;
    }

    public void setCredits(int credits){
        this.credits=credits;
    }

    public List<Grade> getSubjectGrades() {
        return subjectGrades;
    }

    public void setSubjectGrades(List<Grade> subjectGrades) {
        this.subjectGrades = subjectGrades;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                '}' + '\n';
    }
}
