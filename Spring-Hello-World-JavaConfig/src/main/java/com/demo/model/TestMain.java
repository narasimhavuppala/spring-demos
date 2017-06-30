/**
 * 
 */
package com.demo.model;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		
		AnnotationConfigApplicationContext bf=new AnnotationConfigApplicationContext(AppConfig.class);
		//bf.register(AppConfig.class);

		Student objStudent=(Student)bf.getBean("mystudent" );
		Department dept=(Department)bf.getBean("mydepartment");
		
		System.out.println(dept.getDeptHead());
		
		
		//System.out.println(objStudent.getAddres());
		//System.out.println(objStudent.getDepartment());

	}

}
