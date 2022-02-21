package com.jh.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(MemberDTO memberDTO) throws Exception {
		memberDTO = memberService.login(memberDTO);

		// 로그인 실패. 다시 login폼으로 가삼.
		String path = "redirect:./login";

		// 로그인 성공하면 = dto가 null이 아니면
		if (memberDTO != null) {
			path = "redirect:../";
		}

		return path;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login() throws Exception {
	}

	// 값 입력해서 받아오는
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO) throws Exception {
		int result = memberService.join(memberDTO);

		return "redirect:../";
	}

	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() throws Exception {

	}
}
