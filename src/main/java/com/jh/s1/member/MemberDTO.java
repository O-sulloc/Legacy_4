package com.jh.s1.member;

public class MemberDTO {

	private String id;
	private String pw;
	private String name;
	private String phone;
	private String email;
	private MemberFileDTO memberFileDTO;
	// is a has a 중에 has a
	// member has a memberfile
	// 멤버변수에 선언하면 됨.

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public MemberFileDTO getMemberFileDTO() {
		return memberFileDTO;
	}

	public void setMemberFileDTO(MemberFileDTO memberFileDTO) {
		this.memberFileDTO = memberFileDTO;
	}

}
