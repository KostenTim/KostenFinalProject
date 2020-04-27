package ua.nure.kosten.FinalTast.db.entity;

import java.sql.Time;

public class Station {

	private int id_station;
	private String name;
	private Time time_to_station;
	
	public Station(int id_station, String name, Time time_to_station) {
		this.id_station = id_station;
		this.name = name;
		this.time_to_station = time_to_station;
	}

	public int getId_station() {
		return id_station;
	}

	public void setId_station(int id_station) {
		this.id_station = id_station;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Time getTime_to_station() {
		return time_to_station;
	}

	public void setTime_to_station(Time time_to_station) {
		this.time_to_station = time_to_station;
	}

	@Override
	public String toString() {
		return "Station [id_station=" + id_station + ", name=" + name + ", time_to_station=" + time_to_station + "]";
	}
	
	
}