package com.jh.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv) throws Exception {
		// modelandview로 받는 방법
		// 1.매개변수 선언 2. 메서드 내에 객체 생성
		List<BankBookDTO> ar = bankBookService.list();
		mv.addObject("list", ar);
		mv.setViewName("bankbook/list");
		return mv;
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public void detail(BankBookDTO bankBookDTO, Model model) throws Exception {
		bankBookDTO = bankBookService.detail(bankBookDTO);
		model.addAttribute("dto", bankBookDTO);
	}

	// db에 insert
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(BankBookDTO bankBookDTO) throws Exception {
		// 오버로딩이라 똑같은 이름이어도 ㄱㅊ아
		// view의 이름때문에 string 주기
		int result = bankBookService.add(bankBookDTO);
		
		return "redirect:./list";
		//redirect:글 다썼으면 list로 돌아가
	}

	// insert form으로 이동
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception {

	}
}
