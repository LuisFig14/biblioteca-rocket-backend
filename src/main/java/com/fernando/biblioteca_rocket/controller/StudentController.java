package com.fernando.biblioteca_rocket.controller;

import com.fernando.biblioteca_rocket.model.student.Student;
import com.fernando.biblioteca_rocket.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/students")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {


    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        Student studentCreated = studentService.createStudent(student);
        return new ResponseEntity<>(studentCreated, HttpStatus.CREATED);
    }

    @GetMapping("/{idStudent}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long idStudent){
        Optional<Student> student = studentService.getStudentById(idStudent);
        return student.map(ResponseEntity::ok)
                .orElseGet(()-> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllBooks() {
        List<Student> books = studentService.getAllStudents();
        return ResponseEntity.ok(books);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, String>> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Student updated correctly");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {
        boolean deleted = studentService.deleteStudent(id);
        if (deleted){
            return ResponseEntity.ok("Student deleted");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }


}
