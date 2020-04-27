package ua.nure.kosten.FinalTast.db.entity;

public class Carriages {

	private int id_carriages;
	private String carriages_name;
	private int max_place;
	private int cost_factor;
	
	public Carriages(int id_carriages, String carriages_name, int max_place, int cost_factor) {
		this.id_carriages = id_carriages;
		this.carriages_name = carriages_name;
		this.max_place = max_place;
		this.cost_factor = cost_factor;
	}

	public int getId_carriages() {
		return id_carriages;
	}

	public void setId_carriages(int id_carriages) {
		this.id_carriages = id_carriages;
	}

	public String getCarriages_name() {
		return carriages_name;
	}

	public void setCarriages_name(String carriages_name) {
		this.carriages_name = carriages_name;
	}

	public int getMax_place() {
		return max_place;
	}

	public void setMax_place(int max_place) {
		this.max_place = max_place;
	}

	public int getCost_factor() {
		return cost_factor;
	}

	public void setCost_factor(int cost_factor) {
		this.cost_factor = cost_factor;
	}
	
}
