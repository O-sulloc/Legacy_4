package com.jh.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jh.s1.MyJunitTest;
import com.jh.s1.util.Pager;

public class BankBookDAOTest extends MyJunitTest {

	@Autowired
	private BankBookDAO bankBookDAO;

	// list
	@Test
	public void listTest() throws Exception {
		Pager pager = new Pager();
		pager.setPerPage(5L);
		pager.makeRow();
		// pager.makeRow();이걸 해야 startrow랑 lastrow 계산하겠지

		List<BankBookDTO> ar = bankBookDAO.list(pager);
		System.out.println(ar.get(0).getBookNumber());
		System.out.println(ar.get(4).getBookNumber());
		assertEquals(5, ar.size());
		// 아직 DB에 data가 없으니까 0개여야 맞음

	}

	// add
	// @Test
	public void addTest() throws Exception {
		for (int i = 0; i < 200; i++) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookName("bookname" + i);
			bankBookDTO.setBookContents("bookcontents" + i);

			double rate = Math.random();
			rate = rate * 1000;
			int r = (int) rate;
			rate = r / 100.0;

			bankBookDTO.setBookRate(rate);
			bankBookDTO.setBookSale(1);

			int result = bankBookDAO.add(bankBookDTO);

			if (i % 10 == 0) {
				Thread.sleep(1000);
			}

		}
		System.out.println("insert finish");
		// assertEquals(1, result);
	}

	// @Test
	public void detailTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(2L);
		// bankBookDTO = bankBookDAO.detail(2);

		assertNotNull(bankBookDTO);
	}

	// @Test
	public void deleteTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(2L);
		int result = bankBookDAO.delete(bankBookDTO);

		assertEquals(1, result);
	}

}
