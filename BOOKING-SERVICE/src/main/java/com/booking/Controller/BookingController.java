package com.booking.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.DTO.BookingResponse;
import com.booking.Service.BookingService;


import jakarta.validation.Valid;

@RestController
@RequestMapping("/bok/api")
public class BookingController {
	
	@Autowired
	private BookingService service;
	
	
	@PostMapping("/addBooking")
	public ResponseEntity<BookingResponse>addBooking(@Valid @RequestBody BookingResponse bookingResponse){
	
		BookingResponse resp=this.service.addBooking(bookingResponse);
		
		return new ResponseEntity<>(resp,HttpStatus.CREATED);
	}
	
	
	@GetMapping("/{bookingId}")
	public ResponseEntity<BookingResponse>SingleDestination(@PathVariable String  bookingId){
	
		BookingResponse resp=this.service.singleBooking(bookingId);
		
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<List<BookingResponse>>ListDestination(){
	
		List<BookingResponse> resp=this.service.listOfBooking();
		
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}
	
	@DeleteMapping("/{bookingId}")
	public ResponseEntity<?>DeleteDestination(@PathVariable String  bookingId){
	
		this.service.DeleteBooking(bookingId);
		
		return new ResponseEntity<>("Delete Booking Success!!",HttpStatus.OK);
	}
	
	

}
