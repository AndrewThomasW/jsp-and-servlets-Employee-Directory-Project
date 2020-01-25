package andrew.thomas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import andrew.thomas.entity.Employee;
import andrew.thomas.util.DBConnectionUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement preparedStatement = null;

	@Override
	public List<Employee> getEmployees() {

		List<Employee> employeeList = null;

		try {
			// list of Employees
			employeeList = new LinkedList<>();
			// get all Employees Query
			String sql = "SELECT * FROM tbl_employee";

			// get connection
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			// loop result set make employee list
			while (resultSet.next()) {

				Employee employee = new Employee();

				employee.setId(resultSet.getInt("id"));
				employee.setName(resultSet.getString("name"));
				employee.setDob(resultSet.getString("dob"));
				employee.setDepartment(resultSet.getString("department"));

				employeeList.add(employee);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employeeList;
//		return Arrays.asList(new Employee(1, "Andrew", "12/21/1991", "SD"),
//				new Employee(2, "Jim", "12/21/1993", "Marketing"));
	}

	@Override
	public boolean addEmployee(Employee e) {
		boolean flag = false;

		try {

			String sql = " INSERT INTO tbl_employee(name,dob,department) " + "VALUES(' " + e.getName() + " ', ' "
					+ e.getDob() + " ', ' " + e.getDepartment() + " ' )";

			connection = DBConnectionUtil.openConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.executeUpdate();

			flag = true;

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return flag;
	}

	public Employee getEmployee(int id) {

		String sql = " SELECT *  FROM tbl_employee tb" + " WHERE tb.id = " + id;
		Employee e = null;

		try {
			// get connection
			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			// loop through result set
			while (resultSet.next()) {

				e = new Employee();

				e.setId(resultSet.getInt("id"));
				e.setName(resultSet.getString("name"));
				e.setDob(resultSet.getString("dob"));
				e.setDepartment(resultSet.getString("department"));

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return e;
	}

	public boolean updateEmployee(Employee e) {
		
		boolean flag = false;

		try {
			
			String sql = "UPDATE tbl_employee SET name =   '     "+ e.getName() + "     ' ,"
					+ " dob =   '     " + e.getDob() +"    '  ,"
					+ "department =   '     " +e.getDepartment() +"     '"
					+ " WHERE id = '     " +e.getId() +"         ';";
			
			connection = DBConnectionUtil.openConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.executeUpdate();

			flag = true;
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

		return flag;
	}
	
	public boolean deleteEmployee(Employee e) {
		boolean flag = false;
	
		try {
			String sql = "DELETE FROM tbl_employee WHERE id =    " +  e.getId() + " ;";
			
			connection = DBConnectionUtil.openConnection();
			preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
			preparedStatement.executeUpdate();
			
			flag = true;
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		return flag;
	}
}




















