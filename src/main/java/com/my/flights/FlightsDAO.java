package com.my.flights;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightsDAO extends JpaRepository<Flight, Long> { }