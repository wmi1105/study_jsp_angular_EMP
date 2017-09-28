package org.zerock.controller;

import java.util.Date;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public void loginGET(@ModelAttribute("dto") LoginDTO dto) {

	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String login(Model model) {

		return "/include/index";
	}

	@RequestMapping(value = "/mregister", method = RequestMethod.GET)
	public String registGET() throws Exception {

		return "/include/register";

	}

	@RequestMapping(value = "/mregister", method = RequestMethod.POST)
	public String registPOST(MemberVO member, RedirectAttributes rttr, Model model) throws Exception {

		service.regist(member);

		System.out.println(member);
		MemberVO vo = service.giveID(member);
		System.out.println(vo);
		int mid = vo.getMID();
		System.out.println(mid);
		// rttr.addFlashAttribute("msg", "SUCCESS");
		model.addAttribute("giveId", mid);

		return "/include/giveID";
	}

	@RequestMapping(value = "/loginPost", method = RequestMethod.POST)
	public void loginPOST(LoginDTO dto, HttpSession session, Model model) throws Exception {

		MemberVO vo = service.login(dto);

		System.out.println("index: " + vo);
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
