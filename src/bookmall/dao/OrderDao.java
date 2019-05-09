package bookmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bookmall.vo.CartVo;
import bookmall.vo.OrderVo;

public class OrderDao extends ConnectionDao{
	
	public Boolean insertOrder(OrderVo vo) {
		Boolean result = false;
		
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			
			String sql = "insert into purchase values(null, " + 
					"(select concat(date_format(now(), '%Y%m%d'),'-',lpad((select count(*) + 1 from purchase c),5,'0'))), " + 
					"					(select sum(a.quantity * b.price) from (select * from cart where member_no = ?) a, book b where a.book_no = b.no), " + 
					"					?, ?)";
			pstmt = connection.prepareStatement(sql);
			
			pstmt.setLong(1, vo.getMember_no());
			pstmt.setString(2, vo.getLocation());
			pstmt.setLong(3, vo.getMember_no());

			
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
	
	public Boolean insertOrderBook() {
		Boolean result = false;
		
		Connection connection = null;
		PreparedStatement pstmt = null;

		try {
			connection = getConnection();
			
			List<Long> bookNoList =  getBookNo();

			for(int i = 0 ; i < bookNoList.size() ; i++) {
				String sql = "insert into order_book values(?,(select max(no) from purchase), " + 
						"(select quantity from cart where book_no = ? and member_no = (select member_no from purchase where no = (select max(no) from purchase))))";
				pstmt = connection.prepareStatement(sql);
			
				pstmt.setLong(1, bookNoList.get(i));
				pstmt.setLong(2, bookNoList.get(i));
			
				pstmt.executeUpdate();
			}

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
	
	public List<Long> getBookNo() {
		List<Long> result = new ArrayList<Long>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			connection = getConnection();
			
			String sql = "select book_no from cart where member_no = (select member_no from purchase where no = (select max(no) from purchase))";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long book_no = rs.getLong(1);
				
				result.add(book_no);
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
	
	public List<OrderVo> getOrderList(){
		List<OrderVo> result = new ArrayList<OrderVo>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			connection = getConnection();
			
			String sql = "select a.order_no, b.name, b.email, a.amount, a.location from purchase a, member b where a.member_no = b.no";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String order_no = rs.getString(1);
				String name = rs.getString(2);
				String email = rs.getString(3);
				Long amount = rs.getLong(4);
				String location = rs.getString(5);
				
				OrderVo vo = new OrderVo();
				vo.setOrder_no(order_no);
				vo.setName(name);
				vo.setEmail(email);
				vo.setAmount(amount);
				vo.setLocation(location);
				
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
	
	public List<CartVo> getOrderBookList(){
		List<CartVo> result = new ArrayList<CartVo>();
		
		Connection connection = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			
			connection = getConnection();
			
			String sql = "select c.book_no, d.title, c.quantity, d.category from order_book c, (select a.no, a.title, a.price, a.category_no, b.category from book a, category b where a.no = b.no) d " + 
					"where c.book_no = d.no";
			pstmt = connection.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Long book_no = rs.getLong(1);
				String title = rs.getString(2);
				Long quantity = rs.getLong(3);
				String category = rs.getString(4);
				
				CartVo vo = new CartVo();
				vo.setBook_no(book_no);
				vo.setTitle(title);
				vo.setQuantity(quantity);
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
