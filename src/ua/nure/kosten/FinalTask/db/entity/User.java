package ua.nure.kosten.FinalTask.db.entity;

/**
 * User entity.
 * 
 * @author T.Kosten
 * 
 */

public class User {
	
	private int id;
	private String login;
	private String password;
	private String role = "user";
	
	public User(int id, String login, String password, String role) {
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	public User (String login, String password) {
		this.login = login;
		this.password = password;
	}
	@Override
	public String toString() {
		return login;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
