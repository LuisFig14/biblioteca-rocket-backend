package com.fernando.biblioteca_rocket.model.student;

import lombok.Data;
// Lombok annotation to generate getters, setters, toString, equals, hashCode.
@Data
public class Student {

    private Long idStudent;
    private String name;
    private String school;
    private String phone;

    //constructor
    public Student (Long idStudent, String name, String school, String phone){

        this.idStudent = idStudent;
        this.name = name;
        this.school = school;
        this.phone = phone;

    }

    public Student (){}


}
