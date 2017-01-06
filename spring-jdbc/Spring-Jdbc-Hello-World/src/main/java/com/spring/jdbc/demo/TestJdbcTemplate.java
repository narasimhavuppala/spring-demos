package com.spring.jdbc.demo;

import java.util.Iterator;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.demo.dao.DepartmentRepository;
import com.spring.jdbc.demo.dao.impl.DepartmentRepositoryImpl;

public class TestJdbcTemplate {

	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appconfig.xml");
		DepartmentRepository objDeptdao = context.getBean(DepartmentRepositoryImpl.class);
		// Department
		Department objDepartment = new Department();

		// Delete
		int numberOfRowsDeleted = objDeptdao.deleteDepartment(6);
		System.out.println("Dleted rows count=" + numberOfRowsDeleted);

		// Create
		objDepartment.setDepartmentId(6);
		objDepartment.setDepartmentName("DemoName");
		objDepartment.setDepartmentHead("Demohead");
		objDeptdao.createDepartment(objDepartment);

//		// Update

		objDepartment.setDepartmentHead("Updated-DemoHead");
		objDepartment.setDepartmentName("Updated-DemoName");
		int numberofRowsUpdated = objDeptdao.updateDepartment(objDepartment);
//
		System.out.println("numberofRowsUpdated=" + numberofRowsUpdated);
//
//		// Select for Single Values--Count,column Names etc
		int tableRowsCount = objDeptdao.retrieveDepartmentsCount();
		System.out.println("tableRowsCount=" + tableRowsCount);
//
//		// Select for Single row
	Department objRetrieved = objDeptdao.retrieveDepartmentById(5);
//
//		// Select Multiple rows
//		List<Department> listdepartments = objDeptdao.retrieveDepartmentByName("test");
//		Iterator<Department> it = listdepartments.iterator();
//		while(it.hasNext())
//		{
//			Department dep=it.next();
//			System.out.println(dep.getDepartmentName());
//		}
//
//		System.out.println(objRetrieved.getDepartmentHead());
//
		context.close();

	}

}
