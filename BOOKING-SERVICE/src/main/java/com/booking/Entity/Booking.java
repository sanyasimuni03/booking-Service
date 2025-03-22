package com.booking.Entity;

import java.time.LocalDateTime;

import com.booking.DTO.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
	
        @Id
	    private String bokid;               
	    private String tripId;           
	    private Integer userId;
	    private String destinationId;
	    private LocalDateTime bookingDate; 
	    private LocalDateTime travelDate;  
	    private Integer numberOfPeople;   
	    private Double totalPrice;      
	    private Status status;           

}
