package com.lvsom.carbooking.model;

import java.util.Date;
import java.util.List;

public class BookingInput {
	private String fullName;
	private String fullAddress;
	private String contactNumber;
	private Date startDate;
	private Date endDate;
	private List<CarBookingQuantity> carBookingQuantities;
	
	public BookingInput(String fullName, String fullAddress, String contactNumber, Date startDate, Date endDate,
			List<CarBookingQuantity> carBookingQuantities) {
		super();
		this.fullName = fullName;
		this.fullAddress = fullAddress;
		this.contactNumber = contactNumber;
		this.startDate = startDate;
		this.endDate = endDate;
		this.carBookingQuantities = carBookingQuantities;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getFullAddress() {
		return fullAddress;
	}
	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public List<CarBookingQuantity> getCarBookingQuantities() {
		return carBookingQuantities;
	}
	public void setCarBookingQuantities(List<CarBookingQuantity> carBookingQuantities) {
		this.carBookingQuantities = carBookingQuantities;
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
	
	public BookingInput() {
		// TODO Auto-generated constructor stub
	}
}
