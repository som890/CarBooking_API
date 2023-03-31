package com.lvsom.carbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lvsom.carbooking.repository.CarRepository;
//import com.lvsom.carbooking.repository.CartRepository;
import com.lvsom.carbooking.repository.UserRepository;

@Service
public class CartService {
	
//	@Autowired
//	private CartRepository cartRepository;
	
	@Autowired
	private CarRepository carRepository;
	
	@Autowired
	private UserRepository userRepository;
	
//	public Cart addCart(Long carId) {
//		Car car = carRepository.findById(carId).get();
//		
//		String username = AuthTokenFilter.CURRENT_USER;
//		String currentUser = AuthTokenFilter.CURRENT_USER;
////		Optional<User> userOptional = userRepository.findByUsername(currentUser);
//		User user = null;
////		if (userOptional.isPresent()) {
////			user = userOptional.get();
////		}
//		if(username != null) {
//			user = userRepository.findByUsername(username).get();
//		}
//		if(car != null && user !=  null) {
//			Cart cart = new Cart(user,car);
//			return cartRepository.save(cart);
//		}
//		return null;
//		
//	}
//	public List<Cart> getCarDetails() {
//		String username = AuthTokenFilter.CURRENT_USER;
//		User user = userRepository.findByUsername(username).get();
//		return cartRepository.findByUser(user);
//	}

}
