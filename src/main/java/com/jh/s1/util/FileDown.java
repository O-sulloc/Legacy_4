package com.jh.s1.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import com.jh.s1.file.FileDTO;
import com.jh.s1.member.MemberFileDTO;

@Component
public class FileDown extends AbstractView {

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// membercontroller에서 mv.addobbject로 file이란 이름으로 memberfileDTO를 담아둠.
		// mv 즉 model에 담아둔거
		System.out.println("file down 실행");
		FileDTO FileDTO = (FileDTO) model.get("file");
		// membercontroller에서 mv.addobbject로 file이란 이름으로 memberfileDTO를 담아둠.
		// 형변환해줘야됨
		System.out.println(FileDTO.getFileName());
		System.out.println(FileDTO.getOriName());

		String board = (String) model.get("board");
		//board에 member 넣어놔서 밑에 /"+board+"/"; 일케 적으면 되는거임
		
		String path = "/resources/upload/"+board+"/";
		
		// 톰캣이 관리하는 내장 객체는 다른 영역의 내장 객체를 불러 올 수 있다.
		// 단, 좁은 영역에서 큰 영역으로는 가능하지만, 반대로는 불가능.
		// 큰 영역(가장 오래 사는 영역. 즉, application)
		// 내장객체는 -> page -> request -> session -> application(servletcontext)
		// getRealPath 메서드는 application이 가지고 있음.
		ServletContext sc = request.getSession().getServletContext();

		path = sc.getRealPath(path);

		File file = new File(path, FileDTO.getFileName());

		System.out.println(file.exists());
		// 실제로 존재하는지
		System.out.println(file.isFile());
		// 파일이 맞는지 확인

		// encoding 처리
		response.setCharacterEncoding("UTF-8");

		// 파일의 총 크기
		response.setContentLength((int) file.length());
		// setcontentlength는 int 타입 넣으라 그러고
		// file.length는 long 타입이라 형변환한거

		// 다운 받을 때, 파일 이름을 인코딩하는 과정
		String fileName = URLEncoder.encode(FileDTO.getOriName(), "UTF-8");

		// Header 설정
		response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\"");
		response.setHeader("Content-Transfer-Encoding", "binary");

		// HDD에서 파일 읽은 후, client로 전송하는 과정 (연결 준비 과정)
		FileInputStream f1 = new FileInputStream(file);
		// input은 읽은 준비
		OutputStream os = response.getOutputStream();
		// output은 response로 보낼 준비

		// 최종 전송
		FileCopyUtils.copy(f1, os);

		// 연결 끊기
		os.close();
		f1.close();

	}

}
