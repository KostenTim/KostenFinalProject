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
import ua.nure.kosten.FinalTask.db.entity.Tickets;
import ua.nure.kosten.FinalTask.db.entity.User;
import ua.nure.kosten.FinalTask.resources.Text;
import ua.nure.kosten.FinalTask.web.Path;

public class CommandShowTickets extends Command {

	/**
	 * CommandShowTickets command.
	 * This command provides a list of purchased tickets.
	 * @author t.Kosten
	 * 
	 */
	
	private static final long serialVersionUID = 1334234L;
	
	private static final Logger LOG = Logger.getLogger(CommandShowTickets.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String forward = Path.PAGE_SHOW_TICKETS;
		List<Tickets> ticketsList2 = DBManager.getInstance().findAllTickets();
		List<Tickets> ticketsList = new ArrayList<Tickets>();
		HttpSession session = request.getSession();
		if(session.getAttribute("user") == null){
			return Path.PAGE_INDEX;
		}
		Text text = (Text) session.getAttribute("text");
		User user = (User) session.getAttribute("user");
		for (int i = 0 ; i < ticketsList2.size(); i ++) {
			if (ticketsList2.get(i).getUsers_id()== user.getId()) {
				ticketsList.add(ticketsList2.get(i));
			}
		}
		if (ticketsList.size()==0) {
			forward = Path.PAGE_SHOW_TICKETS_NOT_FOUND;
		}
		if ("rus".equals(text.getLg())){
			for (int i=0 ; i < ticketsList.size() ; i++) {
				if ("compartment train".equals(ticketsList.get(i).getPlace_type())) {
					ticketsList.get(i).setPlace_type("купе");
				}
				if ("sleeper train".equals(ticketsList.get(i).getPlace_type())) {
					ticketsList.get(i).setPlace_type("плацкард");
				}
				if ("train carriage".equals(ticketsList.get(i).getPlace_type())) {
					ticketsList.get(i).setPlace_type("общее");
				}
				
			}
		} 
		session.setAttribute("lastForward", forward);
		session.setAttribute("tickets", ticketsList);
		return forward;
	}
	
}
