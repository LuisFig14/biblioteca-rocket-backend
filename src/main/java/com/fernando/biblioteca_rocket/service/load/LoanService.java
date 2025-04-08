package com.fernando.biblioteca_rocket.service.load;

import com.fernando.biblioteca_rocket.mapper.loan.LoanMapper;
import com.fernando.biblioteca_rocket.model.loan.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Service business logic
@Service
public class LoanService {

    // Injecting the LoanMapper using @Autowired
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
