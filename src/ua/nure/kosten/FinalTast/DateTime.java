package ua.nure.kosten.FinalTast;

import java.sql.Date;
import java.sql.Time;

public class DateTime {
	Date date;
	Time time;

	public DateTime(Date date, Time time) {
		this.date = date;
		this.time = time;
	}
	@Override
	public String toString() {
		return   date + " " + time;
	}
	public void plus(DateTime dt) {
		int min = this.time.getMinutes();
		int hours = this.time.getHours();
		int day = this.date.getDate();
		int mounth = this.date.getMonth();
		int year = this.date.getYear();
		min += dt.time.getMinutes();
		while (min >= 60) {
			min-= 60;
			hours++;
		}
		hours += dt.time.getHours();
		while ( hours >= 24) {
			hours-=24;
			day++;	
		}
		this.date = new Date (year , mounth, day);
		this.time = new Time (hours, min, 0);
	}
	public void plus(Time t) {
		int min = this.time.getMinutes();
		int hours = this.time.getHours();
		int day = this.date.getDate();
		int mounth = this.date.getMonth();
		int year = this.date.getYear();
		min += t.getMinutes();
		while (min >= 60) {
			min-= 60;
			hours++;
		}
		hours += t.getHours();
		while ( hours >= 24) {
			hours-=24;
			day++;	
		}
		this.date = new Date (year , mounth, day);
		this.time = new Time (hours, min, 0);
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}

	public static int minus(DateTime td1 , DateTime td2) {
		int hours1 = td1.getTime().getHours();
		int hours2 = td2.getTime().getHours();
		int min1 = td1.getTime().getMinutes();
		int min2 = td2.getTime().getMinutes();
		int day1 = td1.getDate().getDate();
		int day2 = td2.getDate().getDate();
		min1 += hours1*60;
		min2 += hours2*60;
		int result = min1-min2;
		while (day1>day2) {
			result += 24*60;
			day2++;
		}
		return result;
	}
}
