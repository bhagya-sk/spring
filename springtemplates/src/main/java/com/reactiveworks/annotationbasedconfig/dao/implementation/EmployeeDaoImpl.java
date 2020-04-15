package com.reactiveworks.annotationbasedconfig.dao.implementation;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.reactiveworks.annotationbasedconfig.dao.IEmployeeDao;
import com.reactiveworks.practice.model.Employee;

public class EmployeeDaoImpl extends JdbcDaoSupport implements IEmployeeDao {

	private static final String SELECT_QUERY = "SELECT * FROM employee;";
	private static final String UPDATE_QUERY = "UPDATE employee SET name=? WHERE id=?;";
	private static final String DELETE_QUERY = "DELETE FROM employee WHERE id=?;";
	private static final String INSERT_QUERY = "INSERT INTO employee VALUES(?,?,?);";

	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = getJdbcTemplate().query(SELECT_QUERY, new EmployeeMapper());
		return employees;
	}

	@Override
	public void updateEmployee(int id) {
		getJdbcTemplate().update(UPDATE_QUERY, new Object[] { id, "adi" });
	}

	@Override
	public void deleteEmployee(int id) {
		getJdbcTemplate().update(DELETE_QUERY, new Object[] { id });
	}

	@Override
	public void insertEmployee(Employee employee) {
		getJdbcTemplate().update(INSERT_QUERY,
				new Object[] { employee.getId(), employee.getName(), employee.getSalary() });
	}

	private static final class EmployeeMapper implements RowMapper<Employee> {

		@Override
		public Employee mapRow(ResultSet resultSet, int rowNum) throws SQLException {
			Employee employee = new Employee();
			employee.setId(resultSet.getInt(1));
			employee.setName(resultSet.getString(2));
			employee.setSalary(resultSet.getInt(3));
			return employee;
		}

	}

}
