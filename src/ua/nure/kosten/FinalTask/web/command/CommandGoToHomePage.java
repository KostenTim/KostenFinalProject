package ua.nure.kosten.FinalTask.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.kosten.FinalTask.db.entity.User;
import ua.nure.kosten.FinalTask.web.Path;

public class CommandGoToHomePage extends Command {

	/**
	 * CommandGoToHomePage command.
	 * This command redirects to the main page.
	 * @author t.Kosten
	 * 
	 */
	
	private static final long serialVersionUID = 123234L;
	
	private static final Logger LOG = Logger.getLogger(CommandGoToHomePage.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null){
			return Path.PAGE_INDEX;
		}
		String forward = "";
		User user = (User) session.getAttribute("user");
		if ("user".equals(user.getRole())) {
			forward = Path.PAGE_HELLO_USER;
		} else {
			forward = Path.PAGE_HELLO_ADM;
		}
		session.setAttribute("lastForward", forward);
		return forward;
	}

}
