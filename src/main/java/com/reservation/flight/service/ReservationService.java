package com.reservation.flight.service;

import com.reservation.flight.dto.ReservationRequest;
import com.reservation.flight.entity.Reservation;

public interface ReservationService {
	Reservation bookFlight(ReservationRequest request);
}