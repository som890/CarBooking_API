package com.lvsom.carbooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvsom.carbooking.model.Booking;
import com.lvsom.carbooking.model.BookingInput;
import com.lvsom.carbooking.model.Car;
import com.lvsom.carbooking.model.CarBookingQuantity;
import com.lvsom.carbooking.model.User;
import com.lvsom.carbooking.repository.BookingRepository;
import com.lvsom.carbooking.repository.CarRepository;
import com.lvsom.carbooking.repository.UserRepository;
import com.lvsom.carbooking.security.jwt.AuthTokenFilter;

@Service
public class BookingService {

	private static final String BOOKED = "Đang thuê";

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private UserRepository userRepository;

	public void doBooking(BookingInput bookingInput) {
		List<CarBookingQuantity> bookingQuantities = bookingInput.getCarBookingQuantities();

		for (CarBookingQuantity c : bookingQuantities) {
			 Car car = carRepository.findById(c.getId())
			            .orElseThrow(() -> new NoSuchElementException("Không tìm thấy xe"));
			    
			    String currentUser = AuthTokenFilter.CURRENT_USER;
			    System.out.println(currentUser);

			    
			  User user = userRepository.findById(currentUser).get();
			  //  if (userOptional.isPresent()) {
			    //		User user = userOptional.get();		        
		        Booking booking = new Booking(bookingInput.getFullName(),
			            bookingInput.getFullAddress(),
			            bookingInput.getContactNumber(),
			            BOOKED,
		                car.getDailyRentalPrice() * c.getQuantity(),		            
		                bookingInput.getStartDate(),
				        bookingInput.getEndDate(),			            
				        car,
			            user
			            );	    
		       bookingRepository.save(booking);
		}
	}

	public List<Booking> getBookingDetails() {
		String username = AuthTokenFilter.CURRENT_USER;
		User user = userRepository.findById(username).get();
		return bookingRepository.findByUser(user);
	}

	public List<Booking> getAllBooking(String status) {
		List<Booking> booking = new ArrayList<>();
		if(status.equals("All")) {
			bookingRepository.findAll().forEach(
					x -> booking.add(x));
		}else {
			bookingRepository.findByStatus(status).forEach(
					x -> booking.add(x));
		}
		return booking;
	}

	public void markBookingAsDeliverd(Long id) {
		Booking booking = bookingRepository.findById(id).get();
		if(booking != null) {
			booking.setStatus("Đã trả");
			bookingRepository.save(booking);
		}
	}
}
