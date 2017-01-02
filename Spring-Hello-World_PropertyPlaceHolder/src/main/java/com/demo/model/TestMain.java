/**
 * 
 */
package com.demo.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.model.events.AppConfig;


/**
 * @author Shree
 *
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.setProperty("spring.profiles.active", "prod");
		//ApplicationContext ac=new ClassPathXmlApplicationContext("appcontext.xml");
		
		AnnotationConfigApplicationContext bf = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Student objStudent = bf.getBean("mystudent", Student.class);
		System.out.println("Address=" + objStudent);
		Department dept = bf.getBean("mydepartment", Department.class);
		System.out.println("Environemnt=" + dept.getDeptHead());
		//Object ob=bf.getBean("myaware");
		bf.close();

	}

}
