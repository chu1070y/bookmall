package bookmall.test;

import java.util.List;

import bookmall.dao.CategoryDao;
import bookmall.vo.CategoryVo;

public class CategoryDaoTest {
	
	private CategoryDao categoryDao = new CategoryDao();
	
	public void insertTest(String category) {
		
		CategoryVo vo = new CategoryVo();
		
		vo.setCategory(category);
		
		categoryDao.insert(vo);
		
	}
	
	public void selectTest() {
		List<CategoryVo> list = categoryDao.getList();
		
		for(CategoryVo vo : list) {
			System.out.println("[카테고리목록] 카테고리: " + vo.getCategory());
		}
		
	}
}
