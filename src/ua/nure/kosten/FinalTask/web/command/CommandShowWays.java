package ua.nure.kosten.FinalTask.web.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.kosten.FinalTask.db.DBManager;
import ua.nure.kosten.FinalTask.db.entity.RailwayRoute;
import ua.nure.kosten.FinalTask.db.entity.User;
import ua.nure.kosten.FinalTask.web.Path;

public class CommandShowWays extends Command {

	/**
	 * CommandShowWays command.
	 * This command provides a list of all routes to the administrator.
	 * @author t.Kosten
	 * 
	 */
	
	private static final long serialVersionUID = 1332323L;
	
	private static final Logger LOG = Logger.getLogger(CommandShowWays.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String forward = Path.PAGE_WAY_LIST;
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null||!"adm".equals(((User) session.getAttribute("user")).getRole()) ){
			return Path.PAGE_INDEX;
		}
		List<RailwayRoute> list = DBManager.getInstance().findAllRailwayRoutes();
		session.setAttribute("listWay", list);
		session.setAttribute("lastForward", forward);
		return forward;
	}

}
