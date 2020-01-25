package andrew.thomas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import andrew.thomas.entity.Login;
import andrew.thomas.util.DBConnectionUtil;

public class LoginDaoImpl implements LoginDao {

	// declare db connection fields
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;

	public boolean authenticate(Login log) {
		boolean flag = false;
		

		try {

			String sql = " SELECT * FROM tbl_login  WHERE email =  '" + log.getEmail() + "'  AND password = '" +  log.getPassword()+ "' ;";

			connection = DBConnectionUtil.openConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			
			if(resultSet.next()) {
				flag = true;
			} else {
				flag = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return flag;
	}
}
