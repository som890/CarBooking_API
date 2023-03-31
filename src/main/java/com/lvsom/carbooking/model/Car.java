package com.lvsom.carbooking.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="cars")
public class Car {
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    @Column(name = "car_id")
	    private Long Id;

	    @Column(name = "make")
	    private String make;

	    @Column(name = "model")
	    private String model;

	    @Column(name = "year")
	    private int year;

	    @Column(name = "transmission")
	    private String transmission;

	    @Column(name = "fuel_type")
	    private String fuelType;

	    @Column(name = "daily_rental_price")
	    private double dailyRentalPrice;

	    @Column(name = "description")
	    private String description;
	    
	    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	    @JoinTable(name="cars_images",
	    		joinColumns = {
	    				@JoinColumn(name="cars_id")
	    },inverseJoinColumns = {
	    		@JoinColumn(name="image_id")
	    }
	    		)
	    private Set<ImageModel> carImages;
	    
		public Set<ImageModel> getCarImages() {
			return carImages;
		}

		public void setCarImages(Set<ImageModel> carImages) {
			this.carImages = carImages;
		}

		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
		}

		public String getMake() {
			return make;
		}

		public void setMake(String make) {
			this.make = make;
		}

		public String getModel() {
			return model;
		}

		public void setModel(String model) {
			this.model = model;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public String getTransmission() {
			return transmission;
		}

		public void setTransmission(String transmission) {
			this.transmission = transmission;
		}

		public String getFuelType() {
			return fuelType;
		}

		public void setFuelType(String fuelType) {
			this.fuelType = fuelType;
		}

		public double getDailyRentalPrice() {
			return dailyRentalPrice;
		}

		public void setDailyRentalPrice(double dailyRentalPrice) {
			this.dailyRentalPrice = dailyRentalPrice;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}
		public Car() {}

		public Car(Long id, String make, String model, int year, String transmission, String fuelType,
				double dailyRentalPrice, String description) {
			super();
			Id = id;
			this.make = make;
			this.model = model;
			this.year = year;
			this.transmission = transmission;
			this.fuelType = fuelType;
			this.dailyRentalPrice = dailyRentalPrice;
			this.description = description;
		}

	    


}
