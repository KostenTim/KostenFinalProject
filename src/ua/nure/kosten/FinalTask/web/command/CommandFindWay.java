package ua.nure.kosten.FinalTask.web.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.kosten.FinalTask.db.DBManager;
import ua.nure.kosten.FinalTask.db.entity.RailwayRoute;
import ua.nure.kosten.FinalTask.db.entity.WayShowForUser;
import ua.nure.kosten.FinalTask.resources.Text;
import ua.nure.kosten.FinalTask.web.Path;


public class CommandFindWay extends Command {

	/**
	 * CommandFindWay command.
	 * This command allows the client to find the routes he is interested in.
	 * @author t.Kosten
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger LOG = Logger.getLogger(CommandFindWay.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String forward = Path.PAGE_HELLO_USER;
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null){
			return Path.PAGE_INDEX;
		}
		Text text = (Text) session.getAttribute("text");
		String station1 = request.getParameter("station1");
		String station2 = request.getParameter("station2");
		String error = "";
		List<RailwayRoute> list = DBManager.getInstance().findAllRailwayRoutes();
		List<WayShowForUser> res = new ArrayList<WayShowForUser>();
		for (int i = 0 ; i < list.size(); i++) {
			RailwayRoute rr =  (RailwayRoute) list.get(i);
			if (DBManager.getInstance().RouteHaveStations(rr, station1, station2)) {
				res.add(new WayShowForUser((RailwayRoute) list.get(i) , station1, station2));
			}
		}
		if (res.isEmpty()) {
			LOG.error("Not Found");
			if ("rus".equals(text.getLg())){
				error = "Не найдено";
			} else {
				error = "Not Found";
			}		

			request.setAttribute("error", error);
		} else {
			LOG.info(session.getAttribute("user") + " find way from "+station1+" to "+station2);
			forward = Path.PAGE_FIND_WAY;
			session.setAttribute("WayShowForUser", res);
			session.setAttribute("st1", station1);
			session.setAttribute("st2", station2);
		}
		session.setAttribute("lastForward", forward);
		return forward;
	}

}
