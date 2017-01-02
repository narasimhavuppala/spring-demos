/**
 * 
 */
package com.demo.model.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Shree
 *
 */
public class TestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Person objPerson = context.getBean(Person.class);
		
		System.out.println(objPerson.getMyVehicle());
		context.close();

	}

}
