package bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * 중복되는 코드를 상위 클래스에 명시하고
 * 하위클래스에서 자유롭게 사용하도록 만든다.
 * 템플릿 메소드 패턴 적용
 * */
public class ConnectionDao {

	protected Connection getConnection() throws SQLException {
		Connection connection = null;
		
		try {
			
			Class.forName("org.mariadb.jdbc.Driver");
			String url = "jdbc:mariadb://192.168.1.17:3307/bookmall";
			connection = DriverManager.getConnection(url, "bookmall", "bookmall");
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패:" + e);
		}
		
		return connection;
	}

}
