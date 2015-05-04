package com.mvc.servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.mvc.employeeDetails.DBConnection;






/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(name="LoginServlet" , urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection con = null;
	private static Logger log = Logger.getLogger(LoginServlet.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(true);
		session.setMaxInactiveInterval(60); 
		
		if (!(session.isNew()))
		{
			log.debug(session.getId()+" must be a cached session_id, so i am invalidating and creating a new session");
			session.invalidate();
			if (con != null)
				DBConnection.closeConnection(con);
		}

			String dblogin = (String) request.getParameter("login");
			String dbpasswd = (String) request.getParameter("passwd");
			log.debug("In login Servlet ,login credentials: ("+dblogin+"/"+dbpasswd+")");
			try {
				con = DBConnection.getConnection(dblogin, dbpasswd);
				session.setAttribute("dbcon", con);
			}catch(Exception exp){
				exp.printStackTrace();
				//send a message to servlet
			}
			log.debug("This is a new session: "+session.getId());
			RequestDispatcher rd = request.getRequestDispatcher("/ControllerServlet");
			rd.forward(request, response);
			
	}

}
