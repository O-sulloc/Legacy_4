package com.jh.s1.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileManager {

	@Autowired
	private ServletContext servletContext;

	//hdd에서 파일 삭제하는 메서드
	public boolean remove(String path, String fileName) throws Exception{
		//저장된 파일명, 파일이 저장된 폴더명을 알아야함. 그래서 매개변수로 받아와야함.
		
		path = servletContext.getRealPath(path);
		//서블렛으로 진짜 실제 경로 받아옴
		
		File file = new File(path, fileName);
		return file.delete();
		//delete 삭제하면 true 찍힘
		//그래서 리턴타입도 boolean
	}
	
	//하드디스크에 저장하는 메서드
	public String save(MultipartFile multipartFile, String path) throws Exception {
		// 첨부파일은 tomcat이 아니라 OS가 저장함.
		// path =/resources/upload/member
		// 이 위치에 저장해달라고 operation system한테 요청해야함.
		String realPath = servletContext.getRealPath(path);
		System.out.println(realPath);

		File file = new File(realPath);
		// path =/resources/upload/member 이거를 넣는다고

		// System.out.println(file2.exists());
		// exists? 이거 존재해? 응 ->true 아니 ->false

		// System.out.println(file2.isDirectory());
		// is로 시작하는 메서드는 뭐야? return이 true, false로 나오는 거
		// is directory? 이거 폴더야? 응 ->true 아니 ->false

		if (!file.exists()) {
			// file2.exists()==false
			// 만약 폴더가 존재하지 않으면
			// file2.mkdir();
			// make directory (경로를 만들어줘=폴더를 만들어줘)
			// upload밑에 member 폴더를 만들라는 코드인데
			// upload가 없으면 안됨. 당연함 upload있어야 upload/member 만들 수 있음
			file.mkdirs();
			// 이거 쓰면 만약 upload(중간폴더)없어도 upload부터 member까지 만들어줌
			// file2.mkdir(); 보다 안전함.
		}

		// 1. 시간을 이용하는 방법
		Calendar ca = Calendar.getInstance();
		long l = ca.getTimeInMillis();
		// 현재 시간을 밀리세컨즈로 변환해줌
		System.out.println("time" + l);
		String oriName = multipartFile.getOriginalFilename();

		String fileName = l + "_" + oriName;
		// 시간(밀리세컨즈)_파일명
		System.out.println("filename: " + fileName);

		// 2. UUID 사용하는 방법
		fileName = UUID.randomUUID().toString();
		// uuid는 static메서드구나. 객체를 만들지 않아도 randomUUID메서드를 쓸 수 있네.
		fileName = fileName + "_" + oriName;
		System.out.println("UUID: " + fileName);

		// file을 hdd에 저장하는 방법
		// 1. multipartfile클래스의 transferTo 메서드를 사용하는 방법
		// file = new File(file, fileName);
		// 배개변수에 realPath 넣어도 되고 file 넣어도 됨
		// multipartFile.transferTo(file);

		// 2. filecopyutils
		file = new File(file, fileName);
		// 이 경로에 이 파일명으로 저장해
		FileCopyUtils.copy(multipartFile.getBytes(), file);
		// multipartsfile.getbytes로 사진의 010101 배열을 순서대로 가져오는거임

		return fileName;
		// fileName을 저장해라.
	}
}
