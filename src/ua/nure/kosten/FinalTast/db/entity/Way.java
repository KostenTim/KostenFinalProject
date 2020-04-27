package ua.nure.kosten.FinalTast.db.entity;

public class Way {

	private int id_way;
	
	private int stop_time_1staton_min;
	private int stop_time_2staton_min;
	private int stop_time_3staton_min;
	private int stop_time_4staton_min;
	private int stop_time_5staton_min;
	private int stop_time_6staton_min;
	private int stop_time_7staton_min;
	private int stop_time_8staton_min;
	
	public Way(int id_way, int stop_time_1staton_min, int stop_time_2staton_min, int stop_time_3staton_min,
			int stop_time_4staton_min, int stop_time_5staton_min, int stop_time_6staton_min, int stop_time_7staton_min,
			int stop_time_8staton_min) {
		this.id_way = id_way;
		this.stop_time_1staton_min = stop_time_1staton_min;
		this.stop_time_2staton_min = stop_time_2staton_min;
		this.stop_time_3staton_min = stop_time_3staton_min;
		this.stop_time_4staton_min = stop_time_4staton_min;
		this.stop_time_5staton_min = stop_time_5staton_min;
		this.stop_time_6staton_min = stop_time_6staton_min;
		this.stop_time_7staton_min = stop_time_7staton_min;
		this.stop_time_8staton_min = stop_time_8staton_min;
	}

	public int getId_way() {
		return id_way;
	}

	public void setId_way(int id_way) {
		this.id_way = id_way;
	}

	public int getStop_time_1staton_min() {
		return stop_time_1staton_min;
	}

	public void setStop_time_1staton_min(int stop_time_1staton_min) {
		this.stop_time_1staton_min = stop_time_1staton_min;
	}

	public int getStop_time_2staton_min() {
		return stop_time_2staton_min;
	}

	public void setStop_time_2staton_min(int stop_time_2staton_min) {
		this.stop_time_2staton_min = stop_time_2staton_min;
	}

	public int getStop_time_3staton_min() {
		return stop_time_3staton_min;
	}

	public void setStop_time_3staton_min(int stop_time_3staton_min) {
		this.stop_time_3staton_min = stop_time_3staton_min;
	}

	public int getStop_time_4staton_min() {
		return stop_time_4staton_min;
	}

	public void setStop_time_4staton_min(int stop_time_4staton_min) {
		this.stop_time_4staton_min = stop_time_4staton_min;
	}

	public int getStop_time_5staton_min() {
		return stop_time_5staton_min;
	}

	public void setStop_time_5staton_min(int stop_time_5staton_min) {
		this.stop_time_5staton_min = stop_time_5staton_min;
	}

	public int getStop_time_6staton_min() {
		return stop_time_6staton_min;
	}

	public void setStop_time_6staton_min(int stop_time_6staton_min) {
		this.stop_time_6staton_min = stop_time_6staton_min;
	}

	public int getStop_time_7staton_min() {
		return stop_time_7staton_min;
	}

	public void setStop_time_7staton_min(int stop_time_7staton_min) {
		this.stop_time_7staton_min = stop_time_7staton_min;
	}

	public int getStop_time_8staton_min() {
		return stop_time_8staton_min;
	}

	public void setStop_time_8staton_min(int stop_time_8staton_min) {
		this.stop_time_8staton_min = stop_time_8staton_min;
	}

	@Override
	public String toString() {
		return "Way [id_way=" + id_way + ", stop_time_1staton_min=" + stop_time_1staton_min + ", stop_time_2staton_min="
				+ stop_time_2staton_min + ", stop_time_3staton_min=" + stop_time_3staton_min
				+ ", stop_time_4staton_min=" + stop_time_4staton_min + ", stop_time_5staton_min="
				+ stop_time_5staton_min + ", stop_time_6staton_min=" + stop_time_6staton_min
				+ ", stop_time_7staton_min=" + stop_time_7staton_min + ", stop_time_8staton_min="
				+ stop_time_8staton_min + "]";
	}
	
}
