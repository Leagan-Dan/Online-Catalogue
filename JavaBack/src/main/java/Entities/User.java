package Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "User")
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "select e from User e order by e.username"),
        @NamedQuery(name="User.findById", query = "select e from User e where e.id = :id"),
        @NamedQuery(name="User.findByUsername", query = "select e from User e where e.username = :username")
})
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public User(){

    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
