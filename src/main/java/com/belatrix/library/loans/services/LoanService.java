package com.belatrix.library.loans.services;

import com.belatrix.library.loans.model.Loan;

import java.util.List;

/**
 * @author Kei Takayama
 * Created on 6/17/17.
 */
public interface LoanService {

    List<Loan> getLoans();

    Integer createLoan(Loan loan);
}
