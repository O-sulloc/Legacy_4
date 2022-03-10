package com.jh.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jh.s1.util.FileManager;

@Service
public class MemberService {

	@Autowired
	private MemberDAO memberDAO;
	@Autowired
	private FileManager fileManager;

	public int update(MemberDTO memberDTO) throws Exception {
		return memberDAO.update(memberDTO);
	}

	public MemberDTO mypage(MemberDTO memberDTO) throws Exception {
		return memberDAO.mypage(memberDTO);
	}

	public MemberDTO login(MemberDTO memberDTO) throws Exception {
		return memberDAO.login(memberDTO);
	}

	public int join(MemberDTO memberDTO, MultipartFile photo) throws Exception {
		int result = memberDAO.join(memberDTO);
		// 1. 파일을 하드디스크(hdd)에 저장
		String fileName = fileManager.save(photo, "resources/upload/member");
		//
		
		// 2. 정보를 db에 저장
		MemberFileDTO memberFileDTO = new MemberFileDTO();
		memberFileDTO.setId(memberDTO.getId());
		memberFileDTO.setFileName(fileName);
		memberFileDTO.setOriName(photo.getOriginalFilename());
		//db에 저장하려면 정보가 있어야 하는데
		//그 정보는 memberfiledto에 있어야지
		result = memberDAO.addFile(memberFileDTO);
		
		return result; // memberDAO.join(memberDTO);
	}
}
