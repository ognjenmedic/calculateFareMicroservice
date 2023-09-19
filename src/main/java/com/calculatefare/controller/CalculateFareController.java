package com.calculatefare.controller;

import com.calculatefare.entity.FareRequest;
import com.calculatefare.service.CalculateFareService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequestMapping("/api")
public class CalculateFareController {

    private final CalculateFareService calculateFareService;

    private static final Logger logger = LoggerFactory.getLogger(CalculateFareController.class);

    @Autowired
    public CalculateFareController(CalculateFareService calculateFareService) {
        this.calculateFareService = calculateFareService;
    }

    @PostMapping(value = "/calculateFare", consumes = "application/json")
    public String calculateFare(@RequestBody FareRequest fareRequest, Model model) {
        logger.info("Entered calculateFare method.");
        logger.info("Received FareRequest: {}", fareRequest);

        double fare = calculateFareService.calculateFare(fareRequest);
        
        logger.info("Calculated fare: {}", fare);
        
        model.addAttribute("fare", fare);

        return "estimatedFare";
    }
}
