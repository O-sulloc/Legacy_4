package com.jh.s1.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jh.s1.board.BoardDTO;
import com.jh.s1.board.BoardService;
import com.jh.s1.board.notice.NoticeFileDTO;
import com.jh.s1.member.MemberFileDTO;
import com.jh.s1.util.FileManager;
import com.jh.s1.util.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaDAO qnaDAO;
	// dao있어야지

	@Autowired
	private FileManager fileManager;

	public QnaFileDTO detailFile(QnaFileDTO qnaFileDTO) throws Exception {
		return qnaDAO.detailFile(qnaFileDTO);
	}

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makeRow();

		pager.makeNum(qnaDAO.total(pager));
		// totalcount계산

		return qnaDAO.list(pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.detail(boardDTO);
	}

	@Override
	public int add(BoardDTO boardDTO, MultipartFile[] files) throws Exception {
		int result = qnaDAO.add(boardDTO);

		for (int i = 0; i < files.length; i++) {
			if (files[i].isEmpty()) {
				continue;
			}
			String fileName = fileManager.save(files[i], "resources/upload/qna/");

			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setNum(boardDTO.getNum());
			qnaFileDTO.setFileName(fileName);
			qnaFileDTO.setOriName(files[i].getOriginalFilename());

			result = qnaDAO.addFile(qnaFileDTO);
		}

		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		List<QnaFileDTO> ar = qnaDAO.listFile(boardDTO);

		int result = qnaDAO.delete(boardDTO);

		if (result > 0) {
			for (QnaFileDTO dto : ar) {
				boolean check = fileManager.remove("resources/upload/qna/", dto.getFileName());
			}
		}

		return result;
	}

	// 부모 interface에 없는 메서드여서 직접 만들어야 함
	public int reply(QnaDTO qnaDTO) throws Exception {
		// qnaDTO.num - <input type="hidden" value="${dto.num }" name="num">
		// 즉, num에는 부모글의 글번호가 들어간다.
		// qnaDTO.title -폼에서 입력된 답글 제목
		// qnaDTO.writer - 폼에서 입력된 답글 작성자의 이름
		// qnaDTO.contents - 폼에서 입력된 답글 내용
		// qnaDTO.regDate - null
		// qnaDTO.hit - null
		// qnaDTO.ref - null
		// qnaDTO.step - null
		// qnaDTO.depth - null
		// 여기서 ref는 뭐야? 부모글의 ref를 가져와야됨.
		// 그게 db에 있으니까 가져오는 코드 써보자

		// 1.부모의 정보를 db에서 조회(ref,step,depth)
		// 부모글 하나만 가져오면 되니까 detail 재활용
		BoardDTO boardDTO = qnaDAO.detail(qnaDTO);
		// qnaDTO으로 만들어졌지만, 운반은 boardDTO로
		QnaDTO parent = (QnaDTO) boardDTO;
		// 그래서 qna꺼내려면 형변환해줘야함. 그작업임

		// 2. 답글의 ref는 부모의 ref값이다
		// 부모의 ref꺼내서 답글ref에 넣기
		qnaDTO.setRef(parent.getRef());

		// 3. 답글의 step은 부모의 step+1한 값이다
		qnaDTO.setStep(parent.getStep() + 1);

		// 4. 답글의 depth는 부모의 depth+1한 값이다.
		qnaDTO.setDepth(parent.getDepth() + 1);

		// 5. dao에 있는 stepUpdate 호출하기
		int result = qnaDAO.stepUpdate(parent);
		// 부모의 ref와 같고 부모의 step보다 큰 값을 찾는 메서드니까 parent 넣어야지

		// 6. 답글 insert
		result = qnaDAO.reply(qnaDTO);
		// 답글을 insert하는거니까 답글의 정보가 있는 qnadto 넣어야지

		return result;

	}
}
