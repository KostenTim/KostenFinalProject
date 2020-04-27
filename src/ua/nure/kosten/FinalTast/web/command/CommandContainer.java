package ua.nure.kosten.FinalTast.web.command;

import java.util.Map;
import java.util.TreeMap;



public class CommandContainer {

	private static Map<String, Command> commands = new TreeMap<String, Command>();
	
	static {
		// common commands
		commands.put("registr", new CommandRegistration());
		commands.put("login", new CommandLogin());
		commands.put("logout", new CommandLogout());
		commands.put("findway", new CommandFindWay());
		commands.put("showInfoTrin", new CommandWayInfo());
		commands.put("buyTicket", new CommandBuyTicket());
		commands.put("showTickets", new CommandShowTickets());
		commands.put("goToHomePage", new CommandGoToHomePage());
		commands.put("WayList", new CommandShowWays());
		commands.put("EditRoute", new CommandEditRoute());
		commands.put("DeleteStation", new CommandDeleteStation());
		commands.put("ChangeStopTime", new CommandChangeStopTime());
		commands.put("AddStation", new CommandAddStation());
		commands.put("showAllUsers", new CommandShowAllUsers());
		commands.put("translate", new CommandTranslate());
		commands.put("goToRegistration", new CommandGoToPageRegistration());
		
		
	}
	
	public static Command get(String commandName) {
		if (commandName == null || !commands.containsKey(commandName)) {
			return commands.get("noCommand"); 
		}
		
		return commands.get(commandName);
	}
}
