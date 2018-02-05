package yncrea.pw03.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "validated")
    private Boolean validated;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    private Student student;

    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "course")
    private List<Work> works;

    public Course() {
    }

    public Course(String name, Student student) {
        this.name = name;
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public void setWorks(List<Work> works) {
        this.works = works;
    }
}
