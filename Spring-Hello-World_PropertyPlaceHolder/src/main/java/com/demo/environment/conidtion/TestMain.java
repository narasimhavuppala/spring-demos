/**
 * 
 */
package com.demo.environment.conidtion;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * @author Shree
 *
 */
public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	   
		System.setProperty("env", "dev");
		///File1--db
		//File2--db
		//ApplicationContext context=new FileSystemXmlApplicationContext("C:\\src\\main\\res\\appcontext.xml");
		ApplicationContext ac=new ClassPathXmlApplicationContext("appcontext.xml");
	   AnnotationConfigApplicationContext bf = new AnnotationConfigApplicationContext(Application.class);
       DataSource ds= bf.getBean("ds",DataSource.class);
       System.out.println(ds);
	}

}
