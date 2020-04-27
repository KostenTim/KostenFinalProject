package ua.nure.kosten.FinalTask.web.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.kosten.FinalTask.db.DBManager;
import ua.nure.kosten.FinalTask.db.entity.User;
import ua.nure.kosten.FinalTask.web.Path;

public class CommandShowAllUsers extends Command {


	/**
	 * CommandShowAllUsers command.
	 * This command provides a list of all users registered in the system.
	 * @author t.Kosten
	 * 
	 */
	
	private static final long serialVersionUID = 1232342L;
	
	private static final Logger LOG = Logger.getLogger(CommandLogin.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String forward = Path.PAGE_SHOW_USERS;
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null||!"adm".equals(((User) session.getAttribute("user")).getRole()) ){
			return Path.PAGE_INDEX;
		}
		List<User> userlist = DBManager.getInstance().findAllUsers();
		session.setAttribute("userlist", userlist);
		session.setAttribute("lastForward", forward);
		return forward;
	}

}
