package org.zerock.service;

import java.util.Date;
import java.util.List;

import org.zerock.domain.BoardVO;
import org.zerock.domain.CheckVO;
import org.zerock.domain.MemberVO;
import org.zerock.dto.LoginDTO;

public interface MemberService {
	public void regist(MemberVO member) throws Exception;
	
	public MemberVO login(LoginDTO dto) throws Exception;
	
	public void keepLogin(Integer MID, String sessionId, Date next)throws Exception;
	
	public MemberVO checkLoginBefore(String value);
	
	public MemberVO giveID(MemberVO member) throws Exception;
    //출퇴근
	public CheckVO checkIn(int MID) throws Exception;
		
    public CheckVO checkOut(int MID) throws Exception;
    
    public List<CheckVO> checkInfo(int MID) throws Exception;
}
