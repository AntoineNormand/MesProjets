package yncrea.pw03.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="lastname", nullable = false)
    private String lastname;

    @Column(name="firstname")
    private String firstname;

    @OneToMany(cascade={CascadeType.ALL}, mappedBy="student")
    private List<Course> courses;

    public Student() {
    }

    public Student(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }
}
