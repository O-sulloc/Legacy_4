package com.jh.s1.member;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService memberService;

	// update post
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(MemberDTO memberDTO) throws Exception {
		int result = memberService.update(memberDTO);
		return "redirect:./mypage";
	}

	// mypage update
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(MemberDTO memberDTO, Model model) throws Exception {
		memberDTO = memberService.mypage(memberDTO);
		model.addAttribute("dto", memberDTO);
	}

	// mypage
	@RequestMapping(value = "mypage", method = RequestMethod.GET)
	public ModelAndView mypage(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		// 형변환
		// 밑에 dto 타입으로 넣어놨는데 꺼낼 땐 object 타입이라 dto로 형변환
		memberDTO = memberService.mypage(memberDTO);
		mv.setViewName("member/mypage");
		mv.addObject("dto", memberDTO);
		return mv;
	}

	// logout
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		// session을 없앰.

		return "redirect:../";
		// 한 단계 위로 올라가면 루트 주소가(index가) 나오니까
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(HttpSession session, MemberDTO memberDTO, String remember, Model model,
			HttpServletResponse response) throws Exception {
		// memberDTO = memberService.login(memberDTO);

		System.out.println("Remember: " + remember);

		// cooke 발행하기
		if (remember != null && remember.equals("1")) {
			// 쿠키 생성
			Cookie cookie = new Cookie("remember", memberDTO.getId());
			// 위에서 로그인 성공한 id가 memberdto에 들어가있으니까.. 거기 있는 id 꺼내는거

			// cookie.setPath("/");
			cookie.setMaxAge(-1);

			// 이제 응답으로 내보내야됨. 이걸
			response.addCookie(cookie);
		} else {
			Cookie cookie = new Cookie("remember", "");
			cookie.setMaxAge(0);
			response.addCookie(cookie);

		}

		memberDTO = memberService.login(memberDTO);

		// 로그인 실패. 다시 login폼으로 가삼.
//		String path = "redirect:./login";
//
//		// 로그인 성공하면 = dto가 null이 아니면
//		if (memberDTO != null) {
//			session.setAttribute("member", memberDTO);
//
//			path = "redirect:../";
//		}

		String message = "Login Failed";
		String p = "./login";
		//로그인 실패하면 ./login 으로 가라

		if (memberDTO != null) {
			session.setAttribute("member", memberDTO);
			message = "Login success";
			p="../";
		}
		model.addAttribute("message", message);
		model.addAttribute("path", p);
		//모델에 담아야 jsp로 보내줄 수 있음. 
		String path = "common/result";
		return path;
	}

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public void login(Model model,
			@CookieValue(value = "remember", defaultValue = "", required = false) String rememberId) throws Exception {
		// 있으면 이전에 입력한 id 입력해주고 없으면defaultvalue "" 넣어줘.
		// model.addAttribute("remember", rememberId);
	}

	// 값 입력해서 받아오는
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(MemberDTO memberDTO) throws Exception {
		int result = memberService.join(memberDTO);

		return "redirect:../";
	}

	@RequestMapping(value = "join", method = RequestMethod.GET)
	public void join() throws Exception {}

	@RequestMapping(value = "joinCheck", method=RequestMethod.GET)
	public void joinCheck() throws Exception{}

}