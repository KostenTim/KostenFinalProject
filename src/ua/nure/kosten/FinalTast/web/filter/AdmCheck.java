package ua.nure.kosten.FinalTast.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.nure.kosten.FinalTast.db.entity.User;


@WebFilter("/AdmCheck")
public class AdmCheck implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		System.out.println("ADMfiltr");
		String forward = "";
		if (session.getAttribute("user")== null) {
			forward = "error.jsp";
			request.getRequestDispatcher(forward).forward(request, response);
		} else {
			User user = (User) session.getAttribute("user");
			if ("adm".equals(user.getRole())) {
				chain.doFilter(request, response);
			} else {
				forward = "error.jsp";
				request.getRequestDispatcher(forward).forward(request, response);
			}
		}
		
		
	}

}
