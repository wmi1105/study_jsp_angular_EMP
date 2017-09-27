package org.zerock.domain;

import java.sql.Timestamp;

public class CheckVO {

	private Timestamp checkIn;
	private Timestamp checkOut;
	private Timestamp checkDate;

	public Timestamp getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(Timestamp checkIn) {
		this.checkIn = checkIn;
	}

	public Timestamp getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(Timestamp checkOut) {
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
