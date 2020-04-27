package ua.nure.kosten.FinalTast.web.command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.kosten.FinalTast.db.DBManager;
import ua.nure.kosten.FinalTast.db.entity.Tickets;
import ua.nure.kosten.FinalTast.db.entity.User;
import ua.nure.kosten.FinalTast.resources.Text;

public class CommandShowTickets extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String forward = "/WEB-INF/jsp/client/ShowTickets.jsp";
		List<Tickets> ticketsList2 = DBManager.getInstance().findAllTickets();
		List<Tickets> ticketsList = new ArrayList<Tickets>();
		HttpSession session = request.getSession();
		Text text = (Text) session.getAttribute("text");
		User user = (User) session.getAttribute("user");
		for (int i = 0 ; i < ticketsList2.size(); i ++) {
			if (ticketsList2.get(i).getUsers_id()== user.getId()) {
				ticketsList.add(ticketsList2.get(i));
			}
		}
		if (ticketsList.size()==0) {
			forward = "/WEB-INF/jsp/client/ShowTicketsNotFound.jsp";
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
