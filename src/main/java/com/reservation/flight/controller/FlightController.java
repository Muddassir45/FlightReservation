package com.reservation.flight.controller;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.reservation.flight.entity.Flight;
import com.reservation.flight.repository.FlightRepository;

@Controller
public class FlightController {
    @Autowired
    private FlightRepository flightRepository;

    @PostMapping("/searchFlight")
    public String findFlight() {
        return "flight/findFlights";
    }

    @PostMapping("/findFlights")
    public String findFlights(
        @RequestParam("from") String from,
        @RequestParam("to") String to,
        @RequestParam("dateOfDeparture") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate dateOfDeparture, 
        ModelMap modelMap) {

        List<Flight> flights = flightRepository.findFlights(from, to, dateOfDeparture);
        modelMap.addAttribute("flights", flights);
        
        return "flight/displayFlightst";
    }
}
