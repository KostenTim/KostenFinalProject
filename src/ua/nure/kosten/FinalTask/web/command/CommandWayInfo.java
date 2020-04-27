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
import ua.nure.kosten.FinalTask.web.Path;
import ua.nure.kosten.FinalTask.TimeStation;

public class CommandWayInfo extends Command {

	/**
	 * CommandWayInfo command.
	 * This command provides detailed route information to the client.
	 * @author t.Kosten
	 * 
	 */
	
	private static final long serialVersionUID = 223441L;
	
	private static final Logger LOG = Logger.getLogger(CommandWayInfo.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
	
		String forward = Path.PAGE_WAY_INFO;
		HttpSession session = request.getSession();
		LOG.info(session.getAttribute("user") + " watching route details");
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
