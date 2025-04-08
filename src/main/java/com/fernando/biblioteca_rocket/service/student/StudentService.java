package com.fernando.biblioteca_rocket.service.student;

import com.fernando.biblioteca_rocket.mapper.student.StudentMapper;
import com.fernando.biblioteca_rocket.model.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Service business logic
@Service
public class StudentService {

    // Injecting the StudentMapper using @Autowired
    @Autowired
    StudentMapper studentMapper;

    public Student createStudent (Student student){
        studentMapper.createStudent(student);
        return student;
    }

    public Optional<Student> getStudentById(Long idStudent){
        return Optional.ofNullable(studentMapper.getStudentById(idStudent));
    }

    public List<Student> getAllStudents(){
        return studentMapper.getAllStudents();
    }

    public boolean updateStudent(Long idStudent, Student student) {
        Optional<Student> existingOpt = getStudentById(idStudent);
        if (existingOpt.isPresent()) {
            Student existing = existingOpt.get();

            if (student.getName() == null) student.setName(existing.getName());
            if (student.getSchool() == null) student.setSchool(existing.getSchool());
            if (student.getPhone() == null) student.setPhone(existing.getPhone());

            student.setIdStudent(idStudent);
            studentMapper.updateStudent(student);
            return true;
        }
        return false;
    }

    public boolean deleteStudent(Long idStudent) {
        Optional<Student> existing = getStudentById(idStudent);
        if (existing.isPresent()) {
            studentMapper.deleteStudent(idStudent);
            return true;
        }
        return false;
    }



}
