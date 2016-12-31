
/**
 * 
 */
package com.demo.model;

import org.springframework.stereotype.Component;

/**
 * @author Shree
 *
 */
@Component
public class Address {

	private String streetName;
	private String city;
	private int zip;

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

}
