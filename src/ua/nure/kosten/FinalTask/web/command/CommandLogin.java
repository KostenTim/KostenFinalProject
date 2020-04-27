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


public class CommandLogin extends Command {
	
	/**
	 * CommandLogin command.
	 * This command authorizes the user
	 *  and redirects to the main page depending on the role.
	 * @author t.Kosten
	 * 
	 */
	
	private static final long serialVersionUID = 223341L;
	
	private static final Logger LOG = Logger.getLogger(CommandLogin.class);

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
			forward = Path.PAGE_INDEX;
			LOG.error("Login/password cannot be empty");
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
			LOG.error("Cannot find user with such login/password");
			forward = Path.PAGE_INDEX;
		} else {
			if ("user".equals(user.getRole())) {
				forward = Path.PAGE_HELLO_USER;
			} else {
				forward = Path.PAGE_HELLO_ADM;
			}
		}
		
		session.setAttribute("user", user);
		LOG.trace("Set the session attribute: user --> " + user);
		session.setAttribute("lastForward", forward);
		
		return forward;

	}

}
