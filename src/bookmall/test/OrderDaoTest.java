package bookmall.test;

import java.util.List;

import bookmall.dao.OrderDao;
import bookmall.vo.CartVo;
import bookmall.vo.OrderVo;

public class OrderDaoTest {
	
	private OrderDao orderDao = new OrderDao();
	
	public void insertTest(Long member_no, String location) {
		OrderVo vo = new OrderVo();
		
		vo.setMember_no(member_no);
		vo.setLocation(location);
		
		orderDao.insertOrder(vo);
		orderDao.insertOrderBook();
	}
	
	public void selectOrderTest() {
		List<OrderVo> list = orderDao.getOrderList();
		
		for(OrderVo vo : list) {
			System.out.println("[주문목록] 주문번호: " + vo.getOrder_no() + ", 주문자: " + vo.getName() + "/" + vo.getEmail() + ", 결제금액: " + vo.getAmount() + ", 배송지: " + vo.getLocation());
		}
		
	}
	
	public void selectOrderBookTest() {
		List<CartVo> list = orderDao.getOrderBookList();
		
		for(CartVo vo : list) {
			System.out.println("[주문도서목록] 도서번호: " + vo.getBook_no() + ", 도서제목: " + vo.getTitle() + ", 수량: " + vo.getQuantity() + ", 도서분류: " + vo.getCategory());
		}
		
	}
}
