package com.jh.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jh.s1.board.BoardDTO;
import com.jh.s1.board.notice.NoticeDTO;
import com.jh.s1.member.MemberFileDTO;
import com.jh.s1.util.Pager;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	@Autowired
	private QnaService qnaService;

	@ModelAttribute("board")
	public String board() {
		return "qna";
		// model에 board라는 속성명으로 qna를 담아줘
	}

	@PostMapping("fileDelete")
	public ModelAndView fileDelete(QnaFileDTO qnaFileDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println(qnaFileDTO.getFileNum());
		int result = qnaService.fileDelete(qnaFileDTO);
		
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", result);
		return mv;
	}
	
	@RequestMapping(value = "photoDown", method = RequestMethod.GET)
	public ModelAndView fileDown(QnaFileDTO qnaFileDTO) throws Exception {
		// parameter로 fileNum 들어오니까 fileNum을 멤버변수로 하는 memverFileDTO 매개변수에 적어
		ModelAndView mv = new ModelAndView();
		mv.setViewName("fileDown");
		// 이제 뷰네임에 클래스 이름 넣어
		// util의 filedown의 bean네임(빈네임 따로 지정안했으니까 첫글자만 소문자로 바꾸면 됨.)

		qnaFileDTO = qnaService.detailFile(qnaFileDTO);

		mv.addObject("file", qnaFileDTO);

		return mv;
	}	
	
	@RequestMapping(value = "reply", method = RequestMethod.POST)
	public ModelAndView reply(QnaDTO qnaDTO) throws Exception {
		// 오버로딩 위해 매개변수르 다르게 선언
		ModelAndView mv = new ModelAndView();
		int result = qnaService.reply(qnaDTO);
		mv.setViewName("redirect:./list");
		
		return mv;
	}

	@RequestMapping(value = "reply", method = RequestMethod.GET)
	public ModelAndView reply(QnaDTO qnaDTO, ModelAndView mv) throws Exception {
		mv.addObject("dto", qnaDTO);
		mv.setViewName("board/reply");
		return mv;
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.update(qnaDTO);

		return "redirect:./list";
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO boardDTO = qnaService.detail(qnaDTO);
		model.addAttribute("dto", boardDTO);
		return "board/update";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete(QnaDTO qnaDTO) throws Exception {
		int result = qnaService.delete(qnaDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./list");
		return mv;
	}

//	@RequestMapping(value = "delete", method = RequestMethod.GET)
//	public String delete(QnaDTO qnaDTO) throws Exception {
//		int result = qnaService.delete(qnaDTO);
//
//		return "redirect:/list";
//	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() throws Exception {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("board/add");
		return mv;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(QnaDTO qnaDTO, MultipartFile [] files) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = qnaService.add(qnaDTO, files);
		mv.setViewName("redirect:./list");
		return mv;
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(QnaDTO qnaDTO, Model model) throws Exception {
		BoardDTO boardDTO = qnaService.detail(qnaDTO);
		// boarddto넣어달라고했는데 qnadto넣어도 됨?
		// ㅇㅇ 자식이니까 가능
		// return은? boarddto로 받아야함.
		// 실제 타입은 qnadto지만 "운반"될 때는 boardDTO에 넣어야되잖아
		model.addAttribute("dto", boardDTO);

		return "board/detail";
	}

	// list
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Pager pager, Model model) throws Exception {
		List<BoardDTO> ar = qnaService.list(pager);
		model.addAttribute("list", ar);

		return "board/list";
		// return으로 view의 이름
	}
}
