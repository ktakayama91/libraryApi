package com.belatrix.library.loans.model;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author Kei Takayama
 * Created on 6/17/17.
 */
public class Loan {

    private Integer id;

    @NotNull
    private Integer userId;

    @NotNull
    private Integer bookId;

    private LocalDate loanDate;

    private LocalDate bookReturnDate;

    private Integer status;

    public Loan() {
    }

    public Loan(Integer id, Integer userId, Integer bookId, LocalDate loanDate, LocalDate bookReturnDate, Integer status) {
        this.id = id;
        this.userId = userId;
        this.bookId = bookId;
        this.loanDate = loanDate;
        this.bookReturnDate = bookReturnDate;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getBookReturnDate() {
        return bookReturnDate;
    }

    public void setBookReturnDate(LocalDate bookReturnDate) {
        this.bookReturnDate = bookReturnDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
