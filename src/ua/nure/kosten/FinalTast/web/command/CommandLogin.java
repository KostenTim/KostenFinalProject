package ua.nure.kosten.FinalTast.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.nure.kosten.FinalTast.Password;
import ua.nure.kosten.FinalTast.db.DBManager;
import ua.nure.kosten.FinalTast.db.entity.User;
import ua.nure.kosten.FinalTast.resources.Text;


public class CommandLogin extends Command {
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		String error = "";
		DBManager manager = DBManager.getInstance();
		Text text = (Text) session.getAttribute("text");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String forward="";
		if (password.isEmpty() || login.isEmpty()) {
			if ("rus".equals(text.getLg())){
				error = "Логин/Пароль не корректны";
			} else {
				error = "Login/password cannot be empty";
			}		
			request.setAttribute("error", error);
			forward = "index.jsp";
			return forward;
		} 

		User user = manager.findUserByLogin(login);
		if (user == null || !Password.md5Coding(password).equals(user.getPassword())) {
			if ("rus".equals(text.getLg())){
				error = "Пользователь не найден";
			} else {
				error = "Cannot find user with such login/password";
			}	
			
			
			request.setAttribute("error", error);
			forward = "index.jsp";
		} else {
			if ("user".equals(user.getRole())) {
				forward = "/WEB-INF/jsp/client/helloUser.jsp";
			} else {
				forward = "/WEB-INF/jsp/adm/helloAdm.jsp";
			}
		}
		
		session.setAttribute("user", user);
		session.setAttribute("lastForward", forward);
		
		return forward;

	}

}
