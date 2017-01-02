/**
 * 
 */
package com.demo.model.autowire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Shree
 *
 */
@Component
public class Person {
	
	private String name;
	
	@Autowired
	@Qualifier("bike")
	private Vehicle myVehicle;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vehicle getMyVehicle() {
		return myVehicle;
	}

	public void setMyVehicle(Vehicle myVehicle) {
		this.myVehicle = myVehicle;
	}
	
	

}
