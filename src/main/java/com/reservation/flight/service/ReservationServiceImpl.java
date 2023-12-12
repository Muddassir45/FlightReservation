package com.reservation.flight.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reservation.flight.dto.ReservationRequest;
import com.reservation.flight.entity.Flight;
import com.reservation.flight.entity.Passenger;
import com.reservation.flight.entity.Reservation;
import com.reservation.flight.repository.FlightRepository;
import com.reservation.flight.repository.PassengerRepository;
import com.reservation.flight.repository.ReservationRepository;
import com.reservation.flight.util.EmailUtil;
import com.reservation.flight.util.PDFGenerator;


@Service
public class ReservationServiceImpl implements ReservationService {
	@Autowired
	private FlightRepository flightRepository;
	@Autowired
	private PassengerRepository passengerRepository;
	@Autowired
	private ReservationRepository reservationRepository;
	
	@Autowired
	PDFGenerator pdfGenerator;
	@Autowired
	EmailUtil emailUtil;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationServiceImpl.class);

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		Long flightId = request.getId();
		Flight flight = flightRepository.findById(flightId).get();
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setMiddleName(request.getPassengerMiddleName());
		passenger.setLastName(request.getPassengerlastName());
		passenger.setPhone(request.getPassengerPhone());
		passenger.setEmail(request.getPassengerEmail());
		Passenger savedPassenger = passengerRepository.save(passenger);
		
		Reservation reservation = new Reservation();
		reservation.setFlight(flight);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		
		Reservation savedReservation = reservationRepository.save(reservation);
		
		String filePath = "C:\\Users\\rmudd\\OneDrive\\Desktop\\flightPdf\\"+"Invoice-"+savedReservation.getId()+".pdf";
		System.out.println(filePath);
		pdfGenerator.generateItinerary(savedReservation, filePath);
		emailUtil.sendItinerary(passenger.getEmail(),filePath);
		return savedReservation;
	}
	
}
