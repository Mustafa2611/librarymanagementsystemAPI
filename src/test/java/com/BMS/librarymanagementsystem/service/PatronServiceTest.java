package com.BMS.librarymanagementsystem.service;

import com.BMS.librarymanagementsystem.librarymanagementsystem.exception.ResourceNotFoundException;
import com.BMS.librarymanagementsystem.librarymanagementsystem.model.Patron;
import com.BMS.librarymanagementsystem.librarymanagementsystem.repository.PatronRepository;
import com.BMS.librarymanagementsystem.librarymanagementsystem.service.PatronService;
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

public class PatronServiceTest {

    @Mock
    private PatronRepository patronRepository;

    @InjectMocks
    private PatronService patronService;

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
    public void testGetAllPatrons() {
        when(patronRepository.findAll()).thenReturn(patronList);

        List<Patron> result = patronService.getAllPatrons();

        assertEquals(2, result.size());
        assertEquals(patronList, result);
    }

    @Test
    public void testGetPatronByIdFound() {
        when(patronRepository.findById(1L)).thenReturn(Optional.of(patronList.get(0)));

        Patron result = patronService.getPatronById(1L);

        assertNotNull(result);
        assertEquals(patronList.get(0), result);
    }

    @Test
    public void testGetPatronByIdNotFound() {
        when(patronRepository.findById(100L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> patronService.getPatronById(100L));
    }

    // Add more test methods for other service methods
}
