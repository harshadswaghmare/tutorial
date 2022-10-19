package com.tutorial.Controller;

import com.tutorial.model.Student;
import com.tutorial.model.Tutorial;
import com.tutorial.repository.StudentRepository;
import com.tutorial.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")

//@Configuration

     public class StudentController {

           @Autowired
           StudentRepository studentRepository;
           TutorialRepository tutorialRepository;
           @GetMapping("/students")
         @Test(priority = 1)
           public ResponseEntity<List<Student>> getAllStudents(@RequestParam(required = false) String firstName) {
            try {
                List<Student> students = new ArrayList<>();
                //List<Tutorial>tutorials = new ArrayList<>();

                if (firstName == null) {
                    studentRepository.findAll().forEach(students ::add);
                   // tutorialRepository.findAll().forEach(tutorials::add);
                    System.out.println("Hii");
                }
                else {
                    studentRepository.findByTitleContaining(firstName
                    ).forEach(students::add);
                }

                if (students.isEmpty()) {
                    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
                }

                return new ResponseEntity<>(students, HttpStatus.OK);
            } catch (Exception e) {
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

   @Test(priority = 2)
    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
        try {
            int result = studentRepository.deleteById(id);
            if (result == 0) {
                return new ResponseEntity<>("Cannot find students with id=" + id, HttpStatus.OK);
            }
            return new ResponseEntity<>("student was deleted successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Cannot delete students.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
  @Test(priority = 3)
    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getTutorialById(@PathVariable("id") long id) {
        Student students = studentRepository.findById(id);

        if (students != null) {
            return new ResponseEntity<>(students, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @Test(priority = 4)
    @PostMapping("/students")
    public ResponseEntity<String> createStudentRecord(@RequestBody Student student) {
        try {
            studentRepository.save(new Student(student.getFirstName(),student.getLastName(),student.getAddress(),student.getGender()));
            return new ResponseEntity<>("student record  was created successfully.", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
   @Test(priority = 5)
    @PutMapping("/students/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        Student _student = studentRepository.findById(id);

        if (_student != null) {
            _student.setStudentID(id);
            _student.setFirstName(_student.getFirstName());
            _student.setLastName(_student.getLastName());
            _student.setAddress(_student.getAddress());
            _student.setGender(_student.getGender());

            studentRepository.update(_student);
            return new ResponseEntity<>("student record was updated successfully.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Cannot find Record with id=" + id, HttpStatus.NOT_FOUND);
        }
 }

   // @RequestMapping
    @GetMapping("/ok")
    public ResponseEntity<List<Student>> getAllStudentAndTutorials(@RequestParam(required = false)String firstName) {
        try {
           List<Student> students = new ArrayList<>();
             Tutorial tutorial = null;
            if (students != null ) {
                 studentRepository.getAllStudents().forEach(students::add);
            }
            return new ResponseEntity<>(students,HttpStatus.OK);
            } catch (Exception e) {
            System.out.println("Exception Occured"+e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

