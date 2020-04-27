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
import ua.nure.kosten.FinalTast.resources.Text;

@WebFilter("/LengFilter")
public class LengFilter implements Filter {


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		if (session.getAttribute("text") == null) {
			Text text = new Text("eng");
			session.setAttribute("text", text);
		}
		if (session.getAttribute("lastForward") == null) {
			String forward = "index.jsp";
			session.setAttribute("lastForward", forward);
		}
		chain.doFilter(request, response);	

	}




}
