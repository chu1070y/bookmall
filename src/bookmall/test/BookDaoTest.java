package bookmall.test;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookDaoTest {

	public static void main(String[] args) {

		// 도서 넣기
		bookInsert("오만과 편견", 30000L, 1L);
		bookInsert("삼국지 경영학", 25000L, 2L);
		bookInsert("인사이드 자바스크립트", 20000L, 3L);
	}

	// 도서 테이블에 데이터를 넣는다.
	public static void bookInsert(String title, Long price, Long category_no) {

		BookDao bookDao = new BookDao();

		BookVo vo = new BookVo();

		vo.setTitle(title);
		vo.setPrice(price);
		vo.setCategory_no(category_no);

		bookDao.insert(vo);

	}

}
