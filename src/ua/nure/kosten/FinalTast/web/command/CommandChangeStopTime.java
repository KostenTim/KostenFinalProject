package ua.nure.kosten.FinalTast.web.command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.kosten.FinalTast.db.DBManager;
import ua.nure.kosten.FinalTast.db.entity.RailwayRoute;
import ua.nure.kosten.FinalTast.db.entity.TimeStation;
import ua.nure.kosten.FinalTast.resources.Text;

public class CommandChangeStopTime extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String error = "";
		boolean flag = true;
		HttpSession session = request.getSession();
		Text text = (Text) session.getAttribute("text");
		String forward = "/WEB-INF/jsp/adm/EditRoute.jsp";
		Object obj = session.getAttribute("id_route_edite");
		String temp = "";
		if (obj == null) {
			temp = request.getParameter("id_route");	
		} else {
			temp = obj.toString();
		}
		int id = Integer.valueOf(temp);
		
		
		String stoptime = request.getParameter("stop_time");
		int stop_time = 0;
		try {
		stop_time = Integer.valueOf(stoptime);
		} catch (java.lang.NumberFormatException e) {
			if ("rus".equals(text.getLg())){
				error = "Не корректный ввод";
			} else {
				error = "Incorrect input";
			}	
			
			flag = false;
		}	
		if(stop_time <= 0 || stop_time > 300) {
			if ("rus".equals(text.getLg())){
				error = "Не корректный ввод";
			} else {
				error = "Incorrect input";
			}	
			flag = false;
		}
		int hour = 0;	
		while ( stop_time >= 60) {
			hour++;
			stop_time-=60;
		}
		int min = stop_time;
		if (flag) {
			if (request.getParameter("change_station") != null) {
				String station = request.getParameter("change_station");
				DBManager.getInstance().updateStopTimeStation(id, min, hour, station);
			} else {
				if ("rus".equals(text.getLg())){
					error = "Не корректный ввод";
				} else {
					error = "Incorrect input";
				}	
			}
			
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
		session.setAttribute("lastForward", forward);
		session.setAttribute("id_route_edite", id);
		request.setAttribute("error", error);
		return forward;
	}

}
