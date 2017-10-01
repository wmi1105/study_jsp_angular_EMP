package org.zerock.domain;

import java.sql.Date;
import java.sql.Time;

public class CheckVO {

	private Time checkIn;
	private Time checkOut;
	private Date checkDate;

	public Time getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Time checkIn) {
		this.checkIn = checkIn;
	}

	public Time getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Time checkOut) {
		this.checkOut = checkOut;
	}

	public Date getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Date checkDate) {
		this.checkDate = checkDate;
	}

	@Override
	public String toString() {
		return "CheckVO [checkIn=" + checkIn + ", checkOut=" + checkOut + ", checkDate=" + checkDate + "]";
	}

}
