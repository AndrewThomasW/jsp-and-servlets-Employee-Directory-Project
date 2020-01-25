package andrew.thomas.dao;

import andrew.thomas.entity.Login;

public interface LoginDao {
	//authenticate
	boolean authenticate(Login log);
}
