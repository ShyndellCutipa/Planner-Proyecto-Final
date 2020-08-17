package net.planner.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.planner.model.DB;
import net.planner.model.ImportantDate;
import net.planner.model.StatisticsID;

public class ImportantDateDAO {
	private static DB myDB;
	private static Connection connection;
	
	// Parameter Constructor creating new connection with class Conexion
	public ImportantDateDAO (String jdbcURL, String jdbcUsername, String jdbcPassword){
		myDB = new DB(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	public static List<ImportantDate> listImportantDates() throws SQLException{
		List<ImportantDate> listImportantDates = new ArrayList<ImportantDate>();
		String sql = "SELECT * FROM importantdates";
		// Conectando con la base de datos
		myDB.conectar();
		// Retorna la variable conexi�n
		connection = myDB.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resultados = statement.executeQuery(sql);
		
		while(resultados.next()) {
			int id_date = resultados.getInt("id_date");
			String title = resultados.getString("title");
			Date due_date = resultados.getDate("due_date");
			String priority = resultados.getString("priority");
			ImportantDate fecha_importante = new ImportantDate(id_date, title, due_date, priority);
			listImportantDates.add(fecha_importante);
		}
		myDB.desconectar();
		return listImportantDates;
	}
	
	public static List<ImportantDate> listImportantDatesFilter(String month, String prioridad) throws SQLException{
		List<ImportantDate> listImportantDates = new ArrayList<ImportantDate>();
		// Conectando con la base de datos
		myDB.conectar();
		// Retorna la variable conexi�n
		connection = myDB.getJdbcConnection();

		
		String sql = "SELECT * FROM importantdates WHERE due_date LIKE ? AND priority LIKE ? ORDER BY due_date asc ";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, '%' + month + '%');
		if(prioridad.equals("Todos"))
			statement.setString(2, "%");
		else
			statement.setString(2, '%' + prioridad + '%');
		

		ResultSet resultados = statement.executeQuery();
		// System.out.println("Statement executed");
		
		while(resultados.next()) {
			int id_date = resultados.getInt("id_date");
			String title = resultados.getString("title");
			Date due_date = resultados.getDate("due_date");
			String priority = resultados.getString("priority");
			ImportantDate fecha_importante = new ImportantDate(id_date, title, due_date, priority);
			listImportantDates.add(fecha_importante);
		}
			

		myDB.desconectar();
		return listImportantDates;
	}
	
	public static boolean Insertar(ImportantDate fecha_importante) throws SQLException {
		String sql = "INSERT INTO importantdates(id_date, title, due_date, priority) VALUES (?,?,?,?)";
		myDB.conectar();
		connection = myDB.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, null);
		statement.setString(2, fecha_importante.getTitle());
		statement.setDate(3, fecha_importante.getDue_date());
		statement.setString(4, fecha_importante.getPriority());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		myDB.desconectar();
		return rowInserted;
		
	}
	
	public static ImportantDate getByID(int id_date) throws SQLException{
		ImportantDate fecha_importante = null;
		
		String sql = "SELECT * FROM importantdates WHERE id_date=?";
		myDB.conectar();
		connection = myDB.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id_date);
		
		ResultSet resultados = statement.executeQuery();
		if(resultados.next()) {
			fecha_importante = new ImportantDate(resultados.getInt("id_date"),resultados.getString("title"), resultados.getDate("due_date"), resultados.getString("priority"));
		}
		resultados.close();
		myDB.desconectar();
		return fecha_importante;
	}
	
	public static boolean actualizar(ImportantDate fecha_importante) throws SQLException {
		String sql = "UPDATE importantdates SET title=?, due_date=?, priority=? WHERE id_date=?";
		myDB.conectar();
		connection = myDB.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, fecha_importante.getTitle());
		statement.setDate(2, fecha_importante.getDue_date());
		statement.setString(3, fecha_importante.getPriority());
		statement.setInt(4, fecha_importante.getId_date());
		
		boolean rowUpdate = statement.executeUpdate() > 0;
		statement.close();
		myDB.desconectar();
		return rowUpdate;
		
	}
	
	public static boolean eliminar(ImportantDate fecha_importante) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM importantdates WHERE id_date=?";
		myDB.conectar();
		connection = myDB.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, fecha_importante.getId_date());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		myDB.desconectar();

		return rowEliminar;
	}
	
	public static ImportantDate fechaProxima() throws SQLException {
		ImportantDate fecha_importante = null;
		String sql = "SELECT * FROM importantdates WHERE due_date >= current_date() order by due_date asc limit 1";
		myDB.conectar();
		connection = myDB.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		if (resultados.next())
		{
			fecha_importante = new ImportantDate(resultados.getInt("id_date"),resultados.getString("title"), resultados.getDate("due_date"), resultados.getString("priority"));
		}
		
		resultados.close();
		myDB.desconectar();
		return fecha_importante;
	}
	public static StatisticsID estadisticas() throws SQLException{
		StatisticsID statisticsID = new StatisticsID (0, 0, 0);
		String sql = "SELECT COUNT(*) FROM importantdates WHERE due_date >= current_date() AND priority = 'Alto'";
		myDB.conectar();
		connection = myDB.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		resultados.next();
		statisticsID.setCantidadIdAlto(resultados.getInt(1));
		
		sql = "SELECT COUNT(*) FROM importantdates WHERE due_date >= current_date() AND priority = 'Medio'";
		statement = connection.prepareStatement(sql);
		resultados = statement.executeQuery();
		resultados.next();
		statisticsID.setCantidadIdMedio(resultados.getInt(1));
		
		sql = "SELECT COUNT(*) FROM importantdates WHERE due_date >= current_date() AND priority = 'Bajo'";
		statement = connection.prepareStatement(sql);
		resultados = statement.executeQuery();
		resultados.next();
		statisticsID.setCantidadIdBajo(resultados.getInt(1));
		
		System.out.println(statisticsID.getCantidadIdAlto());
		System.out.println(statisticsID.getCantidadIdMedio());
		System.out.println(statisticsID.getCantidadIdBajo());
		
		resultados.close();
		myDB.desconectar();
		return statisticsID;
	}

}
