package com.spring.jdbc.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.jdbc.demo.dao.DepartmentRepository;
import com.spring.jdbc.demo.dao.impl.DepartmentRepositoryImpl;

public class TestJdbcTemplate {

	public static void main(String[] args) throws Exception {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("appconfig.xml");
		DepartmentRepository objDeptdao = context.getBean(DepartmentRepositoryImpl.class);
		// Department

		// Create 10 objects

		List<Department> objDepartmentList = new ArrayList<Department>();

		for (int i = 0; i < 10; i++) {
			Department objDepartment = new Department();
			objDepartment.setDepartmentId(i);
			objDepartment.setDepartmentName("DeptName" + i);
			objDepartment.setDepartmentHead("DeptHead" + i);
			objDepartmentList.add(i,objDepartment);

		}
		
		System.out.println(objDepartmentList.size());

		context.close();

	}

}
