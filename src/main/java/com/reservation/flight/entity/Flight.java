package com.reservation.flight.entity;
import java.time.LocalDate;
import java.sql.Timestamp;
import javax.persistence.Entity;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Flight extends AbstractEntity {
    private String flightNumber;
    private String operatingAirlines;
    private String departureCity;
    private String arrivalCity;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfDeparture;

    private Timestamp estimatedDepartureTime;

    public Flight() {
        super();
    }

    public Flight(String flightNumber, String operatingAirlines, String departureCity, String arrivalCity,
            LocalDate dateOfDeparture, Timestamp estimatedDepartureTime) {
        super();
        this.flightNumber = flightNumber;
        this.operatingAirlines = operatingAirlines;
        this.departureCity = departureCity;
        this.arrivalCity = arrivalCity;
        this.dateOfDeparture = dateOfDeparture;
        this.estimatedDepartureTime = estimatedDepartureTime;
    }

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getOperatingAirlines() {
		return operatingAirlines;
	}

	public void setOperatingAirlines(String operatingAirlines) {
		this.operatingAirlines = operatingAirlines;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getArrivalCity() {
		return arrivalCity;
	}

	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}

	public LocalDate getDateOfDeparture() {
		return dateOfDeparture;
	}

	public void setDateOfDeparture(LocalDate dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}

	public Timestamp getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}

	public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}

   }
