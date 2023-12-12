package com.reservation.flight.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.reservation.flight.dto.ReservationRequest;
import com.reservation.flight.entity.Flight;
import com.reservation.flight.entity.Reservation;
import com.reservation.flight.repository.FlightRepository;
import com.reservation.flight.repository.ReservationRepository;
import com.reservation.flight.service.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private ReservationRepository reservationRepository;
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId,ModelMap modelMap) {
		Flight flight = flightRepository.findById(flightId).get();
		modelMap.addAttribute("flight",flight);
		return "reservation/completeReservation";
	}
	
	@RequestMapping("/completeReservation")
	public String completeReservation(ReservationRequest request,ModelMap modelMap) {
		Reservation reservation = reservationService.bookFlight(request);
		modelMap.addAttribute("msg", "Reservation created successfully and id is "+reservation.getId());
		return "reservation/reservationConfirmation";
	}
	
	@RequestMapping("/showAllReservations")
	public String getReservationList(ModelMap modelMap) {
		List<Reservation> list = reservationRepository.findAll();
		modelMap.addAttribute("res",list);
		return "reservation/myreservations";
	}
	
	@RequestMapping("/completeCheckedIn")
	public String getCheckedInPage(@RequestParam("reservationId") Long id , ModelMap modelMap) {
		Reservation reservation = reservationRepository.findById(id).get();
		modelMap.addAttribute("resDetails",reservation);
		return "reservation/checked";
	}
	
	
	
}
