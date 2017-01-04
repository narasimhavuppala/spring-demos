package com.spring.jdbc.demo.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.jdbc.object.MappingSqlQuery;

import com.spring.jdbc.demo.Department;

public class DepartmentListSqlMapper extends MappingSqlQuery<Department> {
	static String selectAll="Select * from Department";

	public DepartmentListSqlMapper(DataSource ds) {
		super(ds, selectAll);
		compile();
		
		
	}

	@Override
	protected Department mapRow(ResultSet rs, int row) throws SQLException {
		// TODO Auto-generated method stub

		Department objDepartment = new Department();
		objDepartment.setDepartmentId(rs.getInt("id"));
		objDepartment.setDepartmentHead(rs.getString("DEPARTMENTHEAD"));
		objDepartment.setDepartmentName(rs.getString("DEPARTMENTNAME"));
		return objDepartment;
	}

}
