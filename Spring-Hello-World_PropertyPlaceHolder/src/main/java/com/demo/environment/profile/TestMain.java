/**
 * 
 */
package com.demo.environment.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.model.Student;

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
		//System.setProperty("spring.profiles.default", "default");
		//System.setProperty(key, value)
		AnnotationConfigApplicationContext bf = new AnnotationConfigApplicationContext(Application.class);
       DataSource ds= bf.getBean("ds",DataSource.class);
       System.out.println(ds.getUname());
	}

}
