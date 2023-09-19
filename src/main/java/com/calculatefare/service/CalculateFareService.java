package com.calculatefare.service;

import com.calculatefare.entity.FareRequest;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;


import java.util.Random;

@Service
public class CalculateFareService {

    private static final double STANDARD_RATE_PER_KM = 3; 
    private static final double PREMIUM_RATE_PER_KM = 5; 
    private static final double LUXURY_RATE_PER_KM = 10; 

    private Random random = new Random(); 

    public double calculateFare(FareRequest fareRequest) {
        double rate = getRateBasedOnCabType(fareRequest.getCabType());
        
        double distance = randomDistance();
        
        double fare = rate * distance;

        BigDecimal roundedFare = new BigDecimal(fare).setScale(2, RoundingMode.HALF_UP);
        
        return roundedFare.doubleValue();
    }


    private double getRateBasedOnCabType(String cabType) {
        switch (cabType.toLowerCase()) {
            case "premium":
                return PREMIUM_RATE_PER_KM;
            case "luxury":
                return LUXURY_RATE_PER_KM;
            default:
                return STANDARD_RATE_PER_KM;
        }
    }

    private double randomDistance() {
        return 1 + random.nextDouble() * 29;
    }
}
