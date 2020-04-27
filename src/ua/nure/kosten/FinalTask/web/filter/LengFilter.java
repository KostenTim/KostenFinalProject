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

import ua.nure.kosten.FinalTask.resources.Text;
import ua.nure.kosten.FinalTask.web.Path;

/**
 * Filter an object into a user session to present text on a page.
 * 
 * @author T.Kosten
 * 
 */
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
			String forward = Path.PAGE_INDEX;
			session.setAttribute("lastForward", forward);
		}
		chain.doFilter(request, response);	

	}
}
