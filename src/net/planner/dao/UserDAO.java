package net.planner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.planner.model.DB;
import net.planner.model.User;

public class UserDAO {
	private static DB myDB;
	private static Connection connection;
	
	public UserDAO(String jdbcURL, String jdbcUsername, String jdbcPassword)
	{
		myDB = new DB(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	public User verificarLogin (String username, String password)throws SQLException
	{
		String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
		myDB.conectar();
		connection = myDB.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, username);
		statement.setString(2, password);
		ResultSet result = statement.executeQuery();
		
		User user = null;
		if(result.next())
		{
			user = new User();
			user.setUsername(result.getString("username"));
			user.setFirst_name(result.getString("first_name"));
			user.setLast_name(result.getString("last_name"));
			user.setEmail(result.getString("email"));
		}
		statement.close();
		myDB.desconectar();
		return user;
	}
}
