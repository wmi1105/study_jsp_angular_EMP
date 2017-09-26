package org.zerock.dto;
//화면에서 전달하는 데이터를 수집하는 용도
public class LoginDTO {
	
	private Integer MID;
	private String MPW;
	private boolean useCookie;
	
	public String getMPW() {
		return MPW;
	}
	public void setMPW(String mPW) {
		MPW = mPW;
	}
	public boolean isUseCookie() {
		return useCookie;
	}
	public void setUseCookie(boolean useCookie) {
		this.useCookie = useCookie;
	}
	public Integer getMID() {
		return MID;
	}
	public void setMID(Integer mID) {
		MID = mID;
	}
	@Override
	public String toString() {
		return "LoginDTO [MID=" + MID + ", MPW=" + MPW + ", useCookie=" + useCookie + "]";
	}
		
	
}
