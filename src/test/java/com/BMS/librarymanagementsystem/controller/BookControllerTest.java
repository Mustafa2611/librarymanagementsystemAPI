package com.BMS.librarymanagementsystem.controller;

import com.BMS.librarymanagementsystem.librarymanagementsystem.controller.BookController;
import com.BMS.librarymanagementsystem.librarymanagementsystem.model.Book;
import com.BMS.librarymanagementsystem.librarymanagementsystem.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@WebMvcTest(BookController.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @InjectMocks
    private BookController bookController;

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
    public void testGetAllBooks() throws Exception {
        when(bookService.getAllBooks()).thenReturn(bookList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/books")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(bookList.size()));

        verify(bookService, times(1)).getAllBooks();
    }

    // You can write similar test methods for other controller endpoints
}
