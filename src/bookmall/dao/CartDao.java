package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CartVo;

public class CartDao extends ConnectionDao{
	
	// 카트 테이블 데이터 추가하기
	public Boolean insert(CartVo vo) {
		Boolean result = false;
		
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			
			String sql = "insert into cart values(?, ?, ?)";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getMember_no());
			pstmt.setLong(2, vo.getBook_no());
			pstmt.setLong(3, vo.getQuantity());
			
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
	
	// 카트 테이블 조회하기
	public List<CartVo> getList(){
		List<CartVo> result = new ArrayList<CartVo>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			connection = getConnection();
			
			String sql = "select a.member_no, a.book_no, a.quantity, b.title, b.price, b.category, c.name " + 
					"from cart a, (select a.no, a.title, a.price, a.category_no, b.category from book a, category b where a.no = b.no) b, member c " + 
					"where a.book_no = b.no and a.member_no = c.no";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long member_no = rs.getLong(1);
				Long book_no = rs.getLong(2);
				Long quantity = rs.getLong(3);
				String title = rs.getString(4);
				Long price = rs.getLong(5);
				String category = rs.getString(6);
				String name = rs.getString(7);
				
				CartVo vo = new CartVo();
				vo.setMember_no(member_no);
				vo.setBook_no(book_no);
				vo.setQuantity(quantity);
				vo.setTitle(title);
				vo.setPrice(price);
				vo.setCategory(category);
				vo.setName(name);
				
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
