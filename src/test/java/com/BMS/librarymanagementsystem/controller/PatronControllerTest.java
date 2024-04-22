package com.BMS.librarymanagementsystem.controller;

import com.BMS.librarymanagementsystem.librarymanagementsystem.controller.PatronController;
import com.BMS.librarymanagementsystem.librarymanagementsystem.model.Patron;
import com.BMS.librarymanagementsystem.librarymanagementsystem.service.PatronService;
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

@WebMvcTest(PatronController.class)
public class PatronControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private PatronService patronService;

    @InjectMocks
    private PatronController patronController;

    private List<Patron> patronList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Sample data for testing
        patronList = Arrays.asList(
                new Patron(1L, "Patron 1", "patron1@example.com"),
                new Patron(2L, "Patron 2", "patron2@example.com")
        );
    }

    @Test
    public void testGetAllPatrons() throws Exception {
        when(patronService.getAllPatrons()).thenReturn(patronList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/patrons")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(patronList.size()));

        verify(patronService, times(1)).getAllPatrons();
    }

    // You can write similar test methods for other controller endpoints
}
