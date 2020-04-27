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

public class CommandRegistration extends Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		String error="";
		Text text = (Text) session.getAttribute("text");
		String forward = "regist.jsp";
		String login = request.getParameter("login");
		String password1 = request.getParameter("password");
		String password2 = request.getParameter("password2");
		if (!Password.isValidPassword(password1) || !Password.isValidPassword(password2)
				|| !Password.isValidLogin(login)) {
			if ("rus".equals(text.getLg())){
				error = "Логин/Пароль не корректны";
			} else {
				error = "Login/password cannot be empty";
			}	
			request.setAttribute("error", error);
			return forward;
		}
		DBManager manager = DBManager.getInstance();
		User user = manager.findUserByLogin(login);
		if (user!=null) {
			if ("rus".equals(text.getLg())){
				error = "Пользователь с таким именем уже существует";
			} else {
				error = "A user with that username is already there";
			}	
	
			request.setAttribute("error", error);
			return forward;
		}
		if (!password1.equals(password2)) {
			if ("rus".equals(text.getLg())){
				error = "Пароли не совподат";
			} else {
				error = "You entered different passwords";
			}	

			request.setAttribute("error", error);
			return forward;
		}
		//forward = "index.jsp";
		DBManager db = DBManager.getInstance();
		User user1 = new User(login , Password.md5Coding(password1));
		db.createNewUser(user1);
		forward = "index.jsp";
		String message = "registration completed successfully";
		request.setAttribute("messege", message);
		session.setAttribute("lastForward", forward);
		return forward;
	}

}
