package bookmall.main;

import java.util.List;

import bookmall.dao.BookDao;
import bookmall.dao.CartDao;
import bookmall.dao.CategoryDao;
import bookmall.dao.MemberDao;
import bookmall.dao.OrderDao;
import bookmall.vo.BookVo;
import bookmall.vo.CartVo;
import bookmall.vo.CategoryVo;
import bookmall.vo.MemberVo;
import bookmall.vo.OrderVo;

public class MainApp {

	public static void main(String[] args) {
		
		System.out.println("반갑습니다");
		System.out.println("고객의, 고객에 의한, 고객을 위한 ");
		System.out.println("비트비트 서점입니다!");
		
		// 회원 리스트 출력
		System.out.println("\n----------------------회원 리스트----------------------");
		memberList();

		// 카테고리 리스트 출력
		System.out.println("\n----------------------카테고리 리스트----------------------");
		categoryList();
		
		// 도서 리스트 출력
		System.out.println("\n----------------------도서 리스트----------------------");
		bookList();
		
		// 카트 리스트 출력
		System.out.println("\n----------------------카트 리스트----------------------");
		cartList();
		
		// 주문 리스트 출력
		System.out.println("\n----------------------주문 리스트----------------------");
		orderList();
		
		// 주문 도서 리스트 출력
		System.out.println("\n----------------------주문 도서 리스트----------------------");
		orderBookList();
		
	}
	
	public static void memberList() {
		MemberDao memberDao = new MemberDao();
		
		List<MemberVo> list = memberDao.getList();
		
		for(MemberVo vo : list) {
			System.out.println("[회원목록] 이름: " + vo.getName() + ", 전화번호: " + vo.getTel() + ", 이메일: " + vo.getEmail() + ", 비밀번호: " + vo.getPw());
		}
	}
	
	public static void categoryList() {
		CategoryDao categoryDao = new CategoryDao();
		
		List<CategoryVo> list = categoryDao.getList();
		
		for(CategoryVo vo : list) {
			System.out.println("[카테고리목록] 카테고리: " + vo.getCategory());
		}
	}
	
	public static void bookList() {
		BookDao bookDao = new BookDao();
		
		List<BookVo> list = bookDao.getList();
		
		for(BookVo vo : list) {
			System.out.println("[도시목록] 도서제목: " + vo.getTitle() + ", 가격: " + vo.getPrice() + ", 카테고리: " + vo.getCategory());
		}
	}
	
	public static void cartList() {
		CartDao cartDao = new CartDao();
		
		List<CartVo> list = cartDao.getList();
		
		for(CartVo vo : list) {
			System.out.println("[카트목록] 도서제목: " + vo.getTitle() + ", 카테고리: " + vo.getCategory() + ", 수량: " + vo.getQuantity() + ", 가격: " + vo.getPrice() + ", 주문자: " + vo.getName());
		}
	}
	
	public static void orderList() {
		OrderDao orderDao = new OrderDao();
		
		List<OrderVo> list = orderDao.getOrderList();
		
		for(OrderVo vo : list) {
			System.out.println("[주문목록] 주문번호: " + vo.getOrder_no() + ", 주문자: " + vo.getName() + "/" + vo.getEmail() + ", 결제금액: " + vo.getAmount() + ", 배송지: " + vo.getLocation());
		}
	}
	
	public static void orderBookList() {
		OrderDao orderDao = new OrderDao();
		
		List<CartVo> list = orderDao.getOrderBookList();
		
		for(CartVo vo : list) {
			System.out.println("[주문도서목록] 도서번호: " + vo.getBook_no() + ", 도서제목: " + vo.getTitle() + ", 수량: " + vo.getQuantity() + ", 도서분류: " + vo.getCategory());
		}

	}
	
}
