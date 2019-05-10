package bookmall.test;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;

public class MemberDaoTest {

	public static void main(String[] args) {

		// 회원 넣기
		memberInsert("피카츄", "010-1234-5678", "pika1004@pokemon.com", "pikapika7");
		memberInsert("잠만보", "010-5959-8282", "sleepKing@hungry.com", "givemefood8282");
	}

	// 회원 테이블에 데이터를 넣는다
	public static void memberInsert(String name, String tel, String email, String pw) {

		MemberDao memberDao = new MemberDao();

		MemberVo vo = new MemberVo();

		vo.setName(name);
		vo.setTel(tel);
		vo.setEmail(email);
		vo.setPw(pw);

		memberDao.insert(vo);

	}

}
