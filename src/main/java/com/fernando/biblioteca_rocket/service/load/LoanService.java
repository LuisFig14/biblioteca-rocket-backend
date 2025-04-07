package com.fernando.biblioteca_rocket.service.load;

import com.fernando.biblioteca_rocket.mapper.loan.LoanMapper;
import com.fernando.biblioteca_rocket.model.book.Book;
import com.fernando.biblioteca_rocket.model.loan.Loan;
import com.fernando.biblioteca_rocket.model.loan.LoanDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    LoanMapper loanMapper;

    public Loan createLoan(Loan loan) {
        loanMapper.insertLoan(loan);
        return loan;
    }

    public Optional<Loan> getLoanById(Long idLoan) {
        return Optional.ofNullable(loanMapper.getLoanById(idLoan));
    }

    public List<Loan> getAllLoans() {
        return loanMapper.getAllLoans();

    }

    public void updateLoan(Loan loan) {
        loanMapper.updateLoan(loan);
    }

    public void deleteLoan(Long idLoan) {
        loanMapper.deleteLoan(idLoan);
    }


}
