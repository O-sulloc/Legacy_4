package com.jh.s1.board.notice.noticeReply;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/noticeReply/**")
public class NoticeReplyController {

	@Autowired
	private NoticeReplyService noticeReplyService;

	// @RequestMapping(value = "add", method = RequestMethod.POST)
	// @PostMapping(value = "add") 위에거랑 똑같은거임. 더 단축해서 쓰는거
	// @PostMapping(value = "add") 여기에 value 굳이 안 적어도 됨.
	// value, method 등등 들어가는게 많으면 구분하기 위해 이건 value고~ 이건 method라고 알려주는건데
	// 여기는 value 하나만 들어가면 되니까 안적어도 value인 줄 아니까 안 적어도 됨.
	// @GetMapping 이건 get방식일때
	@PostMapping("add")
	public ModelAndView add(NoticeReplyDTO noticeReplyDTO) throws Exception {
		int result = noticeReplyService.add(noticeReplyDTO);

		System.out.println("add!!!");
		System.out.println(result);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv; // "redirect: ../notice/list";
	}

	@GetMapping("list")
	public ModelAndView list(NoticeReplyDTO noticeReplyDTO) throws Exception {
		System.out.println("list!");
		System.out.println(noticeReplyDTO.getNum());
		// getnum =부모의 글번호를 받아와서 출력
		List<NoticeReplyDTO> ar = noticeReplyService.list(noticeReplyDTO);

		System.out.println(ar);

		ModelAndView mv = new ModelAndView();
		mv.addObject("noticeReply", ar);
		mv.setViewName("common/noticeReply");

		return mv;
	}

	@PostMapping("delete")
	public ModelAndView delete(NoticeReplyDTO noticeReplyDTO) throws Exception {
		int result = noticeReplyService.delete(noticeReplyDTO);

		ModelAndView mv = new ModelAndView();
		mv.addObject("result", result);
		mv.setViewName("common/ajaxResult");
		return mv;
	}

	@PostMapping("update")
	public ModelAndView update(NoticeReplyDTO noticeReplyDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println(noticeReplyDTO.getContents());
		System.out.println(noticeReplyDTO.getReplyNum());
		
		int resut = noticeReplyService.update(noticeReplyDTO);
		System.out.println(resut);
		mv.setViewName("common/ajaxResult");
		mv.addObject("result", resut);
		return mv;
	}
}
