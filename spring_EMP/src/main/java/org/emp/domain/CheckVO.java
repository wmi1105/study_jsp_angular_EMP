package org.emp.domain;

import java.sql.Timestamp;

public class CheckVO {

	private String checkIn;
	private String checkOut;
	private Timestamp checkDate;

	public String getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public Timestamp getCheckDate() {
		return checkDate;
	}

	public void setCheckDate(Timestamp checkDate) {
		this.checkDate = checkDate;
	}

	@Override
	public String toString() {
		return "CheckVO [checkIn=" + checkIn + ", checkOut=" + checkOut + ", checkDate=" + checkDate + "]";
	}

}
