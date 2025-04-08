package com.hiber;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressId;
	
	@Column(name="address_Street")
	private String street;
	
	@Column(length=40,name="address_city")
	private String City;

	@Column(name="is_open")
	private boolean isOpen;
	
	@Transient
	private double x;
	
	@Temporal(TemporalType.DATE)
	private Date addedDate;

	
	
	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int addressId, String street, String city, boolean isOpen, double x, Date addedDate) {
		super();
		this.addressId = addressId;
		this.street = street;
		City = city;
		this.isOpen = isOpen;
		this.x = x;
		this.addedDate = addedDate;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", City=" + City + ", isOpen=" + isOpen
				+ ", x=" + x + ", addedDate=" + addedDate + "]";
	}
	
}
