package com.booking.Service;

import java.util.List;

import com.booking.DTO.BookingResponse;

public interface BookingService {
	
	public BookingResponse addBooking(BookingResponse response);
	
	public BookingResponse singleBooking(String bookingId);
	
	public List<BookingResponse>listOfBooking();
	
	void DeleteBooking(String bookingId);
	
	

}
