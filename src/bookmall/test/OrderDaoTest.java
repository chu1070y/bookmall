package bookmall.test;

import bookmall.dao.OrderDao;
import bookmall.vo.OrderVo;

public class OrderDaoTest {

	public static void main(String[] args) {

		// 주문 넣기
		orderInsert(1L, "포켓몬월드 관동지방 태초마을 22번지");

	}

	// 주문 테이블 및 주문도서 테이블에 데이터를 넣는다.
	public static void orderInsert(Long member_no, String location) {

		OrderDao orderDao = new OrderDao();

		OrderVo vo = new OrderVo();

		vo.setMember_no(member_no);
		vo.setLocation(location);

		// 주문 테이블에 데이터 넣기
		orderDao.insertOrder(vo);

		// 주문도서 테이블에 데이터 넣기
		orderDao.insertOrderBook();
	}
}
