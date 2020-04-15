package com.reactiveworks.practice.configuration.ex2;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Address {

	@Value("abc") // to assign default value
	private String city;
	@Value("karnataka")
	private String state;
	@Value("585102")
	private String pincode;

	public Address() {
		System.out.println("address object is created");
	}

	public Address(String city, String state, String pincode) {
		System.out.println("address object is created");
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", pincode=" + pincode + "]";
	}

}
