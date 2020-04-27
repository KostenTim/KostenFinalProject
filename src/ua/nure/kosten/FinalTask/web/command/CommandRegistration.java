package ua.nure.kosten.FinalTask.web.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import ua.nure.kosten.FinalTask.Password;
import ua.nure.kosten.FinalTask.db.DBManager;
import ua.nure.kosten.FinalTask.db.entity.User;
import ua.nure.kosten.FinalTask.resources.Text;
import ua.nure.kosten.FinalTask.web.Path;

public class CommandRegistration extends Command {

	/**
	 * CommandRegistration command.
	 * This command registers a new user in the system.
	 * @author t.Kosten
	 * 
	 */
	
	private static final long serialVersionUID = 1234423L;
	
	private static final Logger LOG = Logger.getLogger(CommandRegistration.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		String error="";
		Text text = (Text) session.getAttribute("text");
		String forward = Path.PAGE_REGIST;
		String login = request.getParameter("login");
		String password1 = request.getParameter("password");
		String password2 = request.getParameter("password2");
		if (!Password.isValidPassword(password1) || !Password.isValidPassword(password2)
				|| !Password.isValidLogin(login)) {
			LOG.error("Login/password cannot be empty");
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
			LOG.error("A user with that username is already there");
			if ("rus".equals(text.getLg())){
				error = "Пользователь с таким именем уже существует";
			} else {
				error = "A user with that username is already there";
			}	
	
			request.setAttribute("error", error);
			return forward;
		}
		if (!password1.equals(password2)) {
			LOG.error("You entered different passwords");
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
		forward = Path.PAGE_INDEX;
		String message = "registration completed successfully";
		LOG.info("new user("+user+") registered");
		request.setAttribute("messege", message);
		session.setAttribute("lastForward", forward);
		return forward;
	}

}
