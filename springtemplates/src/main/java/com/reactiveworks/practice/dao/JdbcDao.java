package com.reactiveworks.practice.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.reactiveworks.practice.model.Employee;

public class JdbcDao {

	private static final String GET_COUNT = "SELECT COUNT(*) FROM employee;";
	private static final String GET_NAME = "SELECT name FROM employee where id=?;";
	private static final String GET_Employee = "SELECT * FROM employee WHERE id=?;";
	private static final String GET_Employees = "SELECT * FROM employee;";
	private static final String INSERT_QUERY = "INSERT INTO employee VALUES(?,?,?)";
	private static final String DELETE_QUERY = "DELETE FROM employee WHERE id=?";
	private static JdbcTemplate jdbcTemplate1;
	public static JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate1;
	}

	public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		JdbcDao.jdbcTemplate1 = jdbcTemplate;
	}


	public int getRecordCount() {

		return jdbcTemplate1.queryForObject(GET_COUNT, Integer.class);
	}

	public String getEmployeeName(int empId) {
		String name = jdbcTemplate1.queryForObject(GET_NAME, new Object[] { empId }, String.class);
		return name;
	}

	public Employee getEmployeeById(int id) {
		Employee empObj = jdbcTemplate1.queryForObject(GET_Employee, new Object[] { id }, new EmployeeMapper());
		return empObj;
	}

	public List<Employee> getEmployees() {
		List<Employee> employees = jdbcTemplate1.query(GET_Employees, new EmployeeMapper());
		return employees;
	}

	public void insertEmployee(Employee employee) {

		jdbcTemplate1.update(INSERT_QUERY, new Object[] { employee.getId(), employee.getName(), employee.getSalary() });
	}

	public void deleteEmployee(int id) {
		jdbcTemplate1.update(DELETE_QUERY, new Object[] { id });
	}

	private static final class EmployeeMapper implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Employee empObj = new Employee();
			empObj.setId(resultSet.getInt(1));
			empObj.setName(resultSet.getString(2));
			empObj.setSalary(resultSet.getInt(3));
			return empObj;
		}

	}

	public void insertEmployees(Employee... employees) {
		String[] query = new String[employees.length];
		for (int index = 0; index < employees.length; index++) {

			query[index] = "INSERT INTO employee VALUES(\"" + employees[index].getId() + "\",\""
					+ employees[index].getName() + "\",\"" + employees[index].getSalary() + "\");";
		}

		jdbcTemplate1.batchUpdate(query);
	}

	public void insertEmployees(List<Employee> employees) {

		String QUERY = "INSERT INTO employee VALUES(?,?,?);";
		jdbcTemplate1.batchUpdate(QUERY, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement statement, int index) throws SQLException {
				statement.setInt(1, employees.get(index).getId());
				statement.setString(2, employees.get(index).getName());
				statement.setInt(3, employees.get(index).getSalary());

			}

			@Override
			public int getBatchSize() {

				return employees.size();
			}
		});

	}

}