package com.reservation.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservation.flight.entity.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}