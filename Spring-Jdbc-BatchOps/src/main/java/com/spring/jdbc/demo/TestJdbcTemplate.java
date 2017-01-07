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

		for (int i = 0; i < 1000; i++) {
			Department objDepartment = new Department();
			objDepartment.setDepartmentId(i);
			objDepartment.setDepartmentName("DeptName" + i);
			objDepartment.setDepartmentHead("DeptHead" + i);
			objDepartmentList.add(i, objDepartment);

		}

		// Delete and Insert query
		long start = System.currentTimeMillis();
		Iterator<Department> itrDepartment = objDepartmentList.iterator();
		while (itrDepartment.hasNext()) {

			Department obj = itrDepartment.next();
			objDeptdao.deleteDepartment(obj.getDepartmentId());
			objDeptdao.createDepartment(obj);

		}
		long end = System.currentTimeMillis();

		System.out.println("Time for action  in Seconds =" + ((end - start) / 1000));

		context.close();

	}

}
