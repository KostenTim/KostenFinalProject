package ua.nure.kosten.FinalTast.db.entity;


import ua.nure.kosten.FinalTast.DateTime;
import ua.nure.kosten.FinalTast.db.DBManager;

public class WayShowForUser {
	
	private String rain_number;
	private DateTime start;
	private String start_station;
	private int min_travel;
	private DateTime end;
	private String end_station;
	private int free_place_type1;
	private int cost_type1;
	private int free_place_type2;
	private int cost_type2;
	private int free_place_type3;
	private int cost_type3;
	
	public WayShowForUser(RailwayRoute rr , String station1, String station2) {
		this.rain_number = DBManager.getInstance().nameTrain(rr.getId_train());
		TimeStation st = new TimeStation(rr, station1);
		this.start = st.getDeparture_time();
		this.start_station = station1;	
		TimeStation st2 = new TimeStation(rr, station2);
		this.end = st2.getTime_of_arrival();
		this.min_travel = DateTime.minus(end,start);
		this.end_station = station2;
		this.free_place_type1 = rr.getFree_place_type1();
		this.cost_type1 = min_travel / 3 * 3;
		this.free_place_type2 = rr.getFree_place_type2();
		this.cost_type2 = min_travel / 3 * 2;
		this.free_place_type3 = rr.getFree_place_type3();
		this.cost_type3 = min_travel / 3;	
	}

	@Override
	public String toString() {
		return "WayShowForUser [rain_number=" + rain_number + ", start=" + start + ", start_station=" + start_station
				+ ", min_travel=" + min_travel + ", end=" + end + ", end_station=" + end_station + ", free_place_type1="
				+ free_place_type1 + ", cost_type1=" + cost_type1 + ", free_place_type2=" + free_place_type2
				+ ", cost_type2=" + cost_type2 + ", free_place_type3=" + free_place_type3 + ", cost_type3=" + cost_type3
				+ "]";
	}

	public String getRain_number() {
		return rain_number;
	}

	public void setRain_number(String rain_number) {
		this.rain_number = rain_number;
	}

	public DateTime getStart() {
		return start;
	}

	public void setStart(DateTime start) {
		this.start = start;
	}

	public String getStart_station() {
		return start_station;
	}

	public void setStart_station(String start_station) {
		this.start_station = start_station;
	}

	public int getMin_travel() {
		return min_travel;
	}

	public void setMin_travel(int min_travel) {
		this.min_travel = min_travel;
	}

	public DateTime getEnd() {
		return end;
	}

	public void setEnd(DateTime end) {
		this.end = end;
	}

	public String getEnd_station() {
		return end_station;
	}

	public void setEnd_station(String end_station) {
		this.end_station = end_station;
	}

	public int getFree_place_type1() {
		return free_place_type1;
	}

	public void setFree_place_type1(int free_place_type1) {
		this.free_place_type1 = free_place_type1;
	}

	public int getCost_type1() {
		return cost_type1;
	}

	public void setCost_type1(int cost_type1) {
		this.cost_type1 = cost_type1;
	}

	public int getFree_place_type2() {
		return free_place_type2;
	}

	public void setFree_place_type2(int free_place_type2) {
		this.free_place_type2 = free_place_type2;
	}

	public int getCost_type2() {
		return cost_type2;
	}

	public void setCost_type2(int cost_type2) {
		this.cost_type2 = cost_type2;
	}

	public int getFree_place_type3() {
		return free_place_type3;
	}

	public void setFree_place_type3(int free_place_type3) {
		this.free_place_type3 = free_place_type3;
	}

	public int getCost_type3() {
		return cost_type3;
	}

	public void setCost_type3(int cost_type3) {
		this.cost_type3 = cost_type3;
	}
	
}
