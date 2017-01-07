package com.spring.jdbc.demo;

import java.util.ArrayList;
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

		// Create 10 objects

		List<Department> objDepartmentList = new ArrayList<Department>();
		
		int [] batchIds=new int[1000];

		for (int i = 0; i < 1000; i++) {
			Department objDepartment = new Department();
			objDepartment.setDepartmentId(i);
			batchIds[i]=i;
			objDepartment.setDepartmentName("DeptName" + i);
			objDepartment.setDepartmentHead("DeptHead" + i);
			objDepartmentList.add(i, objDepartment);

		}

		// Delete and Insert query
		long start = System.currentTimeMillis();
		objDeptdao.deleteBatchDepartment(batchIds);
		objDeptdao.createDepartment(objDepartmentList);

		long end = System.currentTimeMillis();

		System.out.println("Time for action  in Seconds =" + ((end - start) / 1000));

		context.close();

	}

}
