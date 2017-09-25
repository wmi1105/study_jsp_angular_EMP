package org.emp.persistence;

import org.emp.domain.CheckVO;
import org.emp.domain.MemberVO;

public interface MemberDAO {

	public void login(MemberVO member) throws Exception;
	public String join(MemberVO member) throws Exception;
	
	//출.결근 체크
	public void checkIn(int mid) throws Exception;
	public void checkOut(int mid) throws Exception;
	
	
}
