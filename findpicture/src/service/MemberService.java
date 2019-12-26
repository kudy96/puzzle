package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDao;
import sun.security.pkcs11.Secmod.DbMode;
import vo.Member;

public class MemberService {
	
	public void delete(Member member) {
		Connection conn = null;
		
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			MemberDao memberDao = new MemberDao();
			memberDao.deleteMember(conn, member);
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void update(Member member) {
		Connection conn = null;
		
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			MemberDao memberDao = new MemberDao();
			memberDao.updateMember(conn, member);
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void join(Member member) {
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			MemberDao memberDao = new MemberDao();
			memberDao.joinMember(conn, member);
			conn.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public String login(Member member) {
		Member returnMember  = null;
		Connection conn = null;
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			MemberDao memberDao = new MemberDao();
			returnMember = memberDao.login(conn, member);
			conn.commit();
						
		} catch(Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return returnMember.getMemberId();
	}
}
