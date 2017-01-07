/**
 * 
 */
package com.spring.jdbc.demo.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.spring.jdbc.demo.Department;
import com.spring.jdbc.demo.dao.DepartmentRepository;
import com.spring.jdbc.demo.dao.mapper.DepartmentListSqlMapper;
import com.spring.jdbc.demo.dao.mapper.DepartmentSqlMapping;

/**
 * @author Shree
 *
 */
public class DepartmentRepositoryImpl implements DepartmentRepository {

	// Templates
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	// Mappers
	private DepartmentSqlMapping sqlMapping;
	private DepartmentListSqlMapper listSqlMapping;

	@Override
	public boolean createDepartment(Department department) {
		// Stattement
		/*
		 * String SQL =
		 * "INSERT INTO DEPARTMENT(ID,DEPARTMENTHEAD,DEPARTMENTNAME) VALUES (" +
		 * department.getDepartmentId() + ",'" + department.getDepartmentHead()
		 * + "','" + department.getDepartmentName() + "')";
		 * this.jdbcTemplate.execute(SQL);
		 */

		// Prepared Statement
		String SQL = "INSERT INTO DEPARTMENT(ID, DEPARTMENTHEAD,DEPARTMENTNAME) VALUES (?,?,?)";

		// System.out.println(SQL);
		this.jdbcTemplate.update(SQL, department.getDepartmentId(), department.getDepartmentHead(),
				department.getDepartmentName());

		return true;
	}

	@Override
	public int updateDepartment(Department department) {
		// Approach 1--Statement
		String UpdateSQL = "UPDATE Department SET DEPARTMENTHEAD='" + department.getDepartmentHead()
				+ "' ,DEPARTMENTNAME='" + department.getDepartmentName() + "' WHERE id=" + department.getDepartmentId();
		System.out.println(UpdateSQL);
		return this.jdbcTemplate.update(UpdateSQL);
		// Approach 2--Prepared statment
		// String UpdateSQL2 = "UPDATE Department SET DEPARTMENTHEAD=?
		// ,DEPARTMENTNAME=? WHERE id=?";
		// return this.jdbcTemplate.update(UpdateSQL2,
		// department.getDepartmentHead(), department.getDepartmentName(),
		// department.getDepartmentId());

		// Approach 3
		// String UpdateSQL3= "UPDATE Department SET DEPARTMENTHEAD=:deptHead
		// ,DEPARTMENTNAME=:deptName WHERE id=?";

	}

	@Override
	public int deleteDepartment(int departmentId) {

		// Statement
		/*
		 * String deleteSQL = "DELETE FROM Department where id=" + departmentId;
		 * int rows = this.jdbcTemplate.update(deleteSQL);
		 */

		// Prepared Sttement
		String deleteSQL = "DELETE FROM Department where id=?";

		int rows = this.jdbcTemplate.update(deleteSQL, departmentId);

		return rows;

	}

	@Override
	public Department retrieveDepartmentById(int departmentId) {
		// Approach 1
		String SelectById = "SELECT * FROM department WHERE id=" + departmentId;
		System.out.println("SelectById=" + SelectById);
		return sqlMapping.findObject(departmentId);

		// Approach 2: Using Row Mapper
		// return this.jdbcTemplate.query(SelectById, new
		// DeparmentRowMapper()).get(0);

		// return null;

	}

	@Override
	public List<Department> retrieveDepartmentByName(String departmentname) {
		return this.listSqlMapping.execute();
	}

	@Override
	public int retrieveDepartmentsCount() {
		String sqlCount = "SELECT count(*) from Department";
		return this.jdbcTemplate.queryForObject(sqlCount, Integer.class).intValue();
	}

	private final class DeparmentRowMapper implements org.springframework.jdbc.core.RowMapper<Department> {

		@Override
		public Department mapRow(ResultSet rs, int row) throws SQLException {
			Department objDepartment = new Department();
			objDepartment.setDepartmentId(rs.getInt("id"));
			objDepartment.setDepartmentHead(rs.getString("DEPARTMENTHEAD"));
			objDepartment.setDepartmentName(rs.getString("DEPARTMENTNAME"));
			return objDepartment;
		}

	}

	public DepartmentListSqlMapper getListSqlMapping() {
		return listSqlMapping;
	}

	public void setListSqlMapping(DepartmentListSqlMapper listSqlMapping) {
		this.listSqlMapping = listSqlMapping;
	}

	public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
		return namedJdbcTemplate;
	}

	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}

	public DepartmentSqlMapping getSqlMapping() {
		return sqlMapping;
	}

	public void setSqlMapping(DepartmentSqlMapping sqlMapping) {
		this.sqlMapping = sqlMapping;
	}

	public DepartmentRepositoryImpl(JdbcTemplate jdbcTemplate) {
		super();
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public boolean[] createDepartment(final List<Department> department) {

		// Prepared Statement
		String SQL = "INSERT INTO DEPARTMENT(ID, DEPARTMENTHEAD,DEPARTMENTNAME) VALUES (?,?,?)";

		// System.out.println(SQL);
		this.jdbcTemplate.batchUpdate(SQL, new BatchPreparedStatementSetter() {

			@Override
			public int getBatchSize() {
				return department.size();
			}

			@Override
			public void setValues(PreparedStatement ps, int index) throws SQLException {

				ps.setInt(1, department.get(index).getDepartmentId());
				ps.setString(2, department.get(index).getDepartmentHead());
				ps.setString(3, department.get(index).getDepartmentName());
			}
		});

		return null;
	}

	@Override
	public int[] deleteBatchDepartment(final int[] departmentId) {

		String deleteSQL = "DELETE FROM Department where id=?";

		int[] rows = this.jdbcTemplate.batchUpdate(deleteSQL, new BatchPreparedStatementSetter() {

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return departmentId.length;
			}

			@Override
			public void setValues(PreparedStatement ps, int index) throws SQLException {
				ps.setInt(1, departmentId[index]);
			}
		});
		return rows;
	}

}
