package com.jh.s1.member;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.jh.s1.member.MemberDAO.";

	
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		return sqlSession.selectOne(NAMESPACE+"login", memberDTO);
		
	}
	
	public int join(MemberDTO memberDTO) throws Exception {
		return sqlSession.insert(NAMESPACE + "join", memberDTO);
	}
}
