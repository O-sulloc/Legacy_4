package com.jh.s1.board;

import java.util.List;

import com.jh.s1.util.Pager;

public interface BoardService {
	// qna랑 notice둘 다 똑같은 내용의 service니까
	// boardservice 만들어놓고 상속

	// list
	public List<BoardDTO> list(Pager pager) throws Exception;
	// pager처리 해야하니까
	// 선언부까지만 쓰는 추상메서드

	// detail
	public BoardDTO detail(BoardDTO boardDTO) throws Exception;
	// return타입은 글 하나 받아올 수 있는 dto타입. 근데 qna, notice 둘다 포함하는 boarddto

	// add
	public int add(BoardDTO boardDTO) throws Exception;

	// update
	public int update(BoardDTO boardDTO) throws Exception;

	// delete
	public int delete(BoardDTO boardDTO) throws Exception;
	
	
}
