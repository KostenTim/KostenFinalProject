package ua.nure.kosten.FinalTast.db.entity;

import java.sql.Date;
import java.sql.Time;

import ua.nure.kosten.FinalTast.db.DBManager;

public class RailwayRoute {

	private int id_railway_route;
	private int id_train;
	private Date start_way_date;
	private Time start_way_time;
	
	private int free_place_type1;
	private int free_place_type2;
	private int free_place_type3;
	private String nameTrain;
	private String start;
	private String end;
	
	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public RailwayRoute(int id_railway_route, int id_train, Date start_way_date, Time start_way_time,
			int free_place_type1, int free_place_type2, int free_place_type3) {
		this.id_railway_route = id_railway_route;
		this.id_train = id_train;
		this.start_way_date = start_way_date;
		this.start_way_time = start_way_time;
		this.free_place_type1 = free_place_type1;
		this.free_place_type2 = free_place_type2;
		this.free_place_type3 = free_place_type3;
		this.nameTrain = DBManager.getInstance().nameTrain(id_railway_route);
		this.start = start_way_date.toString() + " " + start_way_time.toString();
		TimeStation st = new TimeStation(this, "A8");
		this.end = st.getTime_of_arrival().toString();
	}
	
	public int getId_railway_route() {
		return id_railway_route;
	}
	public void setId_railway_route(int id_railway_route) {
		this.id_railway_route = id_railway_route;
	}
	public int getId_train() {
		return id_train;
	}
	public void setId_train(int id_train) {
		this.id_train = id_train;
	}
	public Date getStart_way_date() {
		return start_way_date;
	}
	public void setStart_way_date(Date start_way_date) {
		this.start_way_date = start_way_date;
	}
	public Time getStart_way_time() {
		return start_way_time;
	}
	public void setStart_way_time(Time start_way_time) {
		this.start_way_time = start_way_time;
	}
	public int getFree_place_type1() {
		return free_place_type1;
	}
	public void setFree_place_type1(int free_place_type1) {
		this.free_place_type1 = free_place_type1;
	}
	public int getFree_place_type2() {
		return free_place_type2;
	}
	public void setFree_place_type2(int free_place_type2) {
		this.free_place_type2 = free_place_type2;
	}
	public int getFree_place_type3() {
		return free_place_type3;
	}
	public String getNameTrain() {
		return nameTrain;
	}

	public void setNameTrain(String nameTrain) {
		this.nameTrain = nameTrain;
	}

	public void setFree_place_type3(int free_place_type3) {
		this.free_place_type3 = free_place_type3;
	}

	@Override
	public String toString() {
		return "RailwayRoute [id_railway_route=" + id_railway_route + ", id_train=" + id_train + ", start_way_date="
				+ start_way_date + ", start_way_time=" + start_way_time + ", free_place_type1=" + free_place_type1
				+ ", free_place_type2=" + free_place_type2 + ", free_place_type3=" + free_place_type3 + "]";
	}
	
}
