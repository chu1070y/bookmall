package bookmall.test;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {

		// 카테고리 넣기
		categoryInsert("소설");
		categoryInsert("인문");
		categoryInsert("IT");

	}

	// 카테고리 테이블에 데이터를 넣는다.
	public static void categoryInsert(String category) {

		CategoryDao categoryDao = new CategoryDao();

		CategoryVo vo = new CategoryVo();

		vo.setCategory(category);

		categoryDao.insert(vo);

	}

}
