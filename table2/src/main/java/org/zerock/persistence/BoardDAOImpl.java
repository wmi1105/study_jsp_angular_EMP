package org.zerock.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {

  @Inject
  private SqlSession session;

  private static String namespace = "org.zerock.mapper.BoardMapper";

  @Override
  public void create(BoardVO vo) throws Exception {
    session.insert(namespace + ".create", vo);
  }

  @Override
  public BoardVO read(Integer bno) throws Exception {
    return session.selectOne(namespace + ".read", bno);
  }

  @Override
  public void update(BoardVO vo) throws Exception {
    session.update(namespace + ".update", vo);
  }

  @Override
  public void delete(Integer bno) throws Exception {
    session.delete(namespace + ".delete", bno);
  }

  @Override
  public List<BoardVO> listAll() throws Exception {
    return session.selectList(namespace + ".listAll");
  }

  @Override
  public List<BoardVO> listPage(int page) throws Exception {

    if (page <= 0) {
      page = 1;
    }

    page = (page - 1) * 10;

    return session.selectList(namespace + ".listPage", page);
  }

  @Override
  public List<BoardVO> listCriteria(Criteria cri) throws Exception {

    return session.selectList(namespace + ".listCriteria", cri);
  }

  @Override
  public int countPaging(Criteria cri) throws Exception {

    return session.selectOne(namespace + ".countPaging", cri);
  }

  @Override
  public List<BoardVO> listSearch(SearchCriteria cri) throws Exception {

    return session.selectList(namespace + ".listSearch", cri);
  }

  @Override
  public int listSearchCount(SearchCriteria cri) throws Exception {

    return session.selectOne(namespace + ".listSearchCount", cri);
  }

@Override  //파일업로드
public void addAttach(String fullName) throws Exception {
	// TODO Auto-generated method stub
	
	session.insert(namespace +".addAttach", fullName);
}

@Override //게시물 조회할때 첨부된 파일 목록 같이 보여주기
public List<String> getAttach(Integer bno) throws Exception {
	// TODO Auto-generated method stub
	return session.selectList(namespace +".getAttach",bno);
}

@Override
public void deleteAttach(Integer bno) throws Exception {
	// TODO Auto-generated method stub
	 session.delete(namespace+".deleteAttach",bno);
}

@Override
public void replaceAttach(String fullName, Integer bno) throws Exception {
	// TODO Auto-generated method stub
	Map<String, Object> paramMap = new HashMap<String,Object>();
	
	paramMap.put("bno",bno);
	paramMap.put("fullName", fullName);
	
	session.insert(namespace+".replaceAttach",paramMap);
}


}
