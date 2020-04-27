package ua.nure.kosten.FinalTask.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.kosten.FinalTask.db.DBManager;
import ua.nure.kosten.FinalTask.db.entity.User;
import ua.nure.kosten.FinalTask.web.Path;


public class CommandLogout extends Command {
	
	/**
	 * CommandLogout command.
	 * This command out of account.
	 * @author t.Kosten
	 * 
	 */
	
	private static final long serialVersionUID = 123242L;
	
	private static final Logger LOG = Logger.getLogger(CommandLogout.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		LOG.info(session.getAttribute("user") + " out from system");
		session.setAttribute("user", null);
		String forward = Path.PAGE_INDEX;
		session.setAttribute("lastForward", forward);
		return forward;

	}

}
