package com.lvsom.carbooking.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lvsom.carbooking.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
	   boolean existsByEmail(String email);
	 //Optional<User> findByUsername(String username);
	   List<User> findByUsername(String username);
}
