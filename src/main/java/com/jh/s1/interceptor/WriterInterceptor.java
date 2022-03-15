package com.jh.s1.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jh.s1.board.BoardDTO;
import com.jh.s1.board.qna.QnaDAO;
import com.jh.s1.board.qna.QnaDTO;
import com.jh.s1.member.MemberDTO;

@Component
public class WriterInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private QnaDAO qnaDAO;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		boolean check = false;

		Long num = Long.parseLong(request.getParameter("num"));

		BoardDTO boardDTO = new QnaDTO();
		// 만들땐 qnadto 넣을땐 boarddto
		boardDTO.setNum(num);
		
		boardDTO = qnaDAO.detail(boardDTO);

		MemberDTO memberDTO = (MemberDTO) request.getSession().getAttribute("member");

		if (!boardDTO.getWriter().equals(memberDTO.getId())) {
			//!같지 않으면
			check = false;
			//1. forward or 2.redirect
			request.setAttribute("message", "작성자가 아닙니다.");
			request.setAttribute("path", "./list");
			
			RequestDispatcher view = request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
			view.forward(request, response);
		}

		return check;
	}
}
