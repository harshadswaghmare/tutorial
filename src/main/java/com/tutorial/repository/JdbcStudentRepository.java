package com.tutorial.repository;

import com.tutorial.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
@Configuration

public class JdbcStudentRepository implements StudentRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int save(Student student) {
        return jdbcTemplate.update("INSERT INTO students (firstName, lastName, address,gender) VALUES(?,?,?,?)",
                new Object[] { student.getFirstName(),student.getLastName(),student.getAddress(),student.getGender()});
    }

    @Override
    public int update(Student student) {
        return jdbcTemplate.update("UPDATE students SET firstName=?, lastName=?, address=?, gender =? WHERE studentID=?",
                new Object[] { student.getFirstName(),student.getLastName(),student.getAddress(),student.getGender(),student.getStudentID()});
    }

    @Override
    public Student findById(Long id) {
        try {
            Student student = jdbcTemplate.queryForObject("SELECT * FROM students WHERE studentID=?",
                    BeanPropertyRowMapper.newInstance(Student.class), id);

            return student;
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    @Override
    public int deleteById(Long id) {
        return jdbcTemplate.update("DELETE FROM students WHERE studentID=?", id);
    }

    @Override
    public List<Student> findAll() {
        return jdbcTemplate.query("select * from students", BeanPropertyRowMapper.newInstance(Student.class));
    }

    @Override
    public List<Student> findByTitleContaining(String firstName) {
        String q = "SELECT * from students WHERE title ILIKE '%" + firstName + "%'";

        return jdbcTemplate.query(q, BeanPropertyRowMapper.newInstance(Student.class));
    }

    @Override
    public int deleteAll() {
        return jdbcTemplate.update("DELETE from students");
    }

    public List<Student>getAllStudents()
    {
        System.out.println("Select * from students inner join tutorials on students.studentID = tutorials.id Service calling" );
     return  jdbcTemplate.query("Select * from students inner join tutorials on students.studentID = tutorials.id",BeanPropertyRowMapper.newInstance(Student.class));

    }
}


