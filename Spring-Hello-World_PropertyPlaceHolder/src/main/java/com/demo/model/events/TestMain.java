/**
 * 
 */
package com.demo.model.events;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
		
		AnnotationConfigApplicationContext bf = new AnnotationConfigApplicationContext(AppConfig.class);
		//AnnotationConfigApplicationContext bf_1 = new AnnotationConfigApplicationContext(AppConfig11.class);
		//Student objStudent = bf.getBean("mystudent", Student.class);
		//System.out.println("Address=" + objStudent);
		//Department dept = bf.getBean("mydepartment", Department.class);
		//myAwareInterface ma= (myAwareInterface) bf.getBean("myAwareInterface");
		//bf.setEnvironment("");
		//bf.refresh();
		//System.out.println("Environemnt=" + dept.getDeptHead());
		//ma.display();
		bf.close();

	}

}
