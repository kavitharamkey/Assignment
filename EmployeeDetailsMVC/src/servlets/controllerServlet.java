package servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import employeeDetails.DBConnection;

/**
 * Servlet implementation class controllerServlet
 */
@WebServlet("/controllerServlet")
public class controllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Connection con = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controllerServlet() {
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		ServletContext context = getServletContext();
		session.setMaxInactiveInterval(60); 
		
		if (session.isNew()){

			String dblogin = (String) request.getAttribute("login");
			String dbpasswd = (String) request.getAttribute("passwd");
			System.out.println("("+dblogin+"/"+dbpasswd+")");
			try {
				con = DBConnection.getConnection(dblogin, dbpasswd);
			}catch(Exception exp){
				exp.printStackTrace();
				//send a message to servlet
			}
			session.setAttribute("dbcon", con);
		} else {
			
			con = (Connection)session.getAttribute("dbcon");
		}
		//int location_id = 
		RequestDispatcher rd = request.getRequestDispatcher("getBranchLocations.jsp");
		rd.forward(request, response);
		
	}

}
