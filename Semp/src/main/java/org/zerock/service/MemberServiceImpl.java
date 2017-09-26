package org.zerock.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.zerock.domain.MemberVO;
import org.zerock.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{

	@Inject
	MemberDAO dao;
	
	@Override
	public void regist(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		dao.create(member);
	}

	@Override
	public MemberVO giveID(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		return dao.giveId(member);
	}

}
