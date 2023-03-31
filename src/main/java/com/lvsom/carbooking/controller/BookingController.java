package com.lvsom.carbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lvsom.carbooking.model.Booking;
import com.lvsom.carbooking.model.BookingInput;
import com.lvsom.carbooking.service.BookingService;

@RestController
@RequestMapping({"/order" })
@CrossOrigin(originPatterns = "http://localhost:4200")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	//@PreAuthorize("hasRole('USER')")
	@PostMapping({"/booking"})
	public void doBooking(@RequestBody BookingInput bookingInput) {
		bookingService.doBooking(bookingInput);
	}
	//@PreAuthorize("hasRole('USER')")
	@GetMapping({"/getBookingDetails"})
	public List<Booking> getBookingDetails() {
		return bookingService.getBookingDetails();
	}

	@GetMapping({"/getAllBookingDetails/status"})
	public List<Booking> getAllBooking(@PathVariable(name="status") String status) {
		return bookingService.getAllBooking(status);
	}
	
	@GetMapping({"/markBookingAsDelivered/{id}"})
	public void markBookingAsDeliverd(@PathVariable(name="id") Long id) {
		bookingService.markBookingAsDeliverd(id);
	}
}
