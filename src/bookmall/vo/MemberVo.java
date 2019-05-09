package bookmall.vo;

public class MemberVo {
	private Long no;
	private String name;
	private String tel;
	private String email;
	private String pw;
	
	@Override
	public String toString() {
		return "MemberVO [no=" + no + ", name=" + name + ", tel=" + tel + ", email=" + email + ", pw=" + pw + "]";
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}

}
