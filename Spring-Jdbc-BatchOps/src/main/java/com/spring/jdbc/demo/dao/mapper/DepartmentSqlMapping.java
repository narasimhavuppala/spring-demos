package com.spring.jdbc.demo.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;

import com.spring.jdbc.demo.Department;

public class DepartmentSqlMapping extends MappingSqlQuery<Department> {
	
	public DepartmentSqlMapping(DataSource ds) {
        super(ds, "select *  from Department   where id=?");
        super.declareParameter(new SqlParameter("id", Types.INTEGER));
        
        compile();
    }

	@Override
	protected Department mapRow(ResultSet rs, int rowNum) throws SQLException {
		Department objDepartment=new Department();
		objDepartment.setDepartmentId(rs.getInt("id"));
		objDepartment.setDepartmentHead(rs.getString("DEPARTMENTHEAD"));
		objDepartment.setDepartmentName(rs.getString("DEPARTMENTNAME"));
		return objDepartment;
	}

}
