package ua.nure.kosten.FinalTask.web.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.kosten.FinalTask.db.entity.Tickets;
import ua.nure.kosten.FinalTask.resources.Text;

public class CommandTranslate extends Command {

	/**
	 * CommandTranslate command.
	 * This command changes the language of the page.
	 * @author t.Kosten
	 * 
	 */
	
	private static final long serialVersionUID = 1323442L;
	
	private static final Logger LOG = Logger.getLogger(CommandTranslate.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		String forward = (String) session.getAttribute("lastForward");
		Text text = null;
		LOG.info(session.getAttribute("user") + " changed the language to " + request.getParameter("leng"));
		
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
