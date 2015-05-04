package com.mvc.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.mvc.employeeDetails.GetLocationDAO;
import com.mvc.employeeDetails.LocationBean;



/**
 * Servlet implementation class controllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection con = null;
	private static Logger log = Logger.getLogger(ControllerServlet.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		log.info(log.getClass().toString());
		int location_id =0;
		log.debug(request.toString());
		Enumeration<String> e = request.getParameterNames();
		while (e.hasMoreElements()) {
				String name = (String) e.nextElement();
				log.debug("Elements in my Enumeration : "+name + "= " +request.getParameter(name));
				if(name.equals("location_id"))
				{
					log.debug("location_id is true: "+name + "= " +request.getParameter(name));
					location_id= Integer.parseInt(request.getParameter(name));
				}
		}
		
		log.debug("location_id:"+location_id);
		if (location_id==0)
		{
			con = (Connection)session.getAttribute("dbcon");
			GetLocationDAO getLocationDAO = new GetLocationDAO(con);
			List<LocationBean> locList = getLocationDAO.locationList;
			log.debug("In Controller Servlet, locList:\n"+locList);
			request.setAttribute("locList", locList);
			//response.sendRedirect("getBranchLocations.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("getBranchLocations.jsp");
			rd.forward(request, response);
		}
		else 
		{
			log.info("forwarding to employee_details page");
			RequestDispatcher rd = request.getRequestDispatcher("/GetEmployeeDetails");
			rd.forward(request, response);
		}
		
		
	}
	
/*	public void destroy(){
		log.debug("In ControllerServlet:destroy()");
		if (con != null){
			log.debug(":: closing DB Connection");
			DBConnection.closeConnection(con);
		}
	}
*/
}
