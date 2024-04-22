package com.BMS.librarymanagementsystem.service;

import com.BMS.librarymanagementsystem.librarymanagementsystem.exception.ResourceNotFoundException;
import com.BMS.librarymanagementsystem.librarymanagementsystem.model.Book;
import com.BMS.librarymanagementsystem.librarymanagementsystem.repository.BookRepository;
import com.BMS.librarymanagementsystem.librarymanagementsystem.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    private List<Book> bookList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Sample data for testing
        bookList = Arrays.asList(
                new Book(1L, "Book 1", "Author 1", 2020, "ISBN1234567890"),
                new Book(2L, "Book 2", "Author 2", 2019, "ISBN0987654321")
        );
    }

    @Test
    public void testGetAllBooks() {
        when(bookRepository.findAll()).thenReturn(bookList);

        List<Book> result = bookService.getAllBooks();

        assertEquals(2, result.size());
        assertEquals(bookList, result);
    }

    @Test
    public void testGetBookByIdFound() {
        when(bookRepository.findById(1L)).thenReturn(Optional.of(bookList.get(0)));

        Book result = bookService.getBookById(1L);

        assertNotNull(result);
        assertEquals(bookList.get(0), result);
    }

    @Test
    public void testGetBookByIdNotFound() {
        when(bookRepository.findById(100L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> bookService.getBookById(100L));
    }

    // Add more test methods for other service methods
}
