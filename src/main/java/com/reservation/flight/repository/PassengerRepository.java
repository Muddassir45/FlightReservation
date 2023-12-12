package com.reservation.flight.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservation.flight.entity.Passenger;


public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}