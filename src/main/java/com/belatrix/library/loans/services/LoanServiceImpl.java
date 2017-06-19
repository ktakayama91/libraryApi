package com.belatrix.library.loans.services;

import com.belatrix.library.books.services.BookService;
import com.belatrix.library.books.services.BookServiceImpl;
import com.belatrix.library.loans.model.Loan;
import com.belatrix.library.users.services.UserService;
import com.belatrix.library.users.services.UserServiceImpl;

import javax.ws.rs.NotFoundException;
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
    private static Integer ACTIVE_LOAN = 1;
    private static Integer ID = 1;

    @Override
    public List<Loan> getLoans() {
        return loans;
    }

    @Override
    public Integer createLoan(Loan loan) {
        BookService bookService = new BookServiceImpl();
        UserService userService = new UserServiceImpl();

        if (userService.findUserById(loan.getUserId()) != null && bookService.findBookById(loan.getBookId()) != null) {
            loans.add(new Loan(++ID, loan.getUserId(), loan.getBookId(), LocalDate.now(), LocalDate.now().plusDays(3), ACTIVE_LOAN));
        }

        return ID;
    }

}
