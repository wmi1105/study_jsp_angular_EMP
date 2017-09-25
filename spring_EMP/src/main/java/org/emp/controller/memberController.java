package org.emp.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.emp.domain.MemberVO;
import org.emp.persistence.MemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class memberController {
	MemberDAO dao;
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value="/loginChk", method=RequestMethod.POST)
	public String loginChk(MemberVO vo){
		
	return "/index";
	}
	
	@RequestMapping(value="/checkIn", method=RequestMethod.GET)
	public void checkIn(@RequestParam("mid") int mid) throws Exception{
		dao.checkIn(mid);
	}

}
