package com.jh.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jh.s1.board.BoardDTO;
import com.jh.s1.util.Pager;

@Controller
@RequestMapping("/notice/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@ModelAttribute("board")
	public String board() {
		return "notice";
	}

	// update post
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(NoticeDTO noticeDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.update(noticeDTO);
		mv.setViewName("redirect:./list");
		return mv;
	}

	// update get
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update(NoticeDTO noticeDTO, Model model) throws Exception {
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		model.addAttribute("dto", boardDTO);
		return "board/update";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView delete(NoticeDTO noticeDTO) throws Exception {
		int result = noticeService.delete(noticeDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./list");
		return mv;
	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(NoticeDTO noticeDTO, MultipartFile [] files) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = noticeService.add(noticeDTO, files);
		mv.setViewName("redirect:./list");
		return mv;
	}

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public ModelAndView add() throws Exception {
		ModelAndView mv = new ModelAndView();

		mv.setViewName("board/add");
		return mv;
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView detail(NoticeDTO noticeDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		// 형변환(noticedto로 받아서 boarddto에 담는 것)
		// 자식(notice)에서 만들어지고 부모(board)에 담는

		mv.addObject("dto", boardDTO);
		mv.setViewName("board/detail");

		return mv;
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(Pager pager) throws Exception {
		ModelAndView mv = new ModelAndView();
		List<BoardDTO> ar = noticeService.list(pager);

		mv.addObject("list", ar);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		return mv;
	}

}
