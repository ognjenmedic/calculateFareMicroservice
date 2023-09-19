package com.calculatefare.service;

import com.calculatefare.entity.FareRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CalculateFareServiceTest {

    @Spy
    @InjectMocks
    private CalculateFareService calculateFareService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCalculateFareForStandardCab() {
        // Given
        FareRequest fareRequest = new FareRequest();
        fareRequest.setFromLocation("work");
        fareRequest.setToLocation("home");
        fareRequest.setCabType("standard");

        // Mock the randomDistance method to return a fixed value
        doReturn(10.0).when(calculateFareService).randomDistance();

        // When
        double fare = calculateFareService.calculateFare(fareRequest);

        // Then
        assertEquals(30.0, fare);  // 10 km * 3 (standard rate per km)
    }

    @Test
    public void testCalculateFareRoundingLogic() {
        // Given
        FareRequest fareRequest = new FareRequest();
        fareRequest.setFromLocation("work");
        fareRequest.setToLocation("home");
        fareRequest.setCabType("standard");

        // Mock the randomDistance method to return a fixed value
        doReturn(10.123456).when(calculateFareService).randomDistance();

        // When
        double fare = calculateFareService.calculateFare(fareRequest);

        // Then
        assertEquals(30.37, fare);  // 10.123456 km * 3 (standard rate per km) rounded to 2 decimal places
    }

}
