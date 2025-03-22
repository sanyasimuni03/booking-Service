package com.booking.DTO;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class BookingResponse {
	
	
	    private String bokid;               
	    private String tripId;           
	    private Integer userId;
	 
	    @NotBlank(message = "Destination ID cannot be blank")
	    private String destinationId;
	    private LocalDateTime bookingDate;
	    private LocalDateTime travelDate;
	    @NotNull(message = "Number of people is required")
	    @Min(value = 1, message = "At least one person must be included in the trip")
	    private Integer numberOfPeople;
	    @NotNull(message = "Total price is required")
	    @Positive(message = "Total price must be greater than zero")
	    private Double totalPrice;
	    private Status status;

}
