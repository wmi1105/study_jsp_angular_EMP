package org.zerock.persistence;

import org.zerock.domain.MemberVO;
// 로그인할 떄 사용자의 아이디와 패스워드를 이용해서 사용자의 정보를 조회하는 sql문을 처리
public interface MemberDAO {

	public void create(MemberVO vo)throws Exception;
	public MemberVO giveId(MemberVO vo)throws Exception;
}
