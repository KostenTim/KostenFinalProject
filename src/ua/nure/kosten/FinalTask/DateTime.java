package ua.nure.kosten.FinalTask;

import java.sql.Date;
import java.sql.Time;

/**
 * This class is used to process data of type DATE and TIME.
 * 
 * @author t.Kosten
 * 
 */

public class DateTime {
	Date date;
	Time time;

	public DateTime(Date date, Time time) {
		this.date = date;
		this.time = time;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateTime other = (DateTime) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return   date + " " + time;
	}

	/**
	 * Method adds time to DateTime.
	 * @param t
	 * 			Time
	 */
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
	
	/**
	 * The static method returns the time difference of two dates in minutes.
	 * 
	 * @param td1
	 * 			DateTime one
	 * @param td2
	 * 			DateTime two
	 * 
	 * @return  Time in minutes
	 * 	
	 */
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
}
