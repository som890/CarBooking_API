package com.lvsom.carbooking.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lvsom.carbooking.model.Car;

@Repository
public interface CarRepository extends CrudRepository<Car, Long>{

	public List<Car> findAll(Pageable pageable);
	public List<Car> findByModelContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String key1, String key2, Pageable pageable);

}
