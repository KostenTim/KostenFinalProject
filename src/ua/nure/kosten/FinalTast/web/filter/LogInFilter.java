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

@WebFilter("/LogInFilter")
public class LogInFilter implements Filter {

	public LogInFilter() {

	}

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		String forward="";
		if(session.getAttribute("user")!=null) {
			User user = (User) session.getAttribute("user");
			if ("user".equals(user.getRole())) {
				forward = "/WEB-INF/jsp/client/helloUser.jsp";
			} else {
				forward = "/WEB-INF/jsp/adm/helloAdm.jsp";
			}
			request.getRequestDispatcher(forward).forward(request, response);

		} else {
			chain.doFilter(request, response);	
		}



	}


	public void init(FilterConfig fConfig) throws ServletException {

	}

}
