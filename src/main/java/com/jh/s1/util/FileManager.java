package com.jh.s1.util;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	@Autowired
	private ServletContext servletContext;

	public String save(MultipartFile file, String path) throws Exception {
		// 첨부파일은 tomcat이 아니라 OS가 저장함.
		// path =/resources/upload/member
		// 이 위치에 저장해달라고 operation system한테 요청해야함.
		String realPath = servletContext.getRealPath(path);
		System.out.println(realPath);
		return "";
	}
}
