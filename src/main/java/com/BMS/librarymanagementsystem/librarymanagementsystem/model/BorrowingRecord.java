package com.BMS.librarymanagementsystem.librarymanagementsystem.model;


import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Table(name = "borrowing_records")
public class BorrowingRecord implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patron_id", nullable = false)
    private Patron patron;

    @NotNull
    private LocalDate borrowDate;

    private LocalDate returnDate;

    // Constructors, getters, and setters

    // Constructors
    public BorrowingRecord() {
    }

    public BorrowingRecord(Book book, Patron patron, LocalDate borrowDate) {
        this.book = book;
        this.patron = patron;
        this.borrowDate = borrowDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Patron getPatron() {
        return patron;
    }

    public void setPatron(Patron patron) {
        this.patron = patron;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
