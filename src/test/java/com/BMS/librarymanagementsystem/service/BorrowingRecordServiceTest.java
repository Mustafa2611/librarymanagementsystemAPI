package com.BMS.librarymanagementsystem.service;

import com.BMS.librarymanagementsystem.librarymanagementsystem.exception.ResourceNotFoundException;
import com.BMS.librarymanagementsystem.librarymanagementsystem.model.Book;
import com.BMS.librarymanagementsystem.librarymanagementsystem.model.BorrowingRecord;
import com.BMS.librarymanagementsystem.librarymanagementsystem.model.Patron;
import com.BMS.librarymanagementsystem.librarymanagementsystem.repository.BorrowingRecordRepository;
import com.BMS.librarymanagementsystem.librarymanagementsystem.service.BorrowingRecordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BorrowingRecordServiceTest {

    @Mock
    private BorrowingRecordRepository borrowingRecordRepository;

    @InjectMocks
    private BorrowingRecordService borrowingRecordService;

    private List<BorrowingRecord> borrowingRecordList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Sample data for testing
        Book book = new Book(1L, "Book 1", "Author 1", 2020, "ISBN1234567890");
        Patron patron = new Patron(1L, "Patron 1", "patron1@example.com");
        borrowingRecordList = Arrays.asList(
                new BorrowingRecord(1L, book, patron, LocalDate.now()),
                new BorrowingRecord(2L, book, patron, LocalDate.now())
        );
    }

    @Test
    public void testGetAllBorrowingRecords() {
        when(borrowingRecordRepository.findAll()).thenReturn(borrowingRecordList);

        List<BorrowingRecord> result = borrowingRecordService.getAllBorrowingRecords();

        assertEquals(2, result.size());
        assertEquals(borrowingRecordList, result);
    }

    @Test
    public void testGetBorrowingRecordByIdFound() {
        when(borrowingRecordRepository.findById(1L)).thenReturn(Optional.of(borrowingRecordList.get(0)));

        BorrowingRecord result = borrowingRecordService.getBorrowingRecordById(1L);

        assertNotNull(result);
        assertEquals(borrowingRecordList.get(0), result);
    }

    @Test
    public void testGetBorrowingRecordByIdNotFound() {
        when(borrowingRecordRepository.findById(100L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> borrowingRecordService.getBorrowingRecordById(100L));
    }

    // Add more test methods for other service methods
}
