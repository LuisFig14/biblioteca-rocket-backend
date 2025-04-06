package com.fernando.biblioteca_rocket.model.loan;

import com.fernando.biblioteca_rocket.model.book.Book;
import com.fernando.biblioteca_rocket.model.student.Student;
import lombok.Data;
import java.util.Date;

@Data
public class Loan {

    private Long idLoan;
    private Long idBook;
    private Long idStudent;
    private Date loanDate;
    private Date returnDate;


    private Book book;
    private Student student;


}
