package com.booking.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.Entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String>{
	

}
