package org.zerock.domain;

public class CheckVO {

	private String checkIn;
	   private String checkOut;
	   private String checkDate;

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

	   public String getCheckDate() {
	      return checkDate;
	   }

	   public void setCheckDate(String checkDate) {
	      this.checkDate = checkDate;
	   }

	   @Override
	   public String toString() {
	      return "CheckVO [checkIn=" + checkIn + ", checkOut=" + checkOut + ", checkDate=" + checkDate + "]";
	   }

}
