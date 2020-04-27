package ua.nure.kosten.FinalTast.web.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.kosten.FinalTast.db.DBManager;
import ua.nure.kosten.FinalTast.db.entity.RailwayRoute;
import ua.nure.kosten.FinalTast.db.entity.TimeStation;

public class CommandWayInfo extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String forward = "/WEB-INF/jsp/client/WayInfo.jsp";
		HttpSession session = request.getSession();
		String nameTrain = request.getParameter("nameTrain");
		int id = DBManager.getInstance().idTrain(nameTrain);
		List<RailwayRoute> list = DBManager.getInstance().findAllRailwayRoutes();
		RailwayRoute rr = null;
		for ( int i = 0 ; i < list.size(); i ++) {
			if ( id == 	list.get(i).getId_train()) {
				rr = list.get(i);
			}
		}
		ArrayList<TimeStation> liststation = new ArrayList<TimeStation>();
		String[] stations = {"A1","A2","A3","A4","A5","A6","A7","A8"}; 
		for (int i = 0 ; i < stations.length ; i ++) {
			if (DBManager.getInstance().RouteHaveStation(rr, stations[i])) {
				liststation.add(new TimeStation (rr , stations[i]));
			}
		}
		
		session.setAttribute("liststation", liststation);
		session.setAttribute("lastForward", forward);
		return forward;
	}

}
