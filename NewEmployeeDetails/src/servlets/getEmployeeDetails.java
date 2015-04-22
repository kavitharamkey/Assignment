package servlets;





import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import org.apache.log4j.Logger;

import employeeDetails.EmployeeBean;
import employeeDetails.EmployeeDAO;
import filters.LoginFilter;

/**
 * Servlet implementation class getEmployeeDetails
 */
@WebServlet(description = "contacts a DAO to get the employee details and passes it onto thin client", urlPatterns = { "/getEmployeeDetails" })
public class getEmployeeDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(getEmployeeDetails.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getEmployeeDetails() {
        super();
        
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		log.info(log.getClass().toString());
		PrintWriter out = response.getWriter();
		EmployeeDAO empdao = new EmployeeDAO();
		//EmployeeBean empbean = new EmployeeBean();
        List<EmployeeBean> empList = empdao.empList;

		log.info("Servlet has got the employee List "+ empList.size());
		if (empList != null){
        	out.println("<html><body>List of Employees who ears more than 4000 USD per month <BR><BR>");
        	out.println("<table><TR><th>EmpID</th><th>FirstName</th><th>LastName</th><th>Salary</th><th>DeptID</th></TR>");
        	for (EmployeeBean empbean : empList){
        		out.println("<TR>");
        		out.println("<TD>" + empbean.getEmpId() + "</TD>");
        		out.println("<TD>" + empbean.getFname() + "</TD>");
        		out.println("<TD>" + empbean.getLname() + "</TD>");
        		out.println("<TD>" + empbean.getSalary() + "</TD>");
        		out.println("<TD>" + empbean.getDeptId() + "</TD>");
        		out.println("</TR>");
        	}
        	out.println("</table> </body></html>");
        
        }else{
        	out.println("<html><body>list is not available now; please check back later </body></html>");
        }
	}

}
