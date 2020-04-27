package ua.nure.kosten.FinalTask.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.kosten.FinalTask.web.Path;

public class CommandGoToPageRegistration extends Command {

	/**
	 * CommandGoToPageRegistration command.
	 * This command redirects to the user registration page.
	 * @author t.Kosten
	 * 
	 */
	
	private static final long serialVersionUID = 122342L;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String forward = Path.PAGE_REGIST;
		HttpSession session = request.getSession();
		session.setAttribute("lastForward", forward);
		return forward;
	}

}
