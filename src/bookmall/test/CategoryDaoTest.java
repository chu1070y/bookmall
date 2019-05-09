package bookmall.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryDaoTest {
	
	private CategoryDao categoryDao = new CategoryDao();
	
	// 카테고리 테이블에 데이터를 넣는다.
	public void insertTest(String category) {
		
		CategoryVo vo = new CategoryVo();
		
		vo.setCategory(category);
		
		categoryDao.insert(vo);
		
	}
	
	// 카테고리 테이블 조회하기
	public void selectTest() {
		List<CategoryVo> list = categoryDao.getList();
		
		for(CategoryVo vo : list) {
			System.out.println("[카테고리목록] 카테고리: " + vo.getCategory());
		}
		
	}
}
