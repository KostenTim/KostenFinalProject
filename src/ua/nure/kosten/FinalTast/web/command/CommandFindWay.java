package ua.nure.kosten.FinalTast.web.command;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.kosten.FinalTast.db.DBManager;
import ua.nure.kosten.FinalTast.db.entity.RailwayRoute;
import ua.nure.kosten.FinalTast.db.entity.TimeStation;
import ua.nure.kosten.FinalTast.db.entity.User;
import ua.nure.kosten.FinalTast.db.entity.WayShowForUser;
import ua.nure.kosten.FinalTast.resources.Text;


public class CommandFindWay extends Command {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String forward = "/WEB-INF/jsp/client/helloUser.jsp";
		HttpSession session = request.getSession();
		Text text = (Text) session.getAttribute("text");
		String station1 = request.getParameter("station1");
		String station2 = request.getParameter("station2");
		String error = "";
		List list = DBManager.getInstance().findAllRailwayRoutes();
		List<WayShowForUser> res = new ArrayList<WayShowForUser>();
		for (int i = 0 ; i < list.size(); i++) {
			RailwayRoute rr =  (RailwayRoute) list.get(i);
			if (DBManager.getInstance().RouteHaveStations(rr, station1, station2)) {
				res.add(new WayShowForUser((RailwayRoute) list.get(i) , station1, station2));
			}
		}
		if (res.isEmpty()) {
			if ("rus".equals(text.getLg())){
				error = "Не найдено";
			} else {
				error = "Not Found";
			}		

			request.setAttribute("error", error);
		} else {
			forward = "/WEB-INF/jsp/client/FindWay.jsp";
			session.setAttribute("WayShowForUser", res);
			session.setAttribute("st1", station1);
			session.setAttribute("st2", station2);
		}
		session.setAttribute("lastForward", forward);
		return forward;
	}

}
