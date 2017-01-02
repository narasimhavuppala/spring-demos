/**
 * 
 */
package com.demo.model.autowire;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author Shree
 *
 */
@Component
@Qualifier("car")
public class Car implements Vehicle {

	/* (non-Javadoc)
	 * @see com.demo.model.autowire.Vehicle#testSpeed()
	 */
	@Override
	public double testSpeed() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.demo.model.autowire.Vehicle#getModelYear()
	 */
	@Override
	public int getModelYear() {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.demo.model.autowire.Vehicle#isLatestMdoel()
	 */
	@Override
	public boolean isLatestMdoel() {
		// TODO Auto-generated method stub
		return false;
	}

}
