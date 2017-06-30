/**
 * 
 */
package com.demo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

/**
 * @author Shreemaan-Home
 *
 * 
 */
@Configuration
@ComponentScan(basePackages = { "com.demo.model" })
@PropertySource(value = "classpath:app.properties", ignoreResourceNotFound = true)
public class AppConfig {

	@Autowired
	private Environment env;

	@Bean(name = "address")
	public Address getAddress() {
		return new Address();
	}

	@Bean(name = "mydepartment")
	@Scope(value = "prototype")
	public Department getDepartment() {
		Department dept = new Department();
		dept.setDeptHead(env.getProperty("dept.deprtmentHead"));
		return dept;
	}

	@Bean(name = "mystudent")
	public Student getStudent(Department dept) {
		Student student = new Student(dept);
		String environemt = env.getProperty("OS");
		System.out.println("environemt=" + environemt);
		return student;

	}

}
