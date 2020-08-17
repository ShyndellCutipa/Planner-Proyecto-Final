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
import net.planner.model.StatisticsTask;
import net.planner.model.Task;

public class TaskDAO {
	private static DB myDB;
	private static Connection connection;
	
	// Parameter Constructor creating new connection with class Conexion
	public TaskDAO(String jdbcURL, String jdbcUsername, String jdbcPassword){
		myDB = new DB(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	public static List<Task> listTasks() throws SQLException{
		List<Task> listTasks = new ArrayList<Task>();
		String sql = "SELECT * FROM task ORDER BY due_date asc";
		// Conectando con la base de datos
		myDB.conectar();
		// Retorna la variable conexi�n
		connection = myDB.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resultados = statement.executeQuery(sql);
		
		while(resultados.next()) {
			int id_task = resultados.getInt("id_task");
			String title = resultados.getString("title");
			String description = resultados.getString("description");
			Date due_date = resultados.getDate("due_date");
			String priority = resultados.getString("priority");
			Task tarea = new Task(id_task, title, description, due_date, priority);
			listTasks.add(tarea);
		}
		myDB.desconectar();
		return listTasks;
	}
	
	public static List<Task> listTasksFilter(String prioridad) throws SQLException{
		List<Task> listTasks = new ArrayList<Task>();
		// Conectando con la base de datos
		myDB.conectar();
		// Retorna la variable conexi�n
		connection = myDB.getJdbcConnection();

		
		String sql = "SELECT * FROM task WHERE priority LIKE ? ORDER BY due_date asc ";
		PreparedStatement statement = connection.prepareStatement(sql);
		if(prioridad.equals("Todos"))
			statement.setString(1, "%");
		else
			statement.setString(1, '%' + prioridad + '%');
		

		ResultSet resultados = statement.executeQuery();
		 System.out.println("Statement executed");
		
		while(resultados.next()) {
			int id_task = resultados.getInt("id_task");
			String title = resultados.getString("title");
			System.out.println("title");
			String description = resultados.getString("description");
			Date due_date = resultados.getDate("due_date");
			String priority = resultados.getString("priority");
			Task tarea = new Task(id_task, title, description, due_date, priority);
			listTasks.add(tarea);
		}
			

		myDB.desconectar();
		return listTasks;
	}
	
	
	public static boolean Insertar(Task tarea) throws SQLException {
		String sql = "INSERT INTO task(id_task, title, description, due_date, priority) VALUES (?,?,?,?,?)";
		myDB.conectar();
		connection = myDB.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, null);
		statement.setString(2, tarea.getTitle());
		statement.setString(3, tarea.getDescription());
		statement.setDate(4, tarea.getDue_date());
		statement.setString(5, tarea.getPriority());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		myDB.desconectar();
		return rowInserted;
		
	}
	
	public static Task getByID(int id_task) throws SQLException{
		Task tarea = null;
		
		String sql = "SELECT * FROM task WHERE id_task=?";
		myDB.conectar();
		connection = myDB.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id_task);
		
		ResultSet resultados = statement.executeQuery();
		if(resultados.next()) {
			tarea = new Task(resultados.getInt("id_task"),resultados.getString("title"), resultados.getString("description"), resultados.getDate("due_date"), resultados.getString("priority"));
		}
		resultados.close();
		myDB.desconectar();
		return tarea;
	}
	
	public static boolean actualizar(Task tarea) throws SQLException {
		String sql = "UPDATE task SET title=?, description=?, due_date=?, priority=? WHERE id_task=?";
		myDB.conectar();
		connection = myDB.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, tarea.getTitle());
		statement.setString(2, tarea.getDescription());
		statement.setDate(3, tarea.getDue_date());
		statement.setString(4, tarea.getPriority());
		statement.setInt(5, tarea.getId_task());
		
		boolean rowUpdate = statement.executeUpdate() > 0;
		statement.close();
		myDB.desconectar();
		return rowUpdate;
		
	}
	
	public static boolean eliminar(Task tarea) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM task WHERE id_task=?";
		myDB.conectar();
		connection = myDB.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, tarea.getId_task());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		myDB.desconectar();

		return rowEliminar;
	}
	
	public static Task tareaProxima() throws SQLException {
		Task tarea = null;
		String sql = "SELECT * FROM task WHERE due_date >= current_date() order by due_date asc limit 1";
		myDB.conectar();
		connection = myDB.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		if (resultados.next())
		{
			tarea = new Task(resultados.getInt("id_task"),resultados.getString("title"), resultados.getString("description"), resultados.getDate("due_date"), resultados.getString("priority"));
		}
		
		resultados.close();
		myDB.desconectar();
		return tarea;
	}
	public static StatisticsTask estadisticas() throws SQLException{
		StatisticsTask statisticsTask = new StatisticsTask (0, 0, 0);
		String sql = "SELECT COUNT(*) FROM task WHERE due_date >= current_date() AND priority = 'Alto'";
		myDB.conectar();
		connection = myDB.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		resultados.next();
		statisticsTask.setCantidadTAlto(resultados.getInt(1));
		
		sql = "SELECT COUNT(*) FROM task WHERE due_date >= current_date() AND priority = 'Medio'";
		statement = connection.prepareStatement(sql);
		resultados = statement.executeQuery();
		resultados.next();
		statisticsTask.setCantidadTMedio(resultados.getInt(1));
		
		sql = "SELECT COUNT(*) FROM task WHERE due_date >= current_date() AND priority = 'Bajo'";
		statement = connection.prepareStatement(sql);
		resultados = statement.executeQuery();
		resultados.next();
		statisticsTask.setCantidadTBajo(resultados.getInt(1));
		
		System.out.println(statisticsTask.getCantidadTAlto());
		System.out.println(statisticsTask.getCantidadTMedio());
		System.out.println(statisticsTask.getCantidadTBajo());
		
		resultados.close();
		myDB.desconectar();
		return statisticsTask;
	}
}
