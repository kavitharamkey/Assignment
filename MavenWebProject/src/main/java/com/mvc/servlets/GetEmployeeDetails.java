package com.mvc.servlets;


import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.mvc.employeeDetails.EmployeeBean;
import com.mvc.employeeDetails.EmployeeDAO;



/**
 * Servlet implementation class getEmployeeDetails
 */
@WebServlet(description = "contacts a DAO to get the employee details and passes it onto thin client", urlPatterns = { "/GetEmployeeDetails" })
public class GetEmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//private static Logger log = Logger.getLogger(getEmployeeDetails.class);
	private static Connection con = null;
	private static Logger log = Logger.getLogger(GetEmployeeDetails.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetEmployeeDetails() {
        super();
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		log.info(log.getClass().toString());
		HttpSession session = request.getSession(true);
		con = (Connection)session.getAttribute("dbcon");
		int location_id = Integer.parseInt(request.getParameter("location_id"));
		log.debug("In GetEmployeeDetails servlet, location_id = " + location_id);
		
		EmployeeDAO empdao = new EmployeeDAO(con,location_id);
		List<EmployeeBean> empList = empdao.empList;

		//log.info("Servlet has got the employee List "+ empList.size());
		if (empList != null){
			request.setAttribute("empList", empList);
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeDetails.jsp");
			rd.forward(request, response);
        
        }else{
        	//RequestDispatcher rd = request.getRequestDispatcher("DataError.jsp");
			//rd.forward(request, response);
        	response.sendRedirect("DataError.jsp");
        }
	}
	/*public void destroy(){
		log.debug("In GetEmployeeDetailsServlet:destroy()");
		if (con != null){
			log.debug(":: closing DB Connection");
			DBConnection.closeConnection(con);
		}
	}*/

}
