package ua.nure.kosten.FinalTast.web.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.kosten.FinalTast.db.DBManager;
import ua.nure.kosten.FinalTast.db.entity.User;

public class CommandShowAllUsers extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String forward = "/WEB-INF/jsp/adm/ShowUsers.jsp";
		HttpSession session = request.getSession();
		List<User> userlist = DBManager.getInstance().findAllUsers();
		session.setAttribute("userlist", userlist);
		session.setAttribute("lastForward", forward);
		return forward;
	}

}
