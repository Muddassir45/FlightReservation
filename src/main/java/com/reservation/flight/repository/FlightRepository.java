package com.reservation.flight.repository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reservation.flight.entity.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {
    
    @Query(value = "from Flight where departureCity=:from and arrivalCity=:to and dateOfDeparture=:dateOfDeparture")
    List<Flight> findFlights(@Param("from") String from, @Param("to") String to, @Param("dateOfDeparture") LocalDate dateOfDeparture);
}
