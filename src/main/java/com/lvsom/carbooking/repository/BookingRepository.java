package com.lvsom.carbooking.repository;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lvsom.carbooking.model.Booking;
import com.lvsom.carbooking.model.User;

public interface BookingRepository extends CrudRepository<Booking, Long>{
	public List<Booking> findByUser(User user);
	List<Booking> findByStatus(String status);

}
