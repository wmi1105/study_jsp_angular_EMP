package org.zerock.service;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.CheckVO;
import org.zerock.domain.MemberVO;
import org.zerock.dto.LoginDTO;
import org.zerock.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;
	
	
	//로그인
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

	
	//회원가입
	@Override
	public void regist(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		dao.create(member);
	}

	//회원가입 후 사번 부여
	@Override
	public MemberVO giveID(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		return dao.giveId(member);
	}
	
	 //출퇴근
	@Override
	public CheckVO checkIn(int MID) throws Exception {
		// TODO Auto-generated method stub
		 return dao.checkIn(MID);
	}

	@Override
	public CheckVO checkOut(int MID) throws Exception {
		// TODO Auto-generated method stub
		 return dao.checkOut(MID);
	}

	@Override
	public List<CheckVO> checkInfo(int MID) throws Exception {
		// TODO Auto-generated method stub
		return dao.checkInfo(MID);
	}

	@Override
	public List<CheckVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		 return dao.listAll();
	}

	

	
	
}
