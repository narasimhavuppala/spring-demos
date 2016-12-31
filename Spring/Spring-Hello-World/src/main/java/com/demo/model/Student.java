/**
 * 
 */
package com.demo.model;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

/**
 * @author Shree
 *
 */
public class Student implements InitializingBean,DisposableBean {
	private int id;
	private String studentName;
	//@Autowired
	private Address addres;
	private Department  department;
	

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

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.DisposableBean#destroy()
	 */
	@PreDestroy
	public void destroy() throws Exception {

		System.out.println("before Destroy for Student");
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@PostConstruct
	public void afterPropertiesSet() throws Exception {

		System.out.println("After properties set for Student");
	}

}
