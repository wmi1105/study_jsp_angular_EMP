package org.zerock.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Inject
	private SqlSession session;

	private static String namespace = "org.zerock.mapper.MemberMapper";

	@Override
	public void create(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		session.insert(namespace + ".create", vo);
		
	}

	@Override
	public MemberVO giveId(MemberVO vo) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".giveID", vo);
	}

}
