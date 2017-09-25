package org.zerock.service;

import java.util.Date;

import org.zerock.domain.MemberVO;
import org.zerock.dto.LoginDTO;

public interface MemberService {
	
	public MemberVO login(LoginDTO dto) throws Exception;
	
	public void keepLogin(Integer MID, String sessionId, Date next)throws Exception;
	
	public MemberVO checkLoginBefore(String value);
}
