package com.tutorial.repository;

import com.tutorial.model.Student;

import java.util.List;

public interface StudentRepository {

    int save(Student book);

    int update(Student book);

    Student findById(Long studentID);

    int deleteById(Long id);

    List<Student> findAll();

    List<Student> findByTitleContaining(String title);

    //List<Student> findAllByStudentAndTutorial();

     List<Student> getAllStudents();
    int deleteAll();
}
