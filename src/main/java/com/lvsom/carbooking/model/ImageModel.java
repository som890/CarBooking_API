package com.lvsom.carbooking.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "image_model")
public class ImageModel {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String type;
	@Column(length = 500000)
	private byte[] picType;

	public ImageModel() {
	}

	public ImageModel(String name, String type, byte[] picType) {
		super();
		this.name = name;
		this.type = type;
		this.picType = picType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getPicType() {
		return picType;
	}

	public void setPicType(byte[] picType) {
		this.picType = picType;
	}

}
