package com.global.biz.user.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.global.biz.comon.JDBCUtil;
import com.global.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO {
// JDBC 관련 변수
	private Connection conn = null;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	
	// sql 명령(사용자 상세정보를 가져옴)
	private final String USER_GET =
			"select * from users where id=? and password=?";
	
	//CRUD 기능의 메소드 구현
	// 회원 등록
	public UserVO getUser(UserVO vo) {
		
		UserVO user = null;
		
		try {
			System.out.println("===> JDBC로 getUser() 기능 처리....");
			conn = JDBCUtil.getConnection();
			
			stmt = conn.prepareStatement(USER_GET);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("ROLE"));
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs, stmt, conn);
		}
		return user;
	}
}
