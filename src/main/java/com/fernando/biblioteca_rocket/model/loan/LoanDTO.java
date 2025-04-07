package com.fernando.biblioteca_rocket.model.loan;

import lombok.Data;

import java.util.Date;

@Data
public class LoanDTO {

    private int idLoan;
    private int idBook;
    private String bookTitle;
    private int idStudent;
    private Date loanDate;
    private Date returnDate;
}
