package com.jh.s1.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.jh.s1.board.BoardDTO;
import com.jh.s1.member.MemberDTO;

public class WriterCheckInterceptor extends HandlerInterceptorAdapter {
	// servlet-context에 beans:bean으로 객체를 만들었기때문에
	// 어노테이션 주지 않아도 됨.

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("WriterCheck Interceptor PostHandle");

		// method가 get일때만 posthandle을 실행하고 싶음
		String method = request.getMethod();
		System.out.println("method:" + method);

		if (method.equals("POST")) {
			// post면 걍 멈춰
			return;
			//return뒤에 뭐 안 적어도 돼? return type이 void니까
		}

		// 로그인 정보 받아오기
		MemberDTO memberDTO = (MemberDTO) request.getSession().getAttribute("member");

		// writer 정보 받아오기(model에 담아뒀음)
		Map<String, Object> map = modelAndView.getModel();
		BoardDTO boardDTO = (BoardDTO) map.get("dto");
		// object타입이라 형변환해줘야함.

		if (!memberDTO.getId().equals(boardDTO.getWriter())) {
			// 1. forward, 2. redirect
			// spring 문법을 사용하면 된다.
			// forward
			modelAndView.addObject("message", "수정 권한이 없습니다.");
			modelAndView.addObject("path", "./list");
			// result.jsp 가면 alert창이 있어. 거기 message와 path를 모델로 보내줘

			modelAndView.setViewName("common/result");
			// view의 이름을 바꿔버려
			// result.jsp 가면 alert창이 있어. 거기 message와 path를 모델로 보내줘

		}
	}
}
