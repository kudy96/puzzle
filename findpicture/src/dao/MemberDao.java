package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Member;

public class MemberDao {
	
	public void deleteMember(Connection conn, Member member) throws Exception{
		PreparedStatement stmt = null;
		String sql = "delete from member where member_id=?";		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			stmt.close();
		}
	}
	
	public void updateMember(Connection conn,Member member) throws Exception{
		
		PreparedStatement stmt = null;		
		String sql = "update member set member_pw=? where member_id=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberPw());
			stmt.setString(2, member.getMemberId());
			stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			stmt.close();
		}
	}
	
	public void joinMember(Connection conn, Member member) throws Exception {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("insert into member(member_id, member_pw, member_level) values(?,?,'Y')");
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			stmt.close();
		}
	}	
		
	public Member login(Connection conn, Member member) throws Exception {
		Member returnMember = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select member_id from member where member_id=? and member_pw=? and member_level='Y'";
		try {
			returnMember = new Member();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, member.getMemberId());
			stmt.setString(2, member.getMemberPw());
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				returnMember.setMemberId(rs.getString("member_id"));
			}
		}finally {
			try {
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return returnMember;
	}
}
