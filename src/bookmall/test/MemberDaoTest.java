package bookmall.test;

import java.util.List;

import bookmall.dao.MemberDao;
import bookmall.vo.MemberVo;

public class MemberDaoTest {
	
	private MemberDao memberDao = new MemberDao();
	
	public void insertTest(String name, String tel, String email, String pw) {
		
		MemberVo vo = new MemberVo();
		
		vo.setName(name);
		vo.setTel(tel);
		vo.setEmail(email);
		vo.setPw(pw);
		
		memberDao.insert(vo);
		
	}
	
	public void selectTest() {
		
		List<MemberVo> list = memberDao.getList();
		
		for(MemberVo vo : list) {
			System.out.println("[회원목록] 이름: " + vo.getName() + ", 전화번호: " + vo.getTel() + ", 이메일: " + vo.getEmail() + ", 비밀번호: " + vo.getPw());
		}
		
	}

}
