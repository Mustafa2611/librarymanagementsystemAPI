package com.BMS.librarymanagementsystem.librarymanagementsystem.controller;


import com.BMS.librarymanagementsystem.librarymanagementsystem.model.BorrowingRecord;
import com.BMS.librarymanagementsystem.librarymanagementsystem.service.BorrowingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/borrowing-records")
public class BorrowingRecordController {

    @Autowired
    private BorrowingRecordService borrowingRecordService;

    @GetMapping
    public ResponseEntity<List<BorrowingRecord>> getAllBorrowingRecords() {
        List<BorrowingRecord> borrowingRecords = borrowingRecordService.getAllBorrowingRecords();
        return new ResponseEntity<>(borrowingRecords, HttpStatus.OK);
    }

    @PostMapping("/borrow/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecord> borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        BorrowingRecord borrowingRecord = borrowingRecordService.borrowBook(bookId, patronId);
        return new ResponseEntity<>(borrowingRecord, HttpStatus.CREATED);
    }

    @PutMapping("/return/{bookId}/patron/{patronId}")
    public ResponseEntity<BorrowingRecord> returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
        BorrowingRecord returnedRecord = borrowingRecordService.returnBook(bookId, patronId);
        return new ResponseEntity<>(returnedRecord, HttpStatus.OK);
    }
}
