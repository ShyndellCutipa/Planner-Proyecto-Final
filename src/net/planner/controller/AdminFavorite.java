package net.planner.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.planner.dao.FavoriteDAO;
import net.planner.model.Favorite;

/**
 * Servlet implementation class AdminFavorite
 */
@WebServlet("/AdminFavorite")
public class AdminFavorite extends HttpServlet {
	private static final long serialVersionUID = 1L;
	FavoriteDAO favoriteDAO;
	public void init() {
    	// Rescatando parámetros definidos en web.xml
    	String jdbcURL = getServletContext().getInitParameter("jdbcURL");
    	String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
    	String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
    	try {
    		favoriteDAO = new FavoriteDAO(jdbcURL, jdbcUsername, jdbcPassword);
    	}
    	catch (Exception e) {
    		
    	}
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminFavorite() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		boolean isLoggedIn = (session != null && session.getAttribute("user") != null);
		if (isLoggedIn)
		{
			System.out.println("Aquí está mi servlet adminfav");
			String action = request.getParameter("action");
			System.out.println(action);
			try {
				switch(action) {
				case "index":
					index(request,response);
					break;
				case "mostrar":
					mostrar(request, response);
					break;
				case "eliminar":
					eliminar(request, response);
					break;
				case "nuevo":
					nuevo(request,response);
					break;
				case "crear":
					crear(request, response);
					break;
				case "editar":
					editar(request, response);
					break;
				case "actualizar":
					actualizar(request,response);
					break;
				case "filtrar":
					filtrar(request, response);
					break;
				default:
					break;
				}
			}
			catch (SQLException e) {
				e.getStackTrace();
			}
		}
		else
		{
			System.out.println("No inició sesión");
			request.getRequestDispatcher("error.jsp")
					.forward(request, response);
		}
		
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void index (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}
	
	private void mostrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Favorites/mostrar.jsp");
		List<Favorite> listFavorites = FavoriteDAO.listFavorites();
		request.setAttribute("listFavs", listFavorites);
		
		dispatcher.forward(request, response);
	}
	private void eliminar (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Favorite favorito = FavoriteDAO.getByID(Integer.parseInt(request.getParameter("id_fav")));
		FavoriteDAO.eliminar(favorito);
		mostrar(request,response);
		/*RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);*/
	}
	
	private void nuevo (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Favorites/crear.jsp");
		dispatcher.forward(request, response);
	}
	
	private void crear (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		
		Favorite favorito = new Favorite(0, request.getParameter("category"), request.getParameter("name"), request.getParameter("reference"), request.getParameter("comment")); 
		FavoriteDAO.Insertar(favorito);

		mostrar(request,response);
	}
	
	private void editar (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Favorite favorito = FavoriteDAO.getByID(Integer.parseInt(request.getParameter("id_fav"))); 
		request.setAttribute("favorito", favorito);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Favorites/editar.jsp");
		dispatcher.forward(request,response);
	}
	
	private void actualizar (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Favorite favorito = new Favorite(Integer.parseInt(request.getParameter("id_fav")), request.getParameter("category"), request.getParameter("name"), request.getParameter("reference"), request.getParameter("comment")); 
		FavoriteDAO.actualizar(favorito);
		mostrar(request,response);
	}
	
	private void filtrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		String categoria = request.getParameter("category");
		
		List<Favorite> listFavorites = FavoriteDAO.listFavoritesFilter(categoria);
		request.setAttribute("listFavs", listFavorites);
		request.setAttribute("categoria", categoria);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Favorites/mostrar.jsp");
		dispatcher.forward(request, response);
	}
}
