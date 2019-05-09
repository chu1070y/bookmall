package bookmall.vo;

public class CartVo {
	private Long member_no;
	private Long book_no;
	private Long quantity;
	
	private String name;
	private String title;
	private Long price;
	private String category;
	
	public Long getMember_no() {
		return member_no;
	}
	public void setMember_no(Long member_no) {
		this.member_no = member_no;
	}
	public Long getBook_no() {
		return book_no;
	}
	public void setBook_no(Long book_no) {
		this.book_no = book_no;
	}
	public Long getQuantity() {
		return quantity;
	}
	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "CartVo [member_no=" + member_no + ", book_no=" + book_no + ", quantity=" + quantity + ", name=" + name
				+ ", title=" + title + ", price=" + price + ", category=" + category + "]";
	}
	
	
	
	
}
