package com.lvsom.carbooking.controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lvsom.carbooking.model.Car;
import com.lvsom.carbooking.model.ImageModel;
import com.lvsom.carbooking.service.CarService;

@RestController
@RequestMapping({"/car" })
@CrossOrigin(originPatterns = "http://localhost:4200")
public class CarController {

	@Autowired
	private CarService carService;
	
	//@PreAuthorize("hasRole('ADMIN')")
	//@Secured("hasRole('ADMIN')")
	@PostMapping(value = "/add", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public Car addCar(@RequestPart("car") Car car, @RequestPart("imageFile") MultipartFile[] file) {

		try {
			Set<ImageModel> images = uploadImage(file);
			car.setCarImages(images);
			return carService.addNewCar(car);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public Set<ImageModel> uploadImage(MultipartFile[] multipartFiles) throws IOException {
		Set<ImageModel> carImages = new HashSet<>();
		for (MultipartFile file : multipartFiles) {
			ImageModel carImage = new ImageModel(  
					file.getOriginalFilename(), file.getContentType(), file.getBytes());
			carImages.add(carImage);
		}
		return carImages;
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/get")
	public List<Car> getAllCars(@RequestParam(defaultValue = "0")int pageNumber,
								@RequestParam(defaultValue = "") String searchKey) {
		List<Car> result =  carService.getAllCars(pageNumber, searchKey);
		System.out.println("The result is size: "+ result.size());
		return result;
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/get/{id}")
	public Car getCarDetailsById(@PathVariable("id") Long id) {
		return carService.getCarDetailsById(id);
	}
	
	//@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping(value = "/delete/{id}")
	public void deleteCarDetails(@PathVariable("id") Long id) {
		carService.deleteCarDetails(id);
	}
	
	//@GetMapping("/getCarDetails/{isSingleCarCheckOut}/{id}")
	public List<Car> getCarDetails(@PathVariable(name="isSingleCarCheckOut") boolean isSingleCarCheckOut,
								@PathVariable(name="id") Long id) {
		return carService.getCarDetails(isSingleCarCheckOut,id);
	}
}
