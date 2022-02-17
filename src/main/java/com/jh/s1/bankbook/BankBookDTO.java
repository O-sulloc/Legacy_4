package com.jh.s1.bankbook;

public class BankBookDTO {

	private Long bookNumber;
	private String bookName;
	private String bookContents;
	private Double bookRate;
	private Integer bookSale;

	public Long getBookNumber() {
		return bookNumber;
	}

	public void setBookNumber(Long bookNumber) {
		this.bookNumber = bookNumber;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookContents() {
		return bookContents;
	}

	public void setBookContents(String bookContents) {
		this.bookContents = bookContents;
	}

	public Double getBookRate() {
		return bookRate;
	}

	public void setBookRate(Double bookRate) {
		this.bookRate = bookRate;
	}

	public Integer getBookSale() {
		return bookSale;
	}

	public void setBookSale(Integer bookSale) {
		this.bookSale = bookSale;
	}

}
