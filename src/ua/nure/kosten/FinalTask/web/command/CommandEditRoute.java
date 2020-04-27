package ua.nure.kosten.FinalTask.web.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.kosten.FinalTask.db.DBManager;
import ua.nure.kosten.FinalTask.db.entity.RailwayRoute;
import ua.nure.kosten.FinalTask.db.entity.Tickets;
import ua.nure.kosten.FinalTask.db.entity.User;
import ua.nure.kosten.FinalTask.TimeStation;
import ua.nure.kosten.FinalTask.resources.Text;
import ua.nure.kosten.FinalTask.web.Path;

public class CommandEditRoute extends Command {

	/**
	 * CommandEditRoute command.
	 * This command redirects the administrator to the route edit page.
	 * @author t.Kosten
	 * 
	 */
	
	private static final long serialVersionUID = 1232324L;
	
	private static final Logger LOG = Logger.getLogger(CommandEditRoute.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
	
	HttpSession session = request.getSession();
	if(session.getAttribute("user") == null||!"adm".equals(((User) session.getAttribute("user")).getRole()) ){
		return Path.PAGE_INDEX;
	}
	Text text = (Text) session.getAttribute("text");
	String forward = Path.PAGE_EDIT_ROUTE;
	String temp = request.getParameter("id_route");
	int id = Integer.valueOf(temp);
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
	
	List<Tickets> ticketlist = DBManager.getInstance().findAllTickets();
		for (int i = 0; i < ticketlist.size(); i++) {
			if (ticketlist.get(i).getId_railway_route() == id) {
				forward = Path.PAGE_WAY_LIST;
				String error = "";
				LOG.error("This route cannot be edited because tickets are purchased");
				if ("rus".equals(text.getLg())){
					error = "Этот маршрут не может быть отредактирован так как на него куплены билеты";
				} else {
					error = "This route cannot be edited because tickets are purchased";
				}		
				request.setAttribute("listWay", list);
				request.setAttribute("error", error);
			}
		}
	session.setAttribute("lastForward", forward);
	return forward;
	}

}
