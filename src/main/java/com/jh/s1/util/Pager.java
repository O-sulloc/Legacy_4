package com.jh.s1.util;

public class Pager {

	private Long perPage;
	// perPage: 한 페이지 당 보여질 글의 개수
	private Long page;
	// page: page의 번호
	private Long startRow;
	// startRow: 시작 글번호
	private Long lastRow;
	// lastRow: 끝번호

	// jsp에서 사용할 변수들
	private Long startNum;
	private Long lastNum;

	private boolean pre;
	private boolean next;
	// 뒤에 페이지가 더 있냐 없냐

	// 여기까지

	public void makeRow() {
		this.startRow = (this.getPage() - 1) * this.getPerPage() + 1;
		// 밑에 getPerPage에 넣어둔 값 가져오기.
		this.lastRow = this.getPage() * this.getPerPage();
	}

	public void makeNum(Long totalCount) {
		// 1. 전체 row의 개수 구하기
		

		// 2. 필요한 전체 페이지의 수 구하기
		// getter이용하면 더 안전(음수도 거를 수 있음)
		Long totalPage = totalCount / this.getPerPage();
		if (totalCount % this.getPerPage() != 0) {
			totalPage++;
		}

		// 3. 블럭당 개수
		Long perBlock = 10L;

		// 4. 전체 블럭의 개수 구하기
		Long totalBlock = totalPage / perBlock;
		if (totalPage % perBlock != 0) {
			totalBlock++;
		}

		// 5. 특정 page가 몇 번 째 블럭에 해당하는지 계산
		// 1번 블럭에는 1~10번까지 있고
		// 2번 블럭에는 11~20번까지 있고

		Long curBlock = this.getPage() / perBlock;
		if (this.getPage() % perBlock != 0) {
			curBlock++;
		}

		// 6. curBlock으로 startNum, lastNum 구하기
		this.startNum = (curBlock - 1) * perBlock + 1;
		this.lastNum = curBlock * perBlock;

		// 7. 다음(이전) 블럭이 있는지 여부
		this.pre = false;
		if (curBlock > 1) {
			this.pre = true;
			// 지금 블럭이 2,3번째면 그 전 블럭으로 이동할 수 있어야 되잖아
			// 그러니까 true
		}

		this.next = false;
		if (totalBlock > curBlock) {
			this.next = true;
			// 4블럭까지 있는데, 지금 1블럭이면
			// 아직 3블럭 더 남은거니까 true
		}

		// 8. 현재 블럭이 마지막 블럭번호와 같다면
		if(curBlock == totalBlock) {
			this.lastNum=totalPage;
		}

	}

	public Long getPerPage() {
		// perPage가 설정이 안돼서 null이면
		// 초기값으로 10을 넣어줘
		if (this.perPage == null || this.perPage < 1) {
			this.perPage = 10L;
			// 그니까 글번호 5개, 15개 이런거 지정안하면
			// 10개를 default로 보여달라고
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPage() {

		if (this.page == null || this.page < 1) {
			this.page = 1L;
			// page 지정안되면 당연히 첫번째 페이지부터 보여줘야지
		}

		return page;
	}

	public void setPage(Long page) {
		this.page = page;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

}
