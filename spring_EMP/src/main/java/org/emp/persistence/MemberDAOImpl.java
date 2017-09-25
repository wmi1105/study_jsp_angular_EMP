package org.emp.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.emp.domain.CheckVO;
import org.emp.domain.MemberVO;

public class MemberDAOImpl implements MemberDAO{

	@Inject
	private SqlSession session;

	private static String namespace = "org.emp.mapper.MemberMapper";
	
	@Override
	public void login(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
//		session.select(namespace+".login", member);
	}

	@Override
	public String join(MemberVO member) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void checkIn(int mid) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".checkIn", mid);
	}

	@Override
	public void checkOut(int mid) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace+".checkOut", mid);
	}

}
