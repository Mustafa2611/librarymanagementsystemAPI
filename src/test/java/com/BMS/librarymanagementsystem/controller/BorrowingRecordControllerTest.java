package com.BMS.librarymanagementsystem.controller;

import com.BMS.librarymanagementsystem.librarymanagementsystem.controller.BorrowingRecordController;
import com.BMS.librarymanagementsystem.librarymanagementsystem.model.BorrowingRecord;
import com.BMS.librarymanagementsystem.librarymanagementsystem.service.BorrowingRecordService;
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

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@WebMvcTest(BorrowingRecordController.class)
public class BorrowingRecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private BorrowingRecordService borrowingRecordService;

    @InjectMocks
    private BorrowingRecordController borrowingRecordController;

    private List<BorrowingRecord> borrowingRecordList;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Sample data for testing
        borrowingRecordList = Arrays.asList(
                new BorrowingRecord(1L, null, null, LocalDate.now()),
                new BorrowingRecord(2L, null, null, LocalDate.now())
        );
    }

    @Test
    public void testGetAllBorrowingRecords() throws Exception {
        when(borrowingRecordService.getAllBorrowingRecords()).thenReturn(borrowingRecordList);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/borrowing-records")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.size()").value(borrowingRecordList.size()));

        verify(borrowingRecordService, times(1)).getAllBorrowingRecords();
    }

    // You can write similar test methods for other controller endpoints
}
