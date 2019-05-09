package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CategoryVo;

public class CategoryDao extends ConnectionDao{
	
	// 카테고리 테이블 데이터 추가
	public Boolean insert(CategoryVo vo) {
		Boolean result = false;
		
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			
			String sql = "insert into category values(null, ?)";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setString(1, vo.getCategory());
			
			int count = pstmt.executeUpdate();
			result = (count == 1);

		} catch (SQLException e) {
			System.out.println("error: " + e);

		} finally {
			try {
				
				if(pstmt != null) {
					pstmt.close();
				}
				
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	// 카테고리 테이블 조회하기
	public List<CategoryVo> getList(){
		List<CategoryVo> result = new ArrayList<CategoryVo>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			connection = getConnection();
			
			String sql = "select no, category from category";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long no = rs.getLong(1);
				String category = rs.getString(2);
				
				CategoryVo vo = new CategoryVo();
				vo.setNo(no);
				vo.setCategory(category);
				
				result.add(vo);
			}

		} catch (SQLException e) {
			System.out.println("error: " + e);

		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				
				if (connection != null) {
					connection.close();
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
