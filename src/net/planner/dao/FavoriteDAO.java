package net.planner.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import net.planner.model.DB;
import net.planner.model.Favorite;
import net.planner.model.StatisticsFav;


public class FavoriteDAO {
	private static DB myDB;
	private static Connection connection;
	
	// Parameter Constructor creating new connection with class DB
	public FavoriteDAO(String jdbcURL, String jdbcUsername, String jdbcPassword){
		myDB = new DB(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	public static List<Favorite> listFavorites() throws SQLException{
		List<Favorite> listFavorites = new ArrayList<Favorite>();
		String sql = "SELECT * FROM favorites";
		// Conectando con la base de datos
		myDB.conectar();
		// Retorna la variable conexi�n
		connection = myDB.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resultados = statement.executeQuery(sql);
		
		while(resultados.next()) {
			int id_fav = resultados.getInt("id_fav");
			String category = resultados.getString("category");
			String name = resultados.getString("name");
			String reference = resultados.getString("reference");
			String comment = resultados.getString("comment");
			Favorite favorito = new Favorite(id_fav, category, name, reference, comment);
			listFavorites.add(favorito);
		}
		myDB.desconectar();
		return listFavorites;
	}
	
	public static List<Favorite> listFavoritesFilter(String categoria) throws SQLException{
		List<Favorite> listFavorites = new ArrayList<Favorite>();
		// Conectando con la base de datos
		myDB.conectar();
		// Retorna la variable conexi�n
		connection = myDB.getJdbcConnection();

		
		String sql = "SELECT * FROM favorites WHERE category LIKE ? ";
		PreparedStatement statement = connection.prepareStatement(sql);
		if(categoria.equals("Todos"))
			statement.setString(1, "%");
		else
			statement.setString(1, '%' + categoria + '%');
		

		ResultSet resultados = statement.executeQuery();
		//System.out.println("Statement executed");
		
		while(resultados.next()) {
			int id_fav = resultados.getInt("id_fav");
			String category = resultados.getString("category");
			String name = resultados.getString("name");
			String reference = resultados.getString("reference");
			String comment = resultados.getString("comment");
			Favorite favorito = new Favorite(id_fav, category, name, reference, comment);
			listFavorites.add(favorito);
		}

		myDB.desconectar();
		return listFavorites;
	}
	
	
	public static boolean Insertar(Favorite favorito) throws SQLException {
		String sql = "INSERT INTO favorites(id_fav, category, name, reference, comment) VALUES (?,?,?,?,?)";
		myDB.conectar();
		connection = myDB.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, null);
		statement.setString(2, favorito.getCategory());
		statement.setString(3, favorito.getName());
		statement.setString(4, favorito.getReference());
		statement.setString(5, favorito.getComment());
		
		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		myDB.desconectar();
		return rowInserted;
		
	}
	public static Favorite getByID(int id_fav) throws SQLException{
		Favorite favorito = null;
		
		String sql = "SELECT * FROM favorites WHERE id_fav=?";
		myDB.conectar();
		connection = myDB.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id_fav);
		
		ResultSet resultados = statement.executeQuery();
		if(resultados.next()) {
			favorito = new Favorite(resultados.getInt("id_fav"),resultados.getString("category"),
					   resultados.getString("name"), resultados.getString("reference"), resultados.getString("comment"));
		}
		resultados.close();
		myDB.desconectar();
		return favorito;
	}
	
	public static boolean actualizar(Favorite favorito) throws SQLException {
		String sql = "UPDATE favorites SET category=?, name=?, reference=?, comment=? WHERE id_fav=?";
		myDB.conectar();
		connection = myDB.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, favorito.getCategory());
		statement.setString(2, favorito.getName());
		statement.setString(3, favorito.getReference());
		statement.setString(4, favorito.getComment());
		statement.setInt(5, favorito.getId_fav());
		
		boolean rowUpdate = statement.executeUpdate() > 0;
		statement.close();
		myDB.desconectar();
		return rowUpdate;
		
	}
	
	public static boolean eliminar(Favorite favorito) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM favorites WHERE id_fav=?";
		myDB.conectar();
		connection = myDB.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, favorito.getId_fav());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		myDB.desconectar();

		return rowEliminar;
	}
	public static StatisticsFav estadisticas() throws SQLException{
		StatisticsFav statisticsFav = new StatisticsFav (0 ,0 , 0, 0, 0, 0);
		String sql = "SELECT COUNT(*) FROM favorites WHERE category = 'Libro'";
		myDB.conectar();
		connection = myDB.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultados = statement.executeQuery();
		resultados.next();
		statisticsFav.setCantidadFLibro(resultados.getInt(1));
		
		sql = "SELECT COUNT(*) FROM favorites WHERE category = 'Pelicula'";
		statement = connection.prepareStatement(sql);
		resultados = statement.executeQuery();
		resultados.next();
		statisticsFav.setCantidadFPelicula(resultados.getInt(1));
		
		sql = "SELECT COUNT(*) FROM favorites WHERE category = 'Lugar'";
		statement = connection.prepareStatement(sql);
		resultados = statement.executeQuery();
		resultados.next();
		statisticsFav.setCantidadFLugar(resultados.getInt(1));
		
		sql = "SELECT COUNT(*) FROM favorites WHERE category = 'Restaurante'";
		statement = connection.prepareStatement(sql);
		resultados = statement.executeQuery();
		resultados.next();
		statisticsFav.setCantidadFRestaurante(resultados.getInt(1));
		
		sql = "SELECT COUNT(*) FROM favorites WHERE category = 'Serie'";
		statement = connection.prepareStatement(sql);
		resultados = statement.executeQuery();
		resultados.next();
		statisticsFav.setCantidadFSerie(resultados.getInt(1));
		sql = "SELECT COUNT(*) FROM favorites WHERE category = 'Ropa'";
		statement = connection.prepareStatement(sql);
		resultados = statement.executeQuery();
		resultados.next();
		statisticsFav.setCantidadFRopa(resultados.getInt(1));
		
		System.out.println(statisticsFav.getCantidadFLibro());
		System.out.println(statisticsFav.getCantidadFPelicula());
		System.out.println(statisticsFav.getCantidadFLugar());
		System.out.println(statisticsFav.getCantidadFRestaurante());
		System.out.println(statisticsFav.getCantidadFSerie());
		System.out.println(statisticsFav.getCantidadFRopa());
		
		resultados.close();
		myDB.desconectar();
		return statisticsFav;
	}

	
}

