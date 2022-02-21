package com.jh.s1.member;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jh.s1.MyJunitTest;

public class MemberDAOTest extends MyJunitTest {

	@Autowired
	private MemberDAO memberDAO;

	@Test
	public void logintest() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("ed3");
		memberDTO.setPw("ww");
		memberDTO = memberDAO.login(memberDTO);
		assertNotNull(memberDTO);
	}

	//@Test
	public void join() throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id2");
		memberDTO.setPw("pw2");
		memberDTO.setName("name2");
		memberDTO.setPhone("010-0000-000");
		memberDTO.setEmail("email2@namver.com");
		int result = memberDAO.join(memberDTO);

		assertEquals(1, result);
	}

}
