package org.zerock.domain;

public class MemberVO {

	private Integer MID;
	private String MPW;
	private String MNAME;
	private String MIMG;
	private String MDP;
	private String MPHONE;
	private String MMAIL;
	public Integer getMID() {
		return MID;
	}
	public void setMID(Integer mID) {
		MID = mID;
	}
	public String getMPW() {
		return MPW;
	}
	public void setMPW(String mPW) {
		MPW = mPW;
	}
	public String getMNAME() {
		return MNAME;
	}
	public void setMNAME(String mNAME) {
		MNAME = mNAME;
	}
	public String getMIMG() {
		return MIMG;
	}
	public void setMIMG(String mIMG) {
		MIMG = mIMG;
	}
	public String getMDP() {
		return MDP;
	}
	public void setMDP(String mDP) {
		MDP = mDP;
	}
	public String getMPHONE() {
		return MPHONE;
	}
	public void setMPHONE(String mPHONE) {
		MPHONE = mPHONE;
	}
	public String getMMAIL() {
		return MMAIL;
	}
	public void setMMAIL(String mMAIL) {
		MMAIL = mMAIL;
	}
	@Override
	public String toString() {
		return "MemberVO [MID=" + MID + ", MPW=" + MPW + ", MNAME=" + MNAME + ", MIMG=" + MIMG + ", MDP=" + MDP
				+ ", MPHONE=" + MPHONE + ", MMAIL=" + MMAIL + "]";
	}
	
	
	
}
