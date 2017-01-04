package com.spring.jdbc.demo.dao;

import java.util.List;

import com.spring.jdbc.demo.Department;

public interface DepartmentRepository {
	//CRUD
	//Create 
	
	public boolean createDepartment(Department department);
	
	//Update
	public int updateDepartment(Department department);
	
	//Delete
	public int deleteDepartment(int departmentId);

	//retrivals
	public int retrieveDepartmentsCount();
	public Department retrieveDepartmentById(int departmentId);
	public List<Department> retrieveDepartmentByName(String departmentname);
	

}
