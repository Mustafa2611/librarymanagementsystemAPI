package com.BMS.librarymanagementsystem.librarymanagementsystem.service;

import com.BMS.librarymanagementsystem.librarymanagementsystem.exception.ResourceNotFoundException;
import com.BMS.librarymanagementsystem.librarymanagementsystem.model.Book;
import com.BMS.librarymanagementsystem.librarymanagementsystem.model.BorrowingRecord;
import com.BMS.librarymanagementsystem.librarymanagementsystem.model.Patron;
import com.BMS.librarymanagementsystem.librarymanagementsystem.repository.BorrowingRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BorrowingRecordService {

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private PatronService patronService;

    public List<BorrowingRecord> getAllBorrowingRecords() {
        return borrowingRecordRepository.findAll();
    }

    public BorrowingRecord borrowBook(Long bookId, Long patronId) {
        Book book = bookService.getBookById(bookId);
        Patron patron = patronService.getPatronById(patronId);
        BorrowingRecord borrowingRecord = new BorrowingRecord();
        borrowingRecord.setBook(book);
        borrowingRecord.setPatron(patron);
        borrowingRecord.setBorrowDate(LocalDate.now());
        return borrowingRecordRepository.save(borrowingRecord);
    }

    public BorrowingRecord returnBook(Long bookId, Long patronId) {
        Optional<BorrowingRecord> optionalBorrowingRecord = borrowingRecordRepository.findByBookIdAndPatronIdAndReturnDateIsNull(bookId, patronId);
        if (!optionalBorrowingRecord.isPresent()) {
            throw new ResourceNotFoundException("No borrowing record found for bookId: " + bookId + " and patronId: " + patronId);
        }
        BorrowingRecord borrowingRecord = optionalBorrowingRecord.get();
        borrowingRecord.setReturnDate(LocalDate.now());
        return borrowingRecordRepository.save(borrowingRecord);
    }
}
