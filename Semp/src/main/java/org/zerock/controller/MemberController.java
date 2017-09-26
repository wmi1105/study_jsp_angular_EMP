package org.zerock.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.MemberVO;
import org.zerock.service.MemberService;

@Controller
@RequestMapping("/include/*")
public class MemberController {
	
	@Inject
	private MemberService service;

	@RequestMapping(value = "/main")
	public String main() {
		return "include/main";
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
//		rttr.addFlashAttribute("msg", "SUCCESS");
		model.addAttribute("giveId", mid);

		return "/include/giveID";
	}
}
