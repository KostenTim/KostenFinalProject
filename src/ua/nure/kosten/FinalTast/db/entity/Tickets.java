package ua.nure.kosten.FinalTast.db.entity;

import ua.nure.kosten.FinalTast.db.DBManager;

public class Tickets {
	private int id_ticket;
	private int users_id;
	private int id_railway_route;
	private int cost;
	private String start_station;
	private String final_station;
	private String start_travel;
	private String end_travel;
	private String place_type;
	private String trainName;
	
	public Tickets(int id_ticket, int users_id, int id_railway_route, int cost, String start_station,
			String final_station, String start_travel, String end_travel, String place_type) {
		this.id_ticket = id_ticket;
		this.users_id = users_id;
		this.id_railway_route = id_railway_route;
		this.cost = cost;
		this.start_station = start_station;
		this.final_station = final_station;
		this.start_travel = start_travel;
		this.end_travel = end_travel;
		this.place_type = place_type;
		this.trainName = DBManager.getInstance().nameTrain(DBManager.getInstance().idTrainByIdWay(id_railway_route));
	}

	public int getId_ticket() {
		return id_ticket;
	}

	public void setId_ticket(int id_ticket) {
		this.id_ticket = id_ticket;
	}

	public int getUsers_id() {
		return users_id;
	}

	public void setUsers_id(int users_id) {
		this.users_id = users_id;
	}

	public int getId_railway_route() {
		return id_railway_route;
	}

	public void setId_railway_route(int id_railway_route) {
		this.id_railway_route = id_railway_route;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getStart_station() {
		return start_station;
	}

	public void setStart_station(String start_station) {
		this.start_station = start_station;
	}

	public String getFinal_station() {
		return final_station;
	}

	public void setFinal_station(String final_station) {
		this.final_station = final_station;
	}

	public String getStart_travel() {
		return start_travel;
	}

	public void setStart_travel(String start_travel) {
		this.start_travel = start_travel;
	}

	public String getEnd_travel() {
		return end_travel;
	}

	public void setEnd_travel(String end_travel) {
		this.end_travel = end_travel;
	}

	public String getPlace_type() {
		return place_type;
	}

	public void setPlace_type(String place_type) {
		this.place_type = place_type;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	@Override
	public String toString() {
		return "Tickets [id_ticket=" + id_ticket + ", users_id=" + users_id + ", id_railway_route=" + id_railway_route
				+ ", cost=" + cost + ", start_station=" + start_station + ", final_station=" + final_station
				+ ", start_travel=" + start_travel + ", end_travel=" + end_travel + ", place_type=" + place_type
				+ ", trainName=" + trainName + "]";
	}
	
	
}