package net.planner.model;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class DB {
	// Identificadores de control de acceso
	private Connection jdbcConnection;
	private String jdbcURL;
	private String jdbcUsername;
	private String jdbcPassword;
	
	// Parameter constructor
	public DB(String jdbcURL, String jdbcUsername, String jdbcPassword){
		this.jdbcURL = jdbcURL;
		this.jdbcUsername = jdbcUsername;
		this.jdbcPassword = jdbcPassword;
	}
	
	// Realiza la conexión con los parámetros
	public void conectar() throws SQLException{
		if(jdbcConnection == null || jdbcConnection.isClosed()) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} 
			catch (ClassNotFoundException e) {
				throw new SQLException(e);
			}
			jdbcConnection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		}
	}
	
	// Verifica que haya una conexión activa para poder desconectarla
	public void desconectar() throws SQLException {
		if(jdbcConnection != null && !jdbcConnection.isClosed()) {
			jdbcConnection.close();
		}
	}
	
	public Connection getJdbcConnection() {
		return jdbcConnection;
	}

}
