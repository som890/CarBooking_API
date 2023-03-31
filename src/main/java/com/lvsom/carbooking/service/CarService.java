package com.lvsom.carbooking.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lvsom.carbooking.model.Car;
import com.lvsom.carbooking.repository.CarRepository;

@Service
public class CarService {
	
	@Autowired
	private CarRepository carRepository;
	
	public Car addNewCar(Car car) {
		return carRepository.save(car);
	}
	public List<Car> getAllCars(int pageNumber, String searchKey) {
		Pageable pageable = PageRequest.of(pageNumber, 10);
		
		if(searchKey.equals("")) {
			return (List<Car>) carRepository.findAll(pageable);
		}else {
			return (List<Car>) carRepository.findByModelContainingIgnoreCaseOrDescriptionContainingIgnoreCase(searchKey, searchKey, pageable);
		}	
	}
	public Car getCarDetailsById(Long id) {
		return carRepository.findById(id).get();
	}
	
	public void deleteCarDetails(Long id) { 
		carRepository.deleteById(id);
	}
	
	public List<Car> getCarDetails(boolean isSingleCarCheckOut,Long id) {
		if(isSingleCarCheckOut) {
			List<Car> list = new ArrayList<>();
			Car car = carRepository.findById(id).get();
			list.add(car);
			return list;
		}else {
//			String currentUser = AuthTokenFilter.CURRENT_USER;
//			Optional<User> userOptional = userRepository.findByUsername(currentUser);
//			
//			 User user = null;
//			if (userOptional.isPresent()) {
//				user = userOptional.get();
//			}
//			List<Cart> carts = cart.findByUser(user);
			
//			return carts.stream().map(x -> x.getCar()).collect(Collectors.toList());
			}
		return new ArrayList<>();
	}

}
