/**
 * 
 */
package com.demo.model;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * @author Shree
 *
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Resource rs = new ClassPathResource("appcontext.xml");
		// BeanFactory bf=new XmlBeanFactory(rs);

		ApplicationContext bf = new ClassPathXmlApplicationContext("appcontext.xml");

		Student objStudent = bf.getBean("mystudent", Student.class);
		System.out.println(objStudent.getAddres());
		Department dept = bf.getBean("mydepartment", Department.class);
		System.out.println(objStudent.getStudentName());
		System.out.println(dept.getDeptHead());
		bf.getBean("myaware");

	}

}
