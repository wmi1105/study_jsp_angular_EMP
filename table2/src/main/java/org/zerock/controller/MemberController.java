package org.zerock.controller;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.WebUtils;
import org.zerock.domain.CheckVO;
import org.zerock.domain.MemberVO;
import org.zerock.dto.LoginDTO;
import org.zerock.service.MemberService;

@Controller
@RequestMapping("/include")
public class MemberController {

	@Inject
	private MemberService service;

	@RequestMapping(value = "/main")
	public String main() {
		return "include/main";
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String login(Model model) {

		return "/include/index";
	}

	@RequestMapping(value = "/memberinfo", method = RequestMethod.GET)
	public String memberinfo(HttpSession session, Model model) throws Exception {

		MemberVO vo = (MemberVO) session.getAttribute("login");
		System.out.println(vo.getMID());

		List<CheckVO> list = service.checkInfo(vo.getMID());
		System.out.println(list);

		model.addAttribute("list", list);

		return "/include/memberinfo";
	}

	@RequestMapping(value = "/mregister", method = RequestMethod.GET)
	public String registGET() throws Exception {

		return "/include/register";
	}

	@RequestMapping(value = "/mregister", method = RequestMethod.POST)
	public String registPOST(MemberVO member, RedirectAttributes rttr, Model model) throws Exception {

		service.regist(member);

		MemberVO vo = service.giveID(member);
		int mid = vo.getMID();
		// rttr.addFlashAttribute("msg", "SUCCESS");
		model.addAttribute("giveId", mid);

		return "/include/giveID";
	}

	// 관리자 로그인
	@RequestMapping(value = "/adminlogin", method = RequestMethod.GET)
	public String adminGET() {
		return "include/adminlogin";
	}

	@RequestMapping(value = "/adminlogin", method = RequestMethod.POST)
	public String adminPOST(LoginDTO dto, HttpSession session, Model model, HttpServletRequest request)
			throws Exception {

		MemberVO vo = service.login(dto);
		if (request.getParameter("MID").equals("2000") && request.getParameter("MPW").equals("123")) {
			session.setAttribute("login", vo);

			return "include/admin";
		} else {
			return "include/main";

		}

	}

	@RequestMapping(value = "/admininfo", method = RequestMethod.GET)
	public String admininfo(HttpSession session, Model model) throws Exception {

		MemberVO vo = (MemberVO) session.getAttribute("login");
		System.out.println(vo.getMID());

		List<MemberVO> list = service.listAll();
//		System.out.println(list);

		model.addAttribute("list", list);

		return "/include/admininfo";
	}
	
	@RequestMapping(value="/adminMemberInfo", method=RequestMethod.GET)
	public String adminMemberInfo(@RequestParam("MID") int mid, HttpSession session) throws Exception{
		
		MemberVO vo = new MemberVO();
		vo.setMID(mid);
		session.setAttribute("login", vo);
		return "redirect:/include/memberinfo";
	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model, HttpServletRequest request) throws Exception {

		MemberVO vo = service.login(dto);

		if (vo == null) {
			return;
		}

		model.addAttribute("memberVO", vo);

		// loginCookie 값이 유지되는 시간 정보를 데이터베이스에 저장
		if (dto.isUseCookie()) {

			int amount = 60 * 60 * 24 * 7;

			Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));

			service.keepLogin(vo.getMID(), session.getId(), sessionLimit);
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpServletResponse response, HttpSession session)
			throws Exception {

		Object obj = session.getAttribute("login");

		if (obj != null) {
			MemberVO vo = (MemberVO) obj;

			session.removeAttribute("login");
			session.invalidate();

			Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");

			if (loginCookie != null) {
				loginCookie.setPath("/");
				loginCookie.setMaxAge(0);
				response.addCookie(loginCookie);
				service.keepLogin(vo.getMID(), session.getId(), new Date());
			}
		}
		return "/include/main";
	}

	@RequestMapping(value = "/checkIn", method = RequestMethod.GET)
	public String checkIn(Model model, @RequestParam("MID") int MID) throws Exception {

		System.out.println(MID);
		CheckVO vo = service.checkIn(MID);

		model.addAttribute("time", vo.getCheckIn());
		model.addAttribute("state", "출근");

		return "/include/check_suc";
	}

	@RequestMapping(value = "/checkOut", method = RequestMethod.GET)
	public String checkOut(Model model, @RequestParam("MID") int MID) throws Exception {

		CheckVO vo = service.checkOut(MID);

		model.addAttribute("time", vo.getCheckOut());
		model.addAttribute("state", "퇴근");

		return "/include/check_suc";
	}

}
