package ua.nure.kosten.FinalTask.db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import ua.nure.kosten.FinalTask.db.entity.RailwayRoute;
import ua.nure.kosten.FinalTask.db.entity.Tickets;
import ua.nure.kosten.FinalTask.db.entity.User;

/**
 * DB manager. Works with Apache Derby DB. 
 * 
 * @author T.Kosten
 * 
 */
public final class DBManager {
	
	private static final Logger LOG = Logger.getLogger(DBManager.class);
	
	// //////////////////////////////////////////////////////////
	// singleton
	// //////////////////////////////////////////////////////////

	private static DBManager instance;

	public static synchronized DBManager getInstance(){
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}
	
	private DBManager() {
		try {
			Context initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/FinalProject");
			LOG.trace("Data source ==> " + ds);
		} catch (NamingException ex) {
			LOG.error("Cannot obtain the data source", ex);
		
		}
	}
	
	private DataSource ds;
	
	// //////////////////////////////////////////////////////////
	// SQL queries
	// //////////////////////////////////////////////////////////
	
	private static final String SQL_SELECT_FROM_USERS = "SELECT * FROM users";
	
	private static final String SQL_SELECT_BY_LOGIN_FROM_USERS = "SELECT * FROM USERS WHERE login='";
	
	private static final String SQL_INSERT_USER = "INSERT INTO users VALUES (DEFAULT, ?,?,?)";
	
	private static final String SQL_SELECT_FROM_RAILWAY_ROUTES = "SELECT * FROM railway_route";
	
	private static final String SQL_SELECT_FROM_STATION_BY_ID_RAILWAY = "SELECT * FROM station_has_railway_route"
			+ " WHERE railway_route_id_railway_route=";
	private static final String SQL_NAME_TRAIN_BY_ID = "SELECT * FROM trains WHERE id_train=";
	
	private static final String SQL_TIME_TO_STATION_BY_NAME = "SELECT * FROM station WHERE name='A";
	
	private static final String SQL_STOP_TIME_STATION_IN_WAY_BY_ID_WAY_ID_ST = "SELECT * FROM station_has_railway_route WHERE railway_route_id_railway_route=";
	
	private static final String SQL_ID_TRAIN_BY_NAME = "SELECT * FROM trains WHERE name='";
	
	private static final String SQL_INSERT_TICKET = "INSERT INTO tickets VALUES (DEFAULT,?,?,?,?,?,?,?,?)";
	
	private static final String SQL_UPDATE_PLACE = "UPDATE railway_route SET ";
	
	private static final String SQL_ID_TRAIN_BY_ID_WAY = "SELECT * FROM railway_route WHERE id_railway_route=";
	
	private static final String SQL_SELECT_FROM_TICKETS = "SELECT * FROM tickets";
	
	private static final String SQL_DELETE_STATION_FROM_ROUTE = "DELETE FROM station_has_railway_route WHERE railway_route_id_railway_route=";
	
	private static final String SQL_UPDATE_STOP_TIME_STATION = "UPDATE station_has_railway_route SET stop_time=";
	
	private static final String SQL_INSERT_STATION_TO_ROUTE = "INSERT INTO station_has_railway_route VALUES (DEFAULT, ?,?,?)";

	private static final String METHOD_NAME = "in METHOD NAME ";

	/**
	 * Returns a DB connection from the Pool Connections. 
	 * 
	 * @return DB connection.
	 */
	public Connection getConnection() {
		Connection con = null;
		try {
			con = ds.getConnection();
		} catch (SQLException ex) {
			LOG.error("Cannot obtain a connection from the pool", ex);
		}
		return con;
	}
	
	// //////////////////////////////////////////////////////////
	// Methods 
	// //////////////////////////////////////////////////////////
	
	/**
	 * Returns true if this route stops at this station.
	 * @param rr
	 * 			Railway route
	 * @param s1
	 * 			Station name
	 * @return "true" - the station is on the route
	 * 		   "false" - the station is not on the route
	 */
	public boolean RouteHaveStation(RailwayRoute rr, String s1) {
		int st1 = Integer.valueOf(s1.replace("A", ""));
		ArrayList<Integer> id_stations = new ArrayList<Integer>();
		Connection con=null;
		Statement statement=null;
		ResultSet res=null;
		try {
			con = ds.getConnection();

			statement = con.createStatement();
			res = statement.executeQuery(SQL_SELECT_FROM_STATION_BY_ID_RAILWAY + rr.getId_railway_route());
			while (res.next()) {
				id_stations.add(res.getInt(2));				
			}
		} catch (SQLException e) {
			LOG.error("station search error" + METHOD_NAME + "RouteHaveStation",e);
		} finally {
			closeResurs(con,statement,res);
		}

		if (!id_stations.contains(st1)) {
			return false;
		}
		return true;
	}
	
	/**
	 * Returns true if this route stops at this stations.
	 * @param rr
	 * 			Railway route
	 * @param s1
	 * 			Station name one
	 * @param s2
	 * 			Station name two
	 * @return "true" - the stations is on the route
	 * 		   "false" - the stations is not on the route
	 */
	public boolean RouteHaveStations(RailwayRoute rr, String s1, String s2) {
		int st1 = Integer.valueOf(s1.replace("A", ""));
		int st2 = Integer.valueOf(s2.replace("A", ""));
		if (st1 >= st2) {
			return false;
		}
		ArrayList<Integer> id_stations = new ArrayList<Integer>();
		Connection con=null;
		Statement statement=null;
		ResultSet res=null;
		try {
			con = ds.getConnection();

			statement = con.createStatement();
			res = statement.executeQuery(SQL_SELECT_FROM_STATION_BY_ID_RAILWAY + rr.getId_railway_route());
			while (res.next()) {
				id_stations.add(res.getInt(2));				
			}
		} catch (SQLException e) {
			LOG.error("station search error" + METHOD_NAME + "RouteHaveStations",e);
		} finally {
			closeResurs(con,statement,res);
		}

		if (!id_stations.contains(st1)) {
			return false;
		}
		if (!id_stations.contains(st2)) {
			return false;
		}
		return true;
	}
	
	/**
	 * Returns the stop time at a specific station.
	 * @param id_way
	 * 			Railway route id
	 * * @param id_station
	 * 			Station id
	 * @return Time
	 */
	public Time StopTimeStationsInWay (int id_way, int id_station) {
		Connection con=null;
		Statement statement=null;
		ResultSet res=null;
		Time time = new Time(0,0,0);
		try {
			con = ds.getConnection();

			statement = con.createStatement();
			res = statement.executeQuery(SQL_STOP_TIME_STATION_IN_WAY_BY_ID_WAY_ID_ST + id_way);
			while (res.next()) {
				if (id_station == res.getInt(2)) {
					Time time2 = res.getTime(4);
					int hours = res.getTime(4).getHours();
					time2.setHours(hours+1);
					time = time2;
					
				}
							
			}
		} catch (SQLException e) {
			LOG.error("error finding stop time" + METHOD_NAME + "StopTimeStationsInWay",e);
		} finally {
			closeResurs(con,statement,res);
		}

		return time;

	}
	
	/**
	 * Returns the time that the train travels to the station.
	 * @param id
	 * 			Station id
	 * @return Time
	 */
	public Time TimeToStationById (int id) {
		Connection con=null;
		Statement statement=null;
		ResultSet res=null;
		Time time = null;
		try {
			con = ds.getConnection();

			statement = con.createStatement();
			res = statement.executeQuery(SQL_TIME_TO_STATION_BY_NAME + id + "'");
			while (res.next()) {
				time = res.getTime(3);
				time.setHours(time.getHours()+1);
			}
		} catch (SQLException e) {
			LOG.error("error searching time by name" + METHOD_NAME + "TimeToStationById",e);
		} finally {
			closeResurs(con,statement,res);
		}
		return time;

	}
	
	/**
	 * Returns the id of the train by its name.
	 * @param nameTrain
	 * 			Train name
	 * @return id train.
	 */
	public int idTrain (String nameTrain) {
		Connection con=null;
		Statement statement=null;
		ResultSet res=null;
		int id = 0;
		try {
			con = ds.getConnection();

			statement = con.createStatement();
			res = statement.executeQuery(SQL_ID_TRAIN_BY_NAME + nameTrain + "'");
			while (res.next()) {
				id = res.getInt(1);			
			}
		} catch (SQLException e) {
			LOG.error("train search error by name" + METHOD_NAME + "idTrain",e);
		} finally {
			closeResurs(con,statement,res);
		}

		return id;

	}
	
	/**
	 * Returns the identifier of the train that will go the specific route.
	 * @param id_way
	 * 			Railway route id
	 * @return id;
	 */
	public int idTrainByIdWay (int id_way) {
		Connection con=null;
		Statement statement=null;
		ResultSet res=null;
		int id = 0;
		try {
			con = ds.getConnection();

			statement = con.createStatement();
			res = statement.executeQuery(SQL_ID_TRAIN_BY_ID_WAY + id_way);
			while (res.next()) {
				id = res.getInt(2);			
			}
		} catch (SQLException e) {
			LOG.error("error finding a train along a route" + METHOD_NAME + "idTrainByIdWay",e);
		} finally {
			closeResurs(con,statement,res);
		}

		return id;

	}
	
	/**
	 * Returns the name of the train by its id.
	 * @param id
	 * 			id train
	 * @return id;
	 */
	public String nameTrain (int id) {
		Connection con=null;
		Statement statement=null;
		ResultSet res=null;
		String name = "";
		try {
			con = ds.getConnection();

			statement = con.createStatement();
			res = statement.executeQuery(SQL_NAME_TRAIN_BY_ID + id);
			while (res.next()) {
				name = res.getString(2);			
			}
		} catch (SQLException e) {
			LOG.error("train search error by id" + METHOD_NAME + "nameTrain",e);
		} finally {
			closeResurs(con,statement,res);
		}

		return name;

	}
	
	/**
	 * Returns a list of routes
	 * 
	 * @return List of routes.
	 */
	public List<RailwayRoute> findAllRailwayRoutes() {
		List<RailwayRoute> ar = new ArrayList<RailwayRoute>();
		Connection con=null;
		Statement statement=null;
		ResultSet res=null;
		try {
			con = ds.getConnection();

			statement = con.createStatement();
			res = statement.executeQuery(SQL_SELECT_FROM_RAILWAY_ROUTES);
			while (res.next()) {
				int id_railway_route = res.getInt(1);
				int id_train = res.getInt(2);
				Date start_way_date = res.getDate(3);
				Time start_way_time = res.getTime(4);
				start_way_time.setHours(start_way_time.getHours()+1);

				int free_place_type1 = res.getInt(5);
				int free_place_type2 = res.getInt(6);
				int free_place_type3 = res.getInt(7);

				ar.add(new RailwayRoute(id_railway_route , id_train,
						start_way_date, start_way_time, free_place_type1,
						free_place_type2, free_place_type3));				
			}
		} catch (SQLException e) {
			LOG.error("route search error" + METHOD_NAME + "findAllRailwayRoutes",e);
		} finally {
			closeResurs(con,statement,res);
		}

		return ar;
	}
	
	/**
	 * Returns a list of tickets.
	 * 
	 * @return List of tickets.
	 */
	public List<Tickets> findAllTickets() {
		List<Tickets> ar = new ArrayList<Tickets>();
		Connection con=null;
		Statement statement=null;
		ResultSet res=null;
		try {
			con = ds.getConnection();

			statement = con.createStatement();
			res = statement.executeQuery(SQL_SELECT_FROM_TICKETS);
			while (res.next()) {
				int id_ticket = res.getInt(1);
				int id_user = res.getInt(2);
				int id_railway = res.getInt(3);
				int cost = res.getInt(4);
				String start_station = res.getString(5);
				String final_station = res.getString(6);
				String start_travel = res.getString(7);
				String end_travel = res.getString(8);
				String place_type = res.getString(9);
				ar.add(new Tickets(id_ticket,id_user,id_railway,cost,
						start_station,final_station,start_travel,
						end_travel,place_type));				
			}
		} catch (SQLException e) {
			LOG.error("ticket search error" + METHOD_NAME + "findAllTickets",e);
		} finally {
			closeResurs(con,statement,res);
		}
		return ar;
	}
	
	/**
	 * Returns a list of users.
	 * 
	 * @return List of users.
	 */
	public List<User> findAllUsers() {
		List<User> ar = new ArrayList<User>();
		Connection con=null;
		Statement statement=null;
		ResultSet res=null;
		try {
			con = ds.getConnection();	
			statement = con.createStatement();
			res = statement.executeQuery(SQL_SELECT_FROM_USERS);
			while (res.next()) {
				int id = res.getInt(1);
				String login = res.getString(2);
				String password = res.getString(3);
				String role = res.getString(4);
				ar.add(new User(id , login, password, role ));				
			}
		} catch (SQLException e) {
			LOG.error("user search error" + METHOD_NAME + "findAllUsers",e);
		} finally {
			closeResurs(con,statement,res);
		}

		return ar;
	}
	
	/**
	 * Closes resources.
	 */
	private void closeResurs(Connection con, Statement statement,ResultSet res) {
		try {
			if (con != null) {
				con.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (res != null) {
				res.close();
			}

		} catch (SQLException e) {
			LOG.error("resource close error" + METHOD_NAME + "closeResurs",e);
		}
	}
	
	/**
	 * Returns user by login.
	 * @param login
	 * 			User login
	 * @return User.
	 */
	public User findUserByLogin(String login) {
		Connection con=null;
		Statement statement=null;
		ResultSet res=null;
		User user = null;
		try {
			con = ds.getConnection();
			statement = con.createStatement();
			StringBuilder sb = new StringBuilder();
			sb.append(SQL_SELECT_BY_LOGIN_FROM_USERS);
			sb.append(login);
			sb.append("'");
			res = statement.executeQuery(sb.toString());
			while (res.next()) {			
				int id = res.getInt(1);
				String logintemp = res.getString(2);
				String pass = res.getString(3);
				String role = res.getString(4);
				user = new User(id , logintemp, pass, role);			
			}
			return user;
		} catch (SQLException e) {
			LOG.error("user search error by login" + METHOD_NAME + "findUserByLogin",e);
			return null;
		} finally {
			closeResurs(con,statement,res);
		}
	}
	/**
	 * Creates a new user.
	 * @param user
	 */
	public void createNewUser(User user) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(
					SQL_INSERT_USER, Statement.RETURN_GENERATED_KEYS);
			int k = 1;
			pstmt.setString(k++, user.getLogin());
			pstmt.setString(k++, user.getPassword());
			pstmt.setString(k++, user.getRole());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			LOG.error("error adding user" + METHOD_NAME + "createNewUser",e);
		} finally {
			closeResurs(con,pstmt,rs);
		}
	}
	
	/**
	 * Creates a new ticket.
	 * @param id_user
	 * 			User id
	 * @param id_railway
	 * 			Railway route id
	 * @param cost
	 * 			Ticket price
	 * @param station1
	 * 		    Launch station
	 * @param station2
	 * 			Arrival station
	 * @param start_travel_date
	 * 			Start date
	 * @param start_travel_time
	 * 			Start time
	 * @param end_travel_date
	 * 			End date
	 * @param end_travel_time
	 * 			End time
	 * @param place
	 * 			Type of place
	 */
	public void createNewTicket(int id_user, int id_railway, int cost,
			String station1, String station2, Date start_travel_date,
			Time start_travel_time, Date end_travel_date, Time end_travel_time,
			String place) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(
					SQL_INSERT_TICKET, Statement.RETURN_GENERATED_KEYS);
			int k = 1;
			pstmt.setInt(k++, id_user);
			pstmt.setInt(k++, id_railway);
			pstmt.setInt(k++, cost);
			pstmt.setString(k++, station1);
			pstmt.setString(k++, station2);
			pstmt.setString(k++, start_travel_date.toString() + " " + start_travel_time.toString());
			pstmt.setString(k++, end_travel_date.toString() + " " + end_travel_time.toString());
			pstmt.setString(k++, place);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			LOG.error("error creating a ticket" + METHOD_NAME + "createNewTicket",e);
		} finally {
			closeResurs(con,pstmt,rs);
		}
	}

	/**
	 * Updates the number of free spaces of a certain type.
	 * @param rr
	 * 			Railway route
	 * @param place 
	 * 			Type of place
	 */
	public void updatePlace(RailwayRoute rr, String place) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		try {
			con = ds.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append(SQL_UPDATE_PLACE);
			int temp = 0;
			if ("compartment train".equals(place)) {
				sb.append("free_place_type1");
				temp = rr.getFree_place_type1() - 1;
			}
			if ("sleeper train".equals(place)) {
				sb.append("free_place_type2");
				temp = rr.getFree_place_type2() - 1;
			}
			if ("train carriage".equals(place)) {
				sb.append("free_place_type3");
				temp = rr.getFree_place_type3() - 1;
			}
			sb.append("=" + temp);
			sb.append(" WHERE id_railway_route=");
			sb.append(rr.getId_railway_route());
			pstmt = con.prepareStatement(sb.toString());
			pstmt.executeUpdate();	
		} catch (SQLException e) {
			LOG.error("error updating route locations" + METHOD_NAME + "updatePlace",e);
		} finally {
			closeResurs(con,pstmt,rs);
		}
	}
	
	/**
	 * Removes a station from the route.
	 * @param id_route
	 * 			Railway route id
	 * @param station
	 * 			Station name
	 */
	public void DeleteStationFrowRoute(int id_route , String station) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int st = Integer.valueOf(station.replace("A", ""));
		try {
			con = ds.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append(SQL_DELETE_STATION_FROM_ROUTE);
			sb.append(id_route);
			sb.append(" AND station_id_station=");
			sb.append(st);
			pstmt = con.prepareStatement(sb.toString());
			pstmt.executeUpdate();	
		} catch (SQLException e) {
			LOG.error("error deleting station from route" + METHOD_NAME + "DeleteStationFrowRoute",e);
		} finally {
			closeResurs(con,pstmt,rs);
		}	
	}
	
	/**
	 * Updates station stop time.
	 * @param id_route
	 * 			Railway route id
	 * @param min
	 * 			Minutes
	 * @param hour
	 * 			Hour
	 * @param station 
	 * 			Station name
	 */
	public void updateStopTimeStation(int id_route, int min, int hour, String station) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int st = Integer.valueOf(station.replace("A", ""));
		try {
			con = ds.getConnection();
			StringBuilder sb = new StringBuilder();
			sb.append(SQL_UPDATE_STOP_TIME_STATION);
			sb.append("'" + hour + ":" + min + ":" + "00'");
			sb.append(" WHERE railway_route_id_railway_route=" + id_route);
			sb.append(" AND station_id_station=" + st);
			pstmt = con.prepareStatement(sb.toString());
			pstmt.executeUpdate();	
		} catch (SQLException e) {
			LOG.error("error updating stop time" + METHOD_NAME + "updateStopTimeStation",e);
		} finally {
			closeResurs(con,pstmt,rs);
		}
	}
	
	/**
	 * Adds a station to the route and sets the stop time.
	 * 
	 * @param id_route
	 * 			Railway route id
	 * @param min
	 * 			Minutes
	 * @param hour
	 * 			Hour
	 * @param station 
	 * 			Station name
	 */
	public void addStationToRoute(int id_route, int min, int hour, String station) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		int st = Integer.valueOf(station.replace("A", ""));
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(
					SQL_INSERT_STATION_TO_ROUTE, Statement.RETURN_GENERATED_KEYS);
			int k = 1;
			pstmt.setInt(k++, st);
			pstmt.setInt(k++, id_route);
			Time time = new Time(hour-1, min, 0);
			pstmt.setTime(k++, time);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			LOG.error("error adding station to route" + METHOD_NAME + "addStationToRoute",e);
		} finally {
			closeResurs(con,pstmt,rs);
		}
	}
}

