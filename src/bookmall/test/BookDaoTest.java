package bookmall.test;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.vo.BookVo;

public class BookDaoTest {
	
	private BookDao bookDao = new BookDao();
	
	// 도서 테이블에 데이터를 넣는다.
	public void insertTest(String title, Long price, Long category_no) {
		
		BookVo vo = new BookVo();
		
		vo.setTitle(title);
		vo.setPrice(price);
		vo.setCategory_no(category_no);
		
		bookDao.insert(vo);
		
	}
	
	// 도서 테이블 조회하기
	public void selectTest() {
		List<BookVo> list = bookDao.getList();
		
		for(BookVo vo : list) {
			System.out.println("[도시목록] 도서제목: " + vo.getTitle() + ", 가격: " + vo.getPrice() + ", 카테고리: " + vo.getCategory());
		}
		
	}
}
