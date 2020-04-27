package ua.nure.kosten.FinalTast.web.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.kosten.FinalTast.db.entity.Tickets;
import ua.nure.kosten.FinalTast.resources.Text;

public class CommandTranslate extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		String forward = (String) session.getAttribute("lastForward");
		Text text = null;
		
		if ("eng".equals(request.getParameter("leng"))) {
			text = new Text("eng");
			session.setAttribute("text", text);
		}
		if ("rus".equals(request.getParameter("leng"))) {
			text = new Text("rus");
			session.setAttribute("text", text);
			
		}
		
		if (session.getAttribute("tickets")!= null) {
			List<Tickets> ticketsList = (List<Tickets>) session.getAttribute("tickets");
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
			} else {
				for (int i=0 ; i < ticketsList.size() ; i++) {
					if ("купе".equals(ticketsList.get(i).getPlace_type())) {
						ticketsList.get(i).setPlace_type("compartment train");
					}
					if ("плацкард".equals(ticketsList.get(i).getPlace_type())) {
						ticketsList.get(i).setPlace_type("sleeper train");
					}
					if ("общее".equals(ticketsList.get(i).getPlace_type())) {
						ticketsList.get(i).setPlace_type("train carriage");
					}
					
				}
			}
			session.setAttribute("tickets", ticketsList);
		}
		
		return forward;
	}


}
