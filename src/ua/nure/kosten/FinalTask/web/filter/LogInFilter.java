package ua.nure.kosten.FinalTask.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.nure.kosten.FinalTask.db.entity.User;
import ua.nure.kosten.FinalTask.web.Path;

/**
 * The filter redirects the user to the main menu if he is already authorized
 * 
 * @author T.Kosten
 * 
 */
@WebFilter("/LogInFilter")
public class LogInFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		String forward="";
		if(session.getAttribute("user")!=null) {
			User user = (User) session.getAttribute("user");
			if ("user".equals(user.getRole())) {
				forward = Path.PAGE_HELLO_USER;
			} else {
				forward = Path.PAGE_HELLO_ADM;
			}
			request.getRequestDispatcher(forward).forward(request, response);

		} else {
			chain.doFilter(request, response);	
		}
	}
}
