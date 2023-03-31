package com.lvsom.carbooking.model;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lvsom.carbooking.CustomDateDeserializer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    private String fullNameBooking;
    private String fullBooking;
    private String contactNumberBooking;
    private String status;
    private Double amout;
    @JsonDeserialize(using = CustomDateDeserializer.class)
	private Date startDate;
    @JsonDeserialize(using = CustomDateDeserializer.class)
    private Date endDate;
    @OneToOne(cascade = CascadeType.ALL)
    private Car car;
    @OneToOne(cascade = CascadeType.ALL)
    private User user;
    
    public Booking() {}

	public Booking(String fullNameBooking, String fullBooking, String contactNumberBooking, String status, Double amout,
			Date startDate, Date endDate, Car car, User user) {
		super();
		this.fullNameBooking = fullNameBooking;
		this.fullBooking = fullBooking;
		this.contactNumberBooking = contactNumberBooking;
		this.status = status;
		this.amout = amout;
		this.startDate = startDate;
		this.endDate = endDate;
		this.car = car;
		this.user = user;
	}
	public String getFullBooking() {
		return fullBooking;
	}


	public void setFullBooking(String fullBooking) {
		this.fullBooking = fullBooking;
	}


	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getFullNameBooking() {
		return fullNameBooking;
	}
	public void setFullNameBooking(String fullNameBooking) {
		this.fullNameBooking = fullNameBooking;
	}
	public String getContactNumberBooking() {
		return contactNumberBooking;
	}
	public void setContactNumberBooking(String contactNumberBooking) {
		this.contactNumberBooking = contactNumberBooking;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getAmout() {
		return amout;
	}
	public void setAmout(Double amout) {
		this.amout = amout;
	}
    
    

}
