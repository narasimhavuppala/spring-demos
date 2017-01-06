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
		
		
	   // Resource rs=new ClassPathResource("appcontext.xml");
		//BeanFactory bf=new XmlBeanFactory(rs);	
		
		ApplicationContext bf=new ClassPathXmlApplicationContext("appcontext.xml");

		Student objStudent=(Student)bf.getBean("mystudent" );
		Department dept=(Department)bf.getBean("mydepartment");
		
	//	System.out.println(dept.getDeptHead());
		
		
		System.out.println(objStudent.getAddres());
		System.out.println(objStudent.getDepartment());

	}

}
