package com.reservation.flight.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reservation.flight.entity.User;



public interface UserRepository extends JpaRepository<User, Long>{
public List<User> findByEmail(String email);
}
