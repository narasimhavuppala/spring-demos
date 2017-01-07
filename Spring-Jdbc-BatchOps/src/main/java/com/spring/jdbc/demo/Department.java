package com.spring.jdbc.demo;

import java.io.Serializable;

public class Department  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int departmentId;
	private String departmentHead;
	private String departmentName;

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentHead() {
		return departmentHead;
	}

	public void setDepartmentHead(String departmentHead) {
		this.departmentHead = departmentHead;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
