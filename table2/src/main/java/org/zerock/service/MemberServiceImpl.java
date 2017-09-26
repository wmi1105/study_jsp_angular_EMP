package org.zerock.service;

import java.util.Date;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.MemberVO;
import org.zerock.dto.LoginDTO;
import org.zerock.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;
	
	@Override
	public MemberVO login(LoginDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.login(dto);
	}

	@Override
	public void keepLogin(Integer MID, String sessionId, Date next) throws Exception {
		// TODO Auto-generated method stub
		dao.keepLogin(MID, sessionId, next);
	}

	@Override
	public MemberVO checkLoginBefore(String value) {
		// TODO Auto-generated method stub
		return dao.checkMemberWithSessionKey(value);
	}

	@Override
	public void regist(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		dao.create(member);
	}

}
