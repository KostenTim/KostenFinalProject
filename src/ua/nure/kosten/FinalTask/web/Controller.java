package ua.nure.kosten.FinalTask.web;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import ua.nure.kosten.FinalTask.db.DBManager;
import ua.nure.kosten.FinalTask.db.entity.User;
import ua.nure.kosten.FinalTask.web.command.Command;
import ua.nure.kosten.FinalTask.web.command.CommandContainer;

/**
 * Main servlet controller.
 * 
 * @author T.Kosten
 * 
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	
	private static final long serialVersionUID = 112331L;
	
	private static final Logger LOG = Logger.getLogger(Controller.class);
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	/**
	 * Main method of this controller.
	 */
	private void process(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		
		LOG.debug("Controller starts");
		String commandName = request.getParameter("command");
		Command com = CommandContainer.get(commandName);
		LOG.trace("Obtained command --> " + com);
		String forward = com.execute(request, response);
		LOG.debug("Controller finished, now go to forward address --> " + forward);
		request.getRequestDispatcher(forward).forward(request, response);
	}

}
