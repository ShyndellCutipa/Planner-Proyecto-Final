package net.planner.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.planner.dao.FavoriteDAO;
import net.planner.dao.ImportantDateDAO;
import net.planner.dao.TaskDAO;
import net.planner.model.ImportantDate;
import net.planner.model.StatisticsFav;
import net.planner.model.StatisticsID;
import net.planner.model.StatisticsTask;
import net.planner.model.Task;

/**
 * Servlet implementation class AdminInicio
 */
@WebServlet("/inicio")
public class AdminInicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ImportantDateDAO importantDateDAO;
    TaskDAO taskDAO;
    FavoriteDAO favoriteDAO;
    
    public void init() {
    	// Rescatando parámetros definidos en web.xml
    	String jdbcURL = getServletContext().getInitParameter("jdbcURL");
    	String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
    	String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
    	try {
    		importantDateDAO = new ImportantDateDAO(jdbcURL, jdbcUsername, jdbcPassword);
    		taskDAO = new TaskDAO(jdbcURL, jdbcUsername, jdbcPassword);
    		favoriteDAO = new FavoriteDAO(jdbcURL, jdbcUsername, jdbcPassword);
    	}
    	catch (Exception e) {
    		
    	}
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminInicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Próxima Fecha Importante
		ImportantDate fecha_importante = null;
		Task tarea = null;
		try {
			fecha_importante = ImportantDateDAO.fechaProxima();
			tarea = TaskDAO.tareaProxima();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(fecha_importante.getTitle());
		//System.out.println(tarea.getTitle());
		request.setAttribute("next_fechaimportante", fecha_importante);
		request.setAttribute("next_tarea", tarea);
		
		
		// Estadisticas 
		StatisticsID statisticID = null;
		StatisticsTask statisticTask = null;
		StatisticsFav statisticFav = null;
		try {
			statisticID = ImportantDateDAO.estadisticas();
			statisticTask = TaskDAO.estadisticas();
			statisticFav = FavoriteDAO.estadisticas();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("estadisticaID", statisticID);
		request.setAttribute("estadisticaTask", statisticTask);
		request.setAttribute("estadisticaFav", statisticFav);
		
		
		request.getRequestDispatcher("index.jsp")
				.forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
