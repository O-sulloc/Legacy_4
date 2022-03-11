package com.jh.s1.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jh.s1.board.BoardDTO;
import com.jh.s1.board.BoardService;
import com.jh.s1.util.FileManager;
import com.jh.s1.util.Pager;

@Service
public class NoticeService implements BoardService {

	@Autowired
	private NoticeDAO noticeDAO;

	@Autowired
	private FileManager fileManager;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makeRow();
		pager.makeNum(noticeDAO.total(pager));
		return noticeDAO.list(pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.detail(boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO, MultipartFile[] files) throws Exception {

		// long num = noticeDAO.seqNum();
		// 그니까 dao에 seqNum이라는 메서드를 따로 만들어.
		// 그러면 매퍼에 적어놓은 것(select notice_seq.nextval from dual)처럼 글번호(num)를 먼저 만드는거지.
		// 즉, 글 작성하기 전에!!! 글 번호가 먼저 만들어지는 거지.
		// 그리고 그걸 long타입의 num변수에 저장해

		// boardDTO.setNum(num);
		// 그리고 boardDTO의 num에 다시 저장하는거지
		// 그리고 밑에 dao.add 메서드를 실행하는거임.
		// 그럼 성공적으로 boardDTO에 작성한 글의 데이터가 저장될 것임.
		// 그럼 밑에 noticeFileDTO.setNum(boardDTO.getNum());도 진행할 수 있게 됨.

		int result = noticeDAO.add(boardDTO);
		// notice테이블에 먼저 insert를 하고 파일첨부해야 글 번호 불러올 수 있음

		// 1.hdd 저장
		for (int i = 0; i < files.length; i++) {
			if (files[i].isEmpty()) {
				// is i번째 files empty? yes -> true / no -> false
				// same with files[i].getSize()==0
				continue;
				//비어있으면 더 이상 진행하지 말고 위로 올라가라.
			}
			String fileName = fileManager.save(files[i], "resources/upload/notice/");

			// 2.db에 저장
			// for반복문이라 한 번 지날때마다 filename 덮어씌어지니까 그 전에 db에 저장해야지
			NoticeFileDTO noticeFileDTO = new NoticeFileDTO();
			noticeFileDTO.setNum(boardDTO.getNum());
			noticeFileDTO.setFileName(fileName);
			noticeFileDTO.setOriName(files[i].getOriginalFilename());
			// multipartfiles인 files에 이름이 담겨있음

			result = noticeDAO.addFile(noticeFileDTO);
		}

		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return noticeDAO.delete(boardDTO);
	}

}
