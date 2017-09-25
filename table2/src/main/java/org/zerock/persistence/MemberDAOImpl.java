package org.zerock.persistence;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.MemberVO;
import org.zerock.dto.LoginDTO;

@Repository
public class MemberDAOImpl implements MemberDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace="org.zerock.mapper.MemberMapper";
	
	@Override
	public MemberVO login(LoginDTO dto) throws Exception {
		// TODO Auto-generated method stub
		return session.selectOne(namespace+".login",dto);
	}

	@Override
	public void keepLogin(Integer MID, String sessionId, Date next) {
		// TODO Auto-generated method stub
		 Map<String, Object> paramMap = new HashMap<String, Object>();
		    paramMap.put("MID", MID);
		    paramMap.put("sessionId", sessionId);
		    paramMap.put("next", next);
		    
		    session.update(namespace+".keepLogin", paramMap);
		    
		
	}
	

	@Override
	public MemberVO checkMemberWithSessionKey(String value) {
		// TODO Auto-generated method stub
		return session.selectOne(namespace +".checkUserWithSessionKey", value);
	}



	
}
