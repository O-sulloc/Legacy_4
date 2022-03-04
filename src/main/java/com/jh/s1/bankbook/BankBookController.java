package com.jh.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jh.s1.util.Pager;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {

	@Autowired
	private BankBookService bankBookService;


	// db에 update 처리하는 메서드를 만들자
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.update(bankBookDTO);

		return "redirect:./list";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model) throws Exception {
		// void로 하면 그대로 경로가 됨.
		// bankbookDTO에 booknumber가 담겨져서 올거임
		System.out.println(bankBookDTO.getBookNumber());
		bankBookDTO = bankBookService.detail(bankBookDTO);
		// 어차피 update도 데이터 하나만 출력하는거니까 detail 재활용 가능
		// 그리고 그 결과를 dto에 덮어 씌워
		model.addAttribute("dto", bankBookDTO);
		// model을 매개변수로 받아서 거기에 bankbookdto 넣기
		// 그리고 jsp로 간다.
	}


	@RequestMapping("delete")
	public String delete(BankBookDTO bankBookDTO) throws Exception {
		int result = bankBookService.delete(bankBookDTO);
		return "redirect:./list";
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(ModelAndView mv, Pager pager) throws Exception {
		// modelandview로 받는 방법
		// 1.매개변수 선언 2. 메서드 내에 객체 생성
		List<BankBookDTO> ar = bankBookService.list(pager);
		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		//pager라고 담아놨으니까 list에서도 pager로 불러오면됨
		mv.setViewName("bankbook/list");
		return mv;
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(BankBookDTO bankBookDTO, Model model) throws Exception {		
		//실패하면 밑에 이 bbdto에 null값이 들어오게 됨.
		bankBookDTO = bankBookService.detail(bankBookDTO);
		// 상품 조회 성공시 그대로 출력
		// 실패시 alert창을 띄운후 list로 이동시키고 싶음.
		// common/result.jsp 활용해서 실습해봐
		
		String view="common/result";
		
		if(bankBookDTO != null) {
			view="bankbook/detail";
			model.addAttribute("dto", bankBookDTO);
		}else {
			model.addAttribute("message", "없는 상품 번호입니다.");
			model.addAttribute("path", "./list");
		}
		
		return view;
	}

	// db에 insert
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(BankBookDTO bankBookDTO) throws Exception {
		// 오버로딩이라 똑같은 이름이어도 ㄱㅊ아
		// view의 이름때문에 string 주기
		int result = bankBookService.add(bankBookDTO);

		return "redirect:./list";
		// redirect:글 다썼으면 list로 돌아가
	}

	// insert form으로 이동
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() throws Exception {

	}
}
