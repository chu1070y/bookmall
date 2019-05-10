package bookmall.test;

import bookmall.dao.CartDao;
import bookmall.vo.CartVo;

public class CartDaoTest {

	public static void main(String[] args) {

		// 카드 넣기
		cartInsert(1L, 3L, 5L);
		cartInsert(1L, 1L, 2L);
	}

	// 카트 테이블에 데이터를 넣는다.
	public static void cartInsert(Long member_no, Long book_no, Long quantity) {

		CartDao cartDao = new CartDao();

		CartVo vo = new CartVo();

		vo.setMember_no(member_no);
		vo.setBook_no(book_no);
		vo.setQuantity(quantity);

		cartDao.insert(vo);

	}

}
