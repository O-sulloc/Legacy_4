package com.jh.s1.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class TestInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("controller 진입 전 실행");
		// return이 true면 controller로 계속 진행
		// false면 controller로 진입 불가능하게 해줌.
		return super.preHandle(request, response, handler);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("controller에서 dispathcer servlet으로 가기 전에 실행");
		// return없음

	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("view(jsp)를 html로 렌더링한 후 실행됨. (클라이언트에게 보내기 전)");

	}
	
	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
			System.out.println("비동기 방식을 요청하면, postHandle과 afterCompletion을 수행하지 않고 이 메서드를 실행한다.");

	}
}
