package org.zerock.persistence;

import java.util.Date;

import org.zerock.domain.MemberVO;
import org.zerock.dto.LoginDTO;
// 로그인할 떄 사용자의 아이디와 패스워드를 이용해서 사용자의 정보를 조회하는 sql문을 처리
public interface MemberDAO {

	public void create(MemberVO vo)throws Exception;
	
	public MemberVO login(LoginDTO dto)throws Exception;
	
	public void keepLogin(Integer MID, String sessionId, Date next);
	
	public MemberVO checkMemberWithSessionKey(String value);
	
	public MemberVO giveId(MemberVO vo)throws Exception;
}
