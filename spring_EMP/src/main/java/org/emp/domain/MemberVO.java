package org.emp.domain;

public class MemberVO {

	private int mid; // user id
	private String mpw; // user pw
	private String mname; // user name
	private String mimg; // user img
	private String mdp; // user department
	private String mphone; // user phone number
	private String mmail; // user email

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public String getMpw() {
		return mpw;
	}

	public void setMpw(String mpw) {
		this.mpw = mpw;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getMphone() {
		return mphone;
	}

	public void setMphone(String mphone) {
		this.mphone = mphone;
	}

	public String getMmail() {
		return mmail;
	}

	public void setMmail(String mmail) {
		this.mmail = mmail;
	}

	@Override
	public String toString() {
		return "MemberDTO [mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mimg=" + mimg + ", mdp=" + mdp
				+ ", mphone=" + mphone + ", mmail=" + mmail + "]";
	}

}
