package bookmall.vo;

public class CategoryVo {
	private Long no;
	private String category;
	
	@Override
	public String toString() {
		return "CategoryVO [no=" + no + ", category=" + category + "]";
	}
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
