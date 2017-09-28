package org.zerock.service;

import java.util.Date;

import org.zerock.domain.CheckVO;
import org.zerock.domain.MemberVO;
import org.zerock.dto.LoginDTO;

public interface MemberService {
	public void regist(MemberVO member) throws Exception;

	public MemberVO giveID(MemberVO member) throws Exception;

	public MemberVO login(LoginDTO dto) throws Exception;

	public void keepLogin(Integer MID, String sessionId, Date next) throws Exception;

	public MemberVO checkLoginBefore(String value);
	
	public CheckVO checkIn(int mid) throws Exception;
	
	public CheckVO checkOut(int mid) throws Exception;
}
