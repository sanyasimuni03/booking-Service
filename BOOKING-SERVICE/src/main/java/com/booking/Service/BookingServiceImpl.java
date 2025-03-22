package com.booking.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.DTO.BookingResponse;
import com.booking.DTO.Status;
import com.booking.Entity.Booking;
import com.booking.Exception.BokingIdNotFoundException;
import com.booking.Repo.BookingRepository;


@Service
public class BookingServiceImpl  implements BookingService{

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private ModelMapper mapper;
	
	
	@Override
	public BookingResponse addBooking(BookingResponse response) {
     Booking bok=this.mapper.map(response, Booking.class);
      bok.setBokid(UUID.randomUUID().toString());
      bok.setBookingDate(LocalDateTime.now());
      bok.setTravelDate(LocalDateTime.now());
      bok.setStatus(Status.PEDNING);
     Booking saved= this.bookingRepository.save(bok);
		return this.mapper.map(saved, BookingResponse.class);
	}

	@Override
	public BookingResponse singleBooking(String bookingId) {
		
		 Booking bb=bookingRepository.findById(bookingId).orElseThrow(()->new BokingIdNotFoundException("Bokking ID Not Found !"));
		
		return this.mapper.map(bb, BookingResponse.class);
	}

	@Override
	public List<BookingResponse> listOfBooking() {
		 
		            List<Booking>boking=this.bookingRepository.findAll();
		            List<BookingResponse>resp= boking.stream().map((e)->this.mapper.map(e,BookingResponse.class)).collect(Collectors.toList());
		    		return resp;
	
	}

	@Override
	public void DeleteBooking(String bookingId) {
		  Booking des=this.bookingRepository.findById(bookingId).orElseThrow(()->new BokingIdNotFoundException("Bokking ID Not Found !"));
		     bookingRepository.delete(des);
			
		
	}
	
	
	public Booking bokToDto(BookingResponse bookingResponse) {
		return this.mapper.map(bookingResponse, Booking.class);
		
	}
	
	public BookingResponse DtoToBook(Booking bookingResponse) {
		return this.mapper.map(bookingResponse, BookingResponse.class);
		
	}

}
