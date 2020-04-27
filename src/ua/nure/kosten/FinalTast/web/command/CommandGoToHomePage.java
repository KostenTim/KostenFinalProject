package ua.nure.kosten.FinalTast.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.kosten.FinalTast.db.entity.User;

public class CommandGoToHomePage extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		String forward = "";
		User user = (User) session.getAttribute("user");
		if ("user".equals(user.getRole())) {
			forward = "/WEB-INF/jsp/client/helloUser.jsp";
		} else {
			forward = "/WEB-INF/jsp/adm/helloAdm.jsp";
		}
		session.setAttribute("lastForward", forward);
		return forward;
	}

}
