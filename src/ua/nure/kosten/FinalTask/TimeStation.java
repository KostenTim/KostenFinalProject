package ua.nure.kosten.FinalTask;

import java.sql.Time;

import ua.nure.kosten.FinalTask.DateTime;
import ua.nure.kosten.FinalTask.db.DBManager;
import ua.nure.kosten.FinalTask.db.entity.RailwayRoute;

/**
 * This class is used to form the date
 * and time of departure and arrival
 * of the train at the station of the route.
 * 
 * @author T.Kosten
 * 
 */

public class TimeStation {
	private DateTime time_of_arrival;
	private Time stop_time;
	private DateTime departure_time;
	private String nameStation;

	public TimeStation(RailwayRoute rr , String station) {
		this.nameStation = station;
		int id_station = Integer.valueOf(station.replace("A", ""));
		this.time_of_arrival = new DateTime (rr.getStart_way_date(), rr.getStart_way_time());
		for ( int i = 1 ; i <= id_station ; i ++) {
			if (i == id_station) {
				this.time_of_arrival.plus(DBManager.getInstance().TimeToStationById(i));
			} else {
				this.time_of_arrival.plus(DBManager.getInstance().TimeToStationById(i));
				this.time_of_arrival.plus(DBManager.getInstance().StopTimeStationsInWay(rr.getId_railway_route(), i));
			}		
		}
		this.stop_time = DBManager.getInstance().StopTimeStationsInWay(rr.getId_railway_route(), id_station);
		this.departure_time = new DateTime (this.time_of_arrival.getDate(), this.time_of_arrival.getTime());
		this.departure_time.plus(this.stop_time);

	}
	
	@Override
	public String toString() {
		return "TimeStation [time_of_arrival=" + time_of_arrival + ", stop_time=" + stop_time + ", departure_time="
				+ departure_time + ", NameStation=" + nameStation + "]";
	}

	public DateTime getTime_of_arrival() {
		return time_of_arrival;
	}
	public void setTime_of_arrival(DateTime time_of_arrival) {
		this.time_of_arrival = time_of_arrival;
	}
	public Time getStop_time() {
		return stop_time;
	}
	public void setStop_time(Time stop_time) {
		this.stop_time = stop_time;
	}
	public DateTime getDeparture_time() {
		return departure_time;
	}
	public void setDeparture_time(DateTime departure_time) {
		this.departure_time = departure_time;
	}
	public String getNameStation() {
		return nameStation;
	}
	public void setNameStation(String nameStation) {
		this.nameStation = nameStation;
	}
}
