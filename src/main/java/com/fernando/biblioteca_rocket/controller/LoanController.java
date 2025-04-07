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
public class LoanController {

    @Autowired
    LoanService loanService;

    @Autowired
    BookService bookService;

    @Autowired
    StudentService studentService;

    @PostMapping
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        Book book = bookService.getBookById(loan.getIdBook()).get();
        Student student = studentService.getStudentById(loan.getIdStudent()).get();

        if (book != null && student != null) {
            // Asignar los objetos Book y Student al Loan
            loan.setBook(book);
            loan.setStudent(student);

            // Crear el préstamo
            Loan createdLoan = loanService.createLoan(loan);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdLoan);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable("id") Long id) {
        Optional<Loan> loan = loanService.getLoanById(id);
        return loan.map(ResponseEntity::ok)
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Loan>> getAllBooks(){
        List<Loan> loans = loanService.getAllLoans();
        return ResponseEntity.ok(loans);
    }

    @PutMapping("/{idLoan}")
    public ResponseEntity<String> updateLoan(@PathVariable Long idLoan, @RequestBody Loan loan) {
        loan.setIdLoan(idLoan);
        loanService.updateLoan(loan);

        return ResponseEntity.ok("Loan updated successfully");
    }

    @DeleteMapping("/{idLoan}")
    public ResponseEntity<String> deleteLoan(@PathVariable Long idLoan) {
        loanService.deleteLoan(idLoan);
        return ResponseEntity.ok("Loan deleted successfully");
    }


}
