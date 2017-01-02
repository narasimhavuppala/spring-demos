/**
 * 
 */
package com.demo.model.events;

import java.util.Map;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author Shree
 *
 */
@Component("mystudent")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Student implements BeanNameAware {
	private int id;
	//@Value("#{systemEnvironment['env']}")
	private String studentName;
	
	@Value("#{systemProperties}")
	private Map systemProperties;
	
	@Value("#{systemEnvironment}")
	private Map systemEnvironment;

	@Autowired
	private Address addres;
	private Department department;

	@Autowired
	public Student(Department department) {
		super();
		this.department = department;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Address getAddres() {
		return addres;
	}

	public void setAddres(Address addres) {
		this.addres = addres;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.beans.factory.BeanNameAware#setBeanName(java.lang.
	 * String)
	 */
	public void setBeanName(String paramString) {

	}

	public Map getSystemProperties() {
		return systemProperties;
	}

	public void setSystemProperties(Map systemProperties) {
		this.systemProperties = systemProperties;
	}

	public Map getSystemEnvironment() {
		return systemEnvironment;
	}

	public void setSystemEnvironment(Map systemEnvironment) {
		this.systemEnvironment = systemEnvironment;
	}
	
	

}
