/**
 * 
 */
package com.demo.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.demo.Application;

/**
 * @author Shree
 *
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        // Resource rs = new ClassPathResource("appcontext.xml");
		// BeanFactory bf=new XmlBeanFactory(rs);

		//ApplicationContext bf = new ClassPathXmlApplicationContext("appcontext.xml");
		ApplicationContext bf = new AnnotationConfigApplicationContext(Application.class);

		Student objStudent = bf.getBean("mystudent", Student.class);
		System.out.println("Address=" + objStudent.getAddres());
		Department dept = bf.getBean("mydepartment", Department.class);
		System.out.println(  objStudent.getStudentName());
		
		System.out.println(objStudent.getSystemEnvironment());
		System.out.println(objStudent.getSystemProperties());
		System.out.println(dept.getDeptHead());
		bf.getBean("myaware");

	}

}
