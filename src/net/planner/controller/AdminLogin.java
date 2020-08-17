package net.planner.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.planner.dao.UserDAO;
import net.planner.model.User;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/login")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserDAO userDAO;
    
    public void init() {
    	// Rescatando parámetros definidos en web.xml
    	String jdbcURL = getServletContext().getInitParameter("jdbcURL");
    	String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
    	String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
    	try {
    		userDAO = new UserDAO(jdbcURL, jdbcUsername, jdbcPassword);
    	}
    	catch (Exception e) {
    		
    	}
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("Inicio/login.jsp")
		.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			User user = userDAO.verificarLogin(username, password);
			String destPage = "Inicio/login.jsp";
			if (user != null)
			{
				System.out.println("Sí existo, soy " +user.getFirst_name());
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				destPage = "inicio";
			}
			else
			{
				String message = "Contraseña o Usuario incorrecto";
				request.setAttribute("message", message);
				request.setAttribute("username", username);
				System.out.println("No existo");
			}
			request.getRequestDispatcher(destPage)
			.forward(request, response);
		} catch (SQLException  ex) {
            throw new ServletException(ex);
        }

		
	}

}
