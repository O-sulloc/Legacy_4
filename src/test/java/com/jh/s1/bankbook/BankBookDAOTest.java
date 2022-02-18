package com.jh.s1.bankbook;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.jh.s1.MyJunitTest;

public class BankBookDAOTest extends MyJunitTest {

	@Autowired
	private BankBookDAO bankBookDAO;

	// list
	// @Test
	public void listTest() throws Exception {
		List<BankBookDTO> ar = bankBookDAO.list();
		assertNotEquals(0, ar.size());
		// 아직 DB에 data가 없으니까 0개여야 맞음
	}

	// add
	@Test
	public void addTest() throws Exception {
		for (int i = 0; i < 10; i++) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBookName("bookname" + i);
			bankBookDTO.setBookContents("bookcontents" + i);
			bankBookDTO.setBookRate(1.12 + i);
			bankBookDTO.setBookSale(1);

			int result = bankBookDAO.add(bankBookDTO);
		}
		System.out.println("insert finish");
		// assertEquals(1, result);
	}

	// @Test
	public void detailTest() throws Exception {
		BankBookDTO bankBookDTO = new BankBookDTO();
		bankBookDTO.setBookNumber(2L);
		//bankBookDTO = bankBookDAO.detail(2);

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
