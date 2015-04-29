package filters;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter(filterName="LoginFilter" , urlPatterns={"/LoginServlet"})
public class LoginFilter implements Filter {
	private static Logger log = Logger.getLogger(LoginFilter.class);
    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		log.info(log.getClass().toString());
		String ipAddress = request.getRemoteAddr();
		
		log.info("IP "+ ipAddress + ", Time " + new Date().toString());
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();
		log.info("URI Name ="+ uri);
		String login = req.getParameter("login");
		String passwd = req.getParameter("passwd");
		log.debug(" "+(login)+"||"+(passwd)+"||"+(!(login.equalsIgnoreCase("HR") && passwd.equalsIgnoreCase("hr"))));
		log.debug("Authorized User? "+(login.equalsIgnoreCase("HR") && passwd.equalsIgnoreCase("hr")));
		
		if(login.equalsIgnoreCase("HR") && passwd.equalsIgnoreCase("hr")){
			// pass the request along the filter chain
			//request.setAttribute("login", login);
			//request.setAttribute("passwd", passwd);
			chain.doFilter(request, response);
			
		}else {
			res.sendRedirect("UnAuthorized.html");
		}

	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
