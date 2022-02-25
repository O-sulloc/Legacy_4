package com.jh.s1.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jh.s1.util.Pager;

@Service
public class BankBookService {
	// controller -> service -> dao
	// 컨트롤러에서 dao로 바로 가는 게 아니라 service를 거치고 가는 것.
	// dao로 데이터를 보내기 전에 전처리 작업을 함.
	// dao에서 리턴받은 데이터를 컨트롤러에 보내기 전에 후처리 작업을 함.
	// 해당 작업을 하려면 bbdao가 있어야 함
	// 따라서 bbs는 bbdao에 의존적임

	@Autowired
	private BankBookDAO bankBookDAO;

	public int update(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.update(bankBookDTO);
	}

	public int delete(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.delete(bankBookDTO);
	}

	// add하는 메서드
	public int add(BankBookDTO bankBookDTO) throws Exception {
		// controller에서 bankBookDTO보내주면
		return bankBookDAO.add(bankBookDTO);
		// 내가 dao.add할 때 bankBookDTO 리턴해줄게.
	}

	public BankBookDTO detail(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.detail(bankBookDTO);

	}

	public List<BankBookDTO> list(Pager pager) throws Exception {
		// 이 메서드는 DAO메서드 호출 전에 전처리 작업을 하고
		pager.makeRow();
		
		Long totalCount = bankBookDAO.total(pager);
		pager.makeNum(totalCount);
		// 호출 후에 후처리 작업이 필요하면 호출하면 됨.
		List<BankBookDTO> ar = bankBookDAO.list(pager);
		return ar;
	}

}
