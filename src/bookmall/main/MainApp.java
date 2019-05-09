package bookmall.main;

import bookmall.test.BookDaoTest;
import bookmall.test.CartDaoTest;
import bookmall.test.CategoryDaoTest;
import bookmall.test.MemberDaoTest;
import bookmall.test.OrderDaoTest;

public class MainApp {

	static MemberDaoTest memberDaoTest = new MemberDaoTest();
	static CategoryDaoTest categoryDaoTest = new CategoryDaoTest();
	static BookDaoTest bookDaoTest = new BookDaoTest();
	static CartDaoTest cartDaoTest = new CartDaoTest();
	static OrderDaoTest orderDaoTest = new OrderDaoTest();
	
	public static void insertall() {
		// 회원 넣기
		memberDaoTest.insertTest("피카츄", "010-1234-5678", "pika1004@pokemon.com", "pikapika7");
		memberDaoTest.insertTest("잠만보", "010-5959-8282", "sleepKing@hungry.com", "givemefood8282");
		
		//카테고리 넣기
		categoryDaoTest.insertTest("소설");
		categoryDaoTest.insertTest("인문");
		categoryDaoTest.insertTest("IT");
		
		// 도서 넣기
		bookDaoTest.insertTest("오만과 편견", 30000L, 1L);
		bookDaoTest.insertTest("삼국지 경영학", 25000L, 2L);
		bookDaoTest.insertTest("인사이드 자바스크립트", 20000L, 3L);
		
		// 카드 넣기
		cartDaoTest.insertTest(1L, 3L, 5L);
		cartDaoTest.insertTest(1L, 1L, 2L);
		
		// 주문 넣기
		orderDaoTest.insertTest(1L, "포켓몬월드 관동지방 태초마을 22번지");
	}

	public static void main(String[] args) {
		
		// insert 모아놓음
		insertall();
		
		System.out.println("반갑습니다");
		System.out.println("고객의, 고객에 의한, 고객을 위한 ");
		System.out.println("비트비트 서점입니다!");
		System.out.println("");
		
		// 회원 리스트 출력
		System.out.println("----------------------회원 리스트----------------------");
		memberDaoTest.selectTest();

		// 카테고리 리스트 출력
		System.out.println("\n----------------------카테고리 리스트----------------------");
		categoryDaoTest.selectTest();
		
		// 도서 리스트 출력
		System.out.println("\n----------------------도서 리스트----------------------");
		bookDaoTest.selectTest();
		
		// 카트 리스트 출력
		System.out.println("\n----------------------카트 리스트----------------------");
		cartDaoTest.selectTest();
		
		// 주문 리스트 출력
		System.out.println("\n----------------------주문 리스트----------------------");
		orderDaoTest.selectOrderTest();
		
		// 주문 도서 리스트 출력
		System.out.println("\n----------------------주문 도서 리스트----------------------");
		orderDaoTest.selectOrderBookTest();
		
	}
}
