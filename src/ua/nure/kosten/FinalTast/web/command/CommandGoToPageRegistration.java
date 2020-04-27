package ua.nure.kosten.FinalTast.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CommandGoToPageRegistration extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String forward = "regist.jsp";
		HttpSession session = request.getSession();
		session.setAttribute("lastForward", forward);
		return forward;
	}

}
