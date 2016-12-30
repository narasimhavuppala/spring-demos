/**
 * 
 */
package com.demo.model;

import org.springframework.beans.factory.BeanNameAware;

/**
 * @author Shree
 *
 */
public class Student implements BeanNameAware {
	private int id;
	private String studentName;
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
	 * @see org.springframework.beans.factory.BeanNameAware#setBeanName(java.lang.String)
	 */
	public void setBeanName(String paramString) {
		// TODO Auto-generated method stub
		
	}

}
