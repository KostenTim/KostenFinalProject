package ua.nure.kosten.FinalTast.db.entity;

public class Trains {

	private int id_train;
	private String name;
	
	public Trains(int id_train, String name) {
		this.id_train = id_train;
		this.name = name;
	}
	public int getId_train() {
		return id_train;
	}
	public void setId_train(int id_train) {
		this.id_train = id_train;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Trains [id_train=" + id_train + ", name=" + name + "]";
	}
	
}
