package net.planner.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.planner.dao.ImportantDateDAO;
import net.planner.model.ImportantDate;

/**
 * Servlet implementation class AdminImportantDate
 */
@WebServlet("/AdminImportantDate")
public class AdminImportantDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ImportantDateDAO importantDateDAO;
    
    public void init() {
    	// Rescatando parámetros definidos en web.xml
    	String jdbcURL = getServletContext().getInitParameter("jdbcURL");
    	String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
    	String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
    	try {
    		importantDateDAO = new ImportantDateDAO(jdbcURL, jdbcUsername, jdbcPassword);
    	}
    	catch (Exception e) {
    		
    	}
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminImportantDate() {
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
			System.out.println("Sí inició sesión");
	
			System.out.println("Aquí está mi servlet adminid");
			String action = request.getParameter("action");
			System.out.println(action);
			try {
				switch(action) {
				case "index":
					index(request, response);
					break;
				case "mostrar":
					mostrar(request, response);
					break;
				case "eliminar":
					eliminar(request, response);
					break;
				case "nuevo":
					nuevo(request, response);
					break;
				case "crear":
					crear(request, response);
					break;
				case "editar":
					editar(request, response);
					break;
				case "actualizar":
					actualizar(request, response);
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ImpDates/mostrar.jsp");
		List<ImportantDate> listImportantDates = ImportantDateDAO.listImportantDates();
		request.setAttribute("listID", listImportantDates);
		dispatcher.forward(request, response);
	}
	private void eliminar (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		ImportantDate fecha_importante = ImportantDateDAO.getByID(Integer.parseInt(request.getParameter("id_date")));
		ImportantDateDAO.eliminar(fecha_importante);
		mostrar(request,response);
		/*RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);*/
	}
	
	
	private void nuevo (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ImpDates/crear.jsp");
		dispatcher.forward(request, response);
	}
	
	private void crear (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		
		ImportantDate fecha_importante = new ImportantDate(0, request.getParameter("title"), Date.valueOf(request.getParameter("due_date")), request.getParameter("priority")); 
		ImportantDateDAO.Insertar(fecha_importante);

		mostrar(request,response);
	}
	
	private void editar (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		ImportantDate fecha_importante = ImportantDateDAO.getByID(Integer.parseInt(request.getParameter("id_date"))); 
		request.setAttribute("fecha_importante", fecha_importante);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ImpDates/editar.jsp");
		dispatcher.forward(request,response);
	}
	private void actualizar (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		ImportantDate fecha_importante = new ImportantDate(Integer.parseInt(request.getParameter("id_date")), request.getParameter("title"), Date.valueOf(request.getParameter("due_date")), request.getParameter("priority"));
		ImportantDateDAO.actualizar(fecha_importante);
		mostrar(request,response);
	}
	
	private void filtrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		String month = request.getParameter("month");
		String prioridad = request.getParameter("priority");
		
		List<ImportantDate> listImportantDates = ImportantDateDAO.listImportantDatesFilter(month, prioridad);
		request.setAttribute("listID", listImportantDates);
		request.setAttribute("prioridad", prioridad);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ImpDates/mostrar.jsp");
		dispatcher.forward(request, response);
	}
}