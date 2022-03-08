package com.jh.s1.board;

import java.util.List;

import com.jh.s1.util.Pager;

public interface BoardDAO {

	//detail 메서드
	public BoardDTO detail(BoardDTO boardDTO) throws Exception;
	//헤드만 있고 body{}는 없는 추상 메서드
	//qnadao, noticedao 둘 다 쓸거니까 void,매개변수를 부모인 boarddto로 선언
	
	//list
	public List<BoardDTO> list(Pager pager) throws Exception;
	//페이징 처리하려고 pager 받았음
	
	//add
	//clud는 int로 받기로 함
	public int add(BoardDTO boardDTO) throws Exception;
	
	//update
	public int update(BoardDTO boardDTO) throws Exception;
	
	//delete
	public int delete(BoardDTO boardDTO) throws Exception;
	
	//total (검색 결과의 총 개수 가져오는)
	public Long total(Pager pager) throws Exception;
	//검색어랑 kind 매개변수로 받아야하니까 그거 다 갖고 있는 pager를 매개변수로
}
