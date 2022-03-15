package com.jh.s1.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jh.s1.member.MemberDTO;

@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		MemberDTO memberDTO = (MemberDTO) request.getSession().getAttribute("member");
		// request에서 session꺼내서 거기서 attribute꺼내서 member 불러오기
		// 상속받아서 부모 object니까 형변환

		boolean check = true;
		// true면 통과. controller 진행

		if (memberDTO == null) {
			check = false;
			// memberDTO가 null이면, 즉, 로그인 안되어있으면 check에 false 넣어

			// 1. forward 형식 - servlet 문법 사용. spring문법아님
			// request.setAttribute("message", "로그인이 필요합니다.");
			// request.setAttribute("path", "../member/login");
			// result.jsp에 메세지, path에 넣을거

			// RequestDispatcher view =
			// request.getRequestDispatcher("../WEB-INF/views/common/result.jsp");
			// view.forward(request, response);

			// 2. redirect
			response.sendRedirect("../member/login");
		}

		return check;
	}
}
