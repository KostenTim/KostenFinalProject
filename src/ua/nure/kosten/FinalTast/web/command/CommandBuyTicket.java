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
import ua.nure.kosten.FinalTast.db.entity.User;
import ua.nure.kosten.FinalTast.db.entity.WayShowForUser;
import ua.nure.kosten.FinalTast.resources.Text;

public class CommandBuyTicket extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String forward = "/WEB-INF/jsp/client/FindWay.jsp";
		String place = request.getParameter("place");
		String nameTrain = request.getParameter("nameTrain");
		String error="";
		String message="";
		HttpSession session = request.getSession();
		Text text = (Text) session.getAttribute("text");
		String station1 = (String) session.getAttribute("st1");
		String station2 = (String) session.getAttribute("st2");
		User user = (User) session.getAttribute("user");
		List<WayShowForUser> waylist = (List<WayShowForUser>) session.getAttribute("WayShowForUser");
		WayShowForUser wu = null;
		for ( int i = 0 ; i < waylist.size(); i ++) {
			if (nameTrain.equals(waylist.get(i).getRain_number())) {
				wu = waylist.get(i);
			}
		}
		int id = DBManager.getInstance().idTrain(nameTrain);
		List<RailwayRoute> list = DBManager.getInstance().findAllRailwayRoutes();
		RailwayRoute rr = null;
		for ( int j = 0 ; j < list.size(); j ++) {
			if ( id == 	list.get(j).getId_train()) {
				rr = list.get(j);
			}
		}
		if ("compartment train".equals(place)) {
			if (rr.getFree_place_type1()==0) {
				if ("rus".equals(text.getLg())){
					error = "нет свободных мест данного типа";
				} else {
					error = "no free places";
				}	

			} else {
				DBManager.getInstance().createNewTicket(user.getId(), rr.getId_railway_route(),
						wu.getCost_type1(), wu.getStart_station(),
						wu.getEnd_station(), wu.getStart().getDate(),
						wu.getStart().getTime(), wu.getEnd().getDate(),
						wu.getEnd().getTime(), place);
				DBManager.getInstance().updatePlace(rr, place);
				if ("rus".equals(text.getLg())){
					message = "Билет успешно куплен";
				} else {
					message = "ticket successfully purchased";
				}
				
			}
		}
		if ("sleeper train".equals(place)) {
			if (rr.getFree_place_type2()==0) {
				if ("rus".equals(text.getLg())){
					error = "нет свободных мест данного типа";
				} else {
					error = "no free places";
				}
			} else {
				DBManager.getInstance().createNewTicket(user.getId(), rr.getId_railway_route(),
						wu.getCost_type2(), wu.getStart_station(),
						wu.getEnd_station(), wu.getStart().getDate(),
						wu.getStart().getTime(), wu.getEnd().getDate(),
						wu.getEnd().getTime(), place);
				DBManager.getInstance().updatePlace(rr, place);
				if ("rus".equals(text.getLg())){
					message = "Билет успешно куплен";
				} else {
					message = "ticket successfully purchased";
				}
			}

		}
		if ("train carriage".equals(place)) {
			if (rr.getFree_place_type3()==0) {
				if ("rus".equals(text.getLg())){
					error = "нет свободных мест данного типа";
				} else {
					error = "no free places";
				}
			} else {
				DBManager.getInstance().createNewTicket(user.getId(), rr.getId_railway_route(),
						wu.getCost_type3(), wu.getStart_station(),
						wu.getEnd_station(), wu.getStart().getDate(),
						wu.getStart().getTime(), wu.getEnd().getDate(),
						wu.getEnd().getTime(), place);
				DBManager.getInstance().updatePlace(rr, place);
				if ("rus".equals(text.getLg())){
					message = "Билет успешно куплен";
				} else {
					message = "ticket successfully purchased";
				}
			}

		}
		List list2 = DBManager.getInstance().findAllRailwayRoutes();
		List<WayShowForUser> res = new ArrayList<WayShowForUser>();
		for (int i = 0 ; i < list2.size(); i++) {
			RailwayRoute rr2 =  (RailwayRoute) list2.get(i);
			if (DBManager.getInstance().RouteHaveStations(rr2, station1, station2)) {
				res.add(new WayShowForUser((RailwayRoute) list2.get(i) , station1, station2));
			}
		}
		request.setAttribute("error", error);
		request.setAttribute("message", message);
		session.setAttribute("WayShowForUser", res);
		session.setAttribute("st1", station1);
		session.setAttribute("st2", station2);
		session.setAttribute("lastForward", forward);
		return forward;
	}
}


