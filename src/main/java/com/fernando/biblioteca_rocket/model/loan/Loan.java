package com.fernando.biblioteca_rocket.model.loan;

import com.fernando.biblioteca_rocket.model.book.Book;
import com.fernando.biblioteca_rocket.model.student.Student;
import lombok.Data;
import java.util.Date;

// Lombok annotation to generate getters, setters, toString, equals, hashCode.
@Data
public class Loan {

    private Long idLoan;
    private Long idBook;
    private Long idStudent;
    private Date loanDate;
    private Date returnDate;

    //relation with book
    private Book book;
    //relation with student
    private Student student;


}
