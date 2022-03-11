package com.jh.s1.board.qna;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jh.s1.board.BoardDAO;
import com.jh.s1.board.BoardDTO;
import com.jh.s1.board.BoardFileDTO;
import com.jh.s1.util.Pager;

@Repository
public class QnaDAO implements BoardDAO {
	// board interface에 다 선언해놨기때문에
	// implements로 가져오면 됨
	// 그리고 source -> override/implements method 클릭

	@Autowired
	private SqlSession sqlSession;

	private final String NAMESPACE = "com.jh.s1.board.qna.QnaDAO.";
	
	@Override
	public int addFile(BoardFileDTO boardFileDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE+"addFile", boardFileDTO);
	}

	public int reply(QnaDTO qnaDTO) throws Exception{
		return sqlSession.insert(NAMESPACE+"reply", qnaDTO);
	}
	
	public int stepUpdate(QnaDTO qnaDTO) throws Exception {
		// step,depth 이런거 필요하니까 매개변수 qnadto로 (board는 안가지고있음)
		return sqlSession.update(NAMESPACE + "stepUpdate", qnaDTO);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + "detail", boardDTO);
	}

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NAMESPACE + "list", pager);
	}

	@Override
	public int add(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.insert(NAMESPACE + "add", boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.update(NAMESPACE + "update", boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.delete(NAMESPACE + "delete", boardDTO);
	}

	@Override
	public Long total(Pager pager) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NAMESPACE + "total", pager);
	}

}
