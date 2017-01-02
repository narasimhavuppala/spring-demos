/**
 * 
 */
package com.demo.model.autowire;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author Shree
 *
 */
@Component
@Qualifier("auto")
public class Auto implements Vehicle {

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
