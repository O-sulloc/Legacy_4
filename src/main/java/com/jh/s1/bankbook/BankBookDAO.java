package com.jh.s1.bankbook;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jh.s1.util.Pager;

@Repository
public class BankBookDAO {

	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.jh.s1.bankbook.BankBookDAO.";

	// total count
	public Long total() throws Exception{
		return sqlSession.selectOne(NAMESPACE+"total");
	}

	// update
	public int update(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.update(NAMESPACE + "update", bankBookDTO);
	}

	// list조회하는 메서드
	public List<BankBookDTO> list(Pager pager) throws Exception {
		// list<>제네릭안에 mapper에 resultType으로 선언한 걸 입력
		return sqlSession.selectList(NAMESPACE + "list", pager);
		// ()괄호 안에 namespace
		// +플러스는 mapper에 작성한 id 이름
	}

	// 추가하는 add 메서드
	public int add(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "add", bankBookDTO);
		// sqlSession.멤버메셔드명(namespsace+"id명", 파라미터값)
		// 근데 파라미터값.. bankBookDTO 이것도 사용자가 넣어주는 값을 받는거잖아?
		// 그러니까 매개변수에 bankbookDTO 선언해야 됨.
	}

	// 상품하나만 볼 수 있는 detail 메서드
	public BankBookDTO detail(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.selectOne(NAMESPACE + "detail", bankBookDTO);
	}

	// 상품 삭제하는 delete 메서드
	public int delete(BankBookDTO bankBookDTO) throws Exception {
		return sqlSession.delete(NAMESPACE + "delete", bankBookDTO);
	}
}
