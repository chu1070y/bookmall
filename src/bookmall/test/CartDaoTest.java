package bookmall.test;

import java.util.List;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;

public class CartDaoTest {
	
	private CartDao cartDao = new CartDao();
	
	public void insertTest(Long member_no, Long book_no, Long quantity) {
		
		CartVo vo = new CartVo();
		
		vo.setMember_no(member_no);
		vo.setBook_no(book_no);
		vo.setQuantity(quantity);
		
		cartDao.insert(vo);
		
	}
	
	public void selectTest() {
		List<CartVo> list = cartDao.getList();
		
		for(CartVo vo : list) {
			System.out.println("[카트목록] 도서제목: " + vo.getTitle() + ", 카테고리: " + vo.getCategory() + ", 수량: " + vo.getQuantity() + ", 가격: " + vo.getPrice() + ", 주문자: " + vo.getName());
		}
		
	}
}
