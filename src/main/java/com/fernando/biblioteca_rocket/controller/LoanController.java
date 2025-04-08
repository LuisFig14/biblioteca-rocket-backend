package com.fernando.biblioteca_rocket.controller;

import com.fernando.biblioteca_rocket.model.book.Book;
import com.fernando.biblioteca_rocket.model.loan.Loan;
import com.fernando.biblioteca_rocket.model.student.Student;
import com.fernando.biblioteca_rocket.service.book.BookService;
import com.fernando.biblioteca_rocket.service.load.LoanService;
import com.fernando.biblioteca_rocket.service.student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loans")
@CrossOrigin(origins = "http://localhost:4200")
public class LoanController {

    // Injecting the LoanService using @Autowired
    @Autowired
    LoanService loanService;
    // Injecting the BookService using @Autowired
    @Autowired
    BookService bookService;
    // Injecting the StudentService using @Autowired
    @Autowired
    StudentService studentService;


    //Creates a new loan if both the book and the student exist.
    //Validates the existence of Book and Student entities before creating the loan
    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        Book book = bookService.getBookById(loan.getIdBook()).get();
        Student student = studentService.getStudentById(loan.getIdStudent()).get();

        if (book != null && student != null) {

            loan.setBook(book);
            loan.setStudent(student);

            Loan createdLoan = loanService.createLoan(loan);

            return ResponseEntity.status(HttpStatus.CREATED).body(createdLoan);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    //get loan by id
    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable("id") Long id) {
        Optional<Loan> loan = loanService.getLoanById(id);
        return loan.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    //get all loans
    @GetMapping
    public ResponseEntity<List<Loan>> getAllBooks(){
        List<Loan> loans = loanService.getAllLoans();
        return ResponseEntity.ok(loans);
    }

    //update the loan
    @PutMapping("/{idLoan}")
    public ResponseEntity<String> updateLoan(@PathVariable Long idLoan, @RequestBody Loan loan) {
        loan.setIdLoan(idLoan);
        loanService.updateLoan(loan);

        return ResponseEntity.ok("Loan updated successfully");
    }

    //delete the loan
    @DeleteMapping("/{idLoan}")
    public ResponseEntity<String> deleteLoan(@PathVariable Long idLoan) {
        loanService.deleteLoan(idLoan);
        return ResponseEntity.ok("Loan deleted successfully");
    }

    //All controller methods return a ResponseEntity to provide HTTP status codes and body.

}
