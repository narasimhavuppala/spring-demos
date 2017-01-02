/**
 * 
 */
package com.demo.environment.profile;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Shree
 *
 */
@Component
public class myAwareInterface implements ApplicationContextAware {

	ApplicationContext ac;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.ApplicationContextAware#setApplicationContext
	 * (org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(ApplicationContext paramApplicationContext) throws BeansException {
		this.ac = paramApplicationContext;
	}
	public void display(){
		System.out.println(this.ac.getDisplayName());
	}

}
