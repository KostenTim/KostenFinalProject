package ua.nure.kosten.FinalTask.web.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.kosten.FinalTask.db.DBManager;
import ua.nure.kosten.FinalTask.db.entity.RailwayRoute;
import ua.nure.kosten.FinalTask.db.entity.User;
import ua.nure.kosten.FinalTask.TimeStation;
import ua.nure.kosten.FinalTask.resources.Text;
import ua.nure.kosten.FinalTask.web.Path;

public class CommandDeleteStation extends Command {

	/**
	 * CommandDeleteStation command.
	 * This command allows the administrator to delete intermediate stations in the route
	 * @author t.Kosten
	 * 
	 */
	
	private static final long serialVersionUID = 1223423L;
	
	private static final Logger LOG = Logger.getLogger(CommandDeleteStation.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null||!"adm".equals(((User) session.getAttribute("user")).getRole()) ){
			return Path.PAGE_INDEX;
		}
		String forward = Path.PAGE_EDIT_ROUTE;
		Text text = (Text) session.getAttribute("text");
		Object obj = session.getAttribute("id_route_edite");
		String temp = "";
		String error = "";
		if (obj == null) {
			temp = request.getParameter("id_route");	
		} else {
			temp = obj.toString();
		}
		int id = Integer.valueOf(temp);
		if (request.getParameter("delete_station") != null) {
			
			String station = request.getParameter("delete_station");
			DBManager.getInstance().DeleteStationFrowRoute(id, station);
			LOG.info(session.getAttribute("user") + " deleted " + station + " from rout id " + id);
		} else {
			LOG.error("Incorrect input");
			if ("rus".equals(text.getLg())){
				error = "Не корректный ввод";
			} else {
				error = "Incorrect input";
			}
			request.setAttribute("error", error);
		}
	
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

		ArrayList<TimeStation> list_edit_station = new ArrayList<TimeStation>();
		String[] stations2 = {"A2","A3","A4","A5","A6","A7"}; 
		for (int i = 0 ; i < stations2.length ; i ++) {
			if (DBManager.getInstance().RouteHaveStation(rr, stations2[i])) {
				list_edit_station.add(new TimeStation (rr , stations2[i]));
			}
		}
		
		ArrayList<TimeStation> list_add_station = new ArrayList<TimeStation>();
		for (int i = 0 ; i < stations2.length ; i ++) {
			if (!DBManager.getInstance().RouteHaveStation(rr, stations2[i])) {
				list_add_station.add(new TimeStation (rr , stations2[i]));
			}
		}
		session.setAttribute("list_add_station", list_add_station);
		session.setAttribute("list_edit_station", list_edit_station);
		session.setAttribute("liststation", liststation);
		
		session.setAttribute("id_route_edite", id);
		session.setAttribute("lastForward", forward);
		return forward;
	}

}
