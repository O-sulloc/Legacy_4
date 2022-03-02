package com.jh.s1.notice;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jh.s1.MyJunitTest;
import com.jh.s1.util.Pager;

public class NoticeDAOTest extends MyJunitTest {

	@Autowired
	private NoticeDAO noticeDAO;

	@Test
	public void listTest() throws Exception {
		Pager pager = new Pager();
		pager.setPage(5L);
		pager.makeRow();
		
		List<NoticeDTO> ar = noticeDAO.list(pager);
		System.out.println(ar.get(0).getNum());
		System.out.println(ar.get(4).getNum());
		//assertEquals(0, ar.size());
	}

	
	//@Test
	//db에 200개넣기
	public void addTest() throws Exception {
		for(int i = 0 ; i < 200;i++) {
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setTitle("title" + i);
			noticeDTO.setContents("contents" + i);
			noticeDTO.setWriter("writer" + i);
			noticeDTO.setHit(i);
	
			int result = noticeDAO.add(noticeDTO);
			
			if(i%10==0) {
				Thread.sleep(1000);
			}
		}
		System.out.println("insert fisnish");
		//assertEquals(1, result);
	}

	//@Test
	public void detailtest() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(5);
		noticeDTO = noticeDAO.detail(noticeDTO);

		assertNotNull(noticeDTO);
	}

	//@Test
	public void deleteteast() throws Exception {
		NoticeDTO noticeDTO = new NoticeDTO();
		noticeDTO.setNum(5);
		int result = noticeDAO.delete(noticeDTO);
		assertEquals(1, result);

	}

}
