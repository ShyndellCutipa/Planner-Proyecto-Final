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

import net.planner.dao.TaskDAO;
import net.planner.model.Task;

/**
 * Servlet implementation class AdminTask
 */
@WebServlet("/AdminTask")
public class AdminTask extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TaskDAO taskDAO;
	public void init() {
    	// Rescatando parámetros definidos en web.xml
    	String jdbcURL = getServletContext().getInitParameter("jdbcURL");
    	String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
    	String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
    	try {
    		taskDAO = new TaskDAO(jdbcURL, jdbcUsername, jdbcPassword);
    	}
    	catch (Exception e) {
    		
    	}
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTask() {
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Tasks/mostrar.jsp");
		List<Task> listTasks = TaskDAO.listTasks();
		request.setAttribute("listTasks", listTasks);
		dispatcher.forward(request, response);
	}
	private void eliminar (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Task tarea = TaskDAO.getByID(Integer.parseInt(request.getParameter("id_task")));
		TaskDAO.eliminar(tarea);
		mostrar(request,response);
		/*RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);*/
	}
	private void nuevo (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Tasks/crear.jsp");
		dispatcher.forward(request, response);
	}
	
	private void crear (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		
		Task tarea = new Task(0, request.getParameter("title"), request.getParameter("description"), Date.valueOf(request.getParameter("due_date")), request.getParameter("priority")); 
		TaskDAO.Insertar(tarea);

		mostrar(request,response);
	}
	
	private void editar (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Task tarea = TaskDAO.getByID(Integer.parseInt(request.getParameter("id_task"))); 
		request.setAttribute("tarea", tarea);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Tasks/editar.jsp");
		dispatcher.forward(request,response);
	}
	
	private void actualizar (HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		Task tarea = new Task(Integer.parseInt(request.getParameter("id_task")),  request.getParameter("title"), request.getParameter("description"), Date.valueOf(request.getParameter("due_date")), request.getParameter("priority")); 
		TaskDAO.actualizar(tarea);
		mostrar(request,response);
	}
	
	private void filtrar(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		String prioridad = request.getParameter("priority");
		
		List<Task> listTasks = TaskDAO.listTasksFilter(prioridad);
		request.setAttribute("listTasks", listTasks);
		request.setAttribute("prioridad", prioridad);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Tasks/mostrar.jsp");
		dispatcher.forward(request, response);
	}

}
