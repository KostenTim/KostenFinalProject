package ua.nure.kosten.FinalTast.web.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.kosten.FinalTast.db.DBManager;
import ua.nure.kosten.FinalTast.db.entity.RailwayRoute;

public class CommandShowWays extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		String forward = "/WEB-INF/jsp/adm/WayList.jsp";
		HttpSession session = request.getSession();
		List<RailwayRoute> list = DBManager.getInstance().findAllRailwayRoutes();
		session.setAttribute("listWay", list);
		session.setAttribute("lastForward", forward);
		return forward;
	}

}
