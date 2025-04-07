package com.fernando.biblioteca_rocket.mapper.student;

import com.fernando.biblioteca_rocket.model.student.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @Insert("INSERT INTO students (name, school, phone) VALUES (#{name}, #{school}, #{phone})")
    void createStudent(Student student);

    @Select("SELECT * FROM STUDENTS WHERE ID_STUDENT = #{idStudent}")
    @Results({
            @Result(property = "idStudent", column = "ID_STUDENT"),
            @Result(property = "name", column = "NAME"),
            @Result(property = "school", column = "SCHOOL"),
            @Result(property = "phone", column = "PHONE")
    })
    Student getStudentById(Long idStudent);


    @Select("SELECT * FROM STUDENTS")
    @Results({@Result(property = "idStudent", column = "ID_STUDENT")})
    List<Student> getAllStudents();

    @Update(
            "UPDATE STUDENTS SET " +
                    "NAME = #{name}, " +
                    "SCHOOL = #{school}, " +
                    "PHONE = #{phone} " +
                    "WHERE ID_STUDENT = #{idStudent}"
    )
    void updateStudent(Student student);

    @Delete("DELETE FROM STUDENTS WHERE ID_STUDENT = #{idStudent}")
    void deleteStudent(Long idStudent);



}
