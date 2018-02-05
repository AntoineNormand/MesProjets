package yncrea.pw03.entity;

import javax.persistence.*;

@Entity
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name="grade")
    private int grade;

    @ManyToOne
    private Course course;

    public Work() {
    }

    public Work(String name,int grade, Course course) {
        this.name = name;
        this.course = course;
        this.grade = grade;
    }

}
