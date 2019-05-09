package bookmall.vo;

public class OrderVo {
	private Long no;
	private String order_no;
	private Long amount;
	private String location;
	private Long member_no;
	
	private String name;
	private String email;
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getOrder_no() {
		return order_no;
	}
	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Long getMember_no() {
		return member_no;
	}
	public void setMember_no(Long member_no) {
		this.member_no = member_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", order_no=" + order_no + ", amount=" + amount + ", location=" + location
				+ ", member_no=" + member_no + ", name=" + name + ", email=" + email + "]";
	}
	
	
	
}
