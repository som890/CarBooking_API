package com.lvsom.carbooking.model;

public class CarBookingQuantity {
	private Long id;
	private Integer quantity;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public CarBookingQuantity(Long id, Integer quantity) {
		super();
		this.id = id;
		this.quantity = quantity;
	}
	public CarBookingQuantity() {
		
	}
	
	
}
