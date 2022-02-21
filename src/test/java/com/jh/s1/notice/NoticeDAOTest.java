package com.jh.s1.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jh.s1.MyJunitTest;

public class NoticeDAOTest extends MyJunitTest {

	@Autowired
	private NoticeDAO noticeDAO;

	// @Test
	public void listTest() throws Exception {
		List<NoticeDTO> ar = noticeDAO.list();
		assertEquals(0, ar.size());
	}

	// @Test
	public void addTest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setTitle("t");
		noticeDTO.setContents("c");
		noticeDTO.setWriter("jh");
		noticeDTO.setHit(3);

		int result = noticeDAO.add(noticeDTO);

		assertEquals(1, result);
	}

	//@Test
	public void detailtest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(5);
		noticeDTO = noticeDAO.detail(noticeDTO);

		assertNotNull(noticeDTO);
	}

	@Test
	public void deleteteast() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(5);
		int result = noticeDAO.delete(noticeDTO);
		assertEquals(1, result);

	}

}
