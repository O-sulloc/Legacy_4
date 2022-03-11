package com.jh.s1.board.qna;

import java.util.List;

import com.jh.s1.board.BoardDTO;

public class QnaDTO extends BoardDTO {
	private Long ref;
	private Long step;
	private Long depth;

	private List<QnaFileDTO> fileDTOs;
	
	public List<QnaFileDTO> getFileDTOs() {
		return fileDTOs;
	}

	public void setFileDTOs(List<QnaFileDTO> fileDTOs) {
		this.fileDTOs = fileDTOs;
	}

	public Long getRef() {
		return ref;
	}

	public void setRef(Long ref) {
		this.ref = ref;
	}

	public Long getStep() {
		return step;
	}

	public void setStep(Long step) {
		this.step = step;
	}

	public Long getDepth() {
		return depth;
	}

	public void setDepth(Long depth) {
		this.depth = depth;
	}

}
