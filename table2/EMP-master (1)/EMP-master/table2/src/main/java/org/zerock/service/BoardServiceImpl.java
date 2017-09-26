package org.zerock.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.SearchCriteria;
import org.zerock.persistence.BoardDAO;


@Service		//스프링 빈으로 인식
public class BoardServiceImpl implements BoardService{

	@Inject
	private BoardDAO dao;
	
	@Transactional  //BoardDAO의 create()와 addAttach()를 연속으로 사용하기 위해 트랜잭션 사용
	@Override //insert작업과 tbl_attach테이블에 첨부파일의 이름이 함께 등록되는 작업
	  public void regist(BoardVO board) throws Exception {
	  
	    dao.create(board);
	    
	    String[] files = board.getFiles();
	    
	    if(files == null) { return; } 
	    
	    for (String fileName : files) {
	      dao.addAttach(fileName);
	    }   
	  }

	@Override
	public BoardVO read(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.read(bno);
	}

	 @Transactional //원래의 게시물 수정 + 기존 첨부파일 목록 삭제 + 새로운 첨부파일 정보 입력
	 @Override
	  public void modify(BoardVO board) throws Exception {
	    dao.update(board);
	    
	    Integer bno = board.getBno();
	    
	    dao.deleteAttach(bno);
	    
	    String[] files = board.getFiles();
	    
	    if(files == null) { return; } 
	    
	    for (String fileName : files) {
	      dao.replaceAttach(fileName, bno);
	    }
	  }

	 @Transactional //두개의 데이터베이스 참조 ->반드시 첨부파일과 관련된 정보부터 삭제하고,게시글을 삭제
	  @Override
	  public void remove(Integer bno) throws Exception {
	    dao.deleteAttach(bno);
	    dao.delete(bno);
	  } 

	@Override
	public List<BoardVO> listAll() throws Exception {
		// TODO Auto-generated method stub
		return dao.listAll();
	}

	@Override
	public List<BoardVO> listCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.listCriteria(cri);
	}

	@Override
	public int listCountCriteria(Criteria cri) throws Exception {
		// TODO Auto-generated method stub
		return dao.countPaging(cri);
	}
	 @Override
	  public List<BoardVO> listSearchCriteria(SearchCriteria cri) throws Exception {

	    return dao.listSearch(cri);
	  }

	  @Override
	  public int listSearchCount(SearchCriteria cri) throws Exception {

	    return dao.listSearchCount(cri);
	  }

	@Override
	public List<String> getAttach(Integer bno) throws Exception {
		// TODO Auto-generated method stub
		return dao.getAttach(bno);
	}
	  
	  
}
