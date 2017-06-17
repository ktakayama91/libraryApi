package com.belatrix.library.loans.services;

import com.belatrix.library.loans.model.Loan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Kei Takayama
 * Created on 6/17/17.
 */
public class LoanServiceImpl implements LoanService {

    private static List<Loan> loans = new ArrayList<>(Arrays
            .asList(
                    new Loan(1,1, 1, LocalDate.now(), LocalDate.now().plusDays(3), 1)
            ));

    @Override
    public List<Loan> getLoans() {
        return loans;
    }
}
