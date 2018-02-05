package yncrea.pw03.service;

import yncrea.pw03.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findByLastname(String name);
    void saveStudent (Student student);
    List<Student> findAll();
}
