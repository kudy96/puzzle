package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ReportDao;
import vo.Report;

public class AddReportService {
	
	public List<Report> topReportMy(Report report){
		List<Report> list = new ArrayList<Report>();
		Connection conn = null;
		
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			ReportDao reportDao = new ReportDao();
			list = reportDao.topReportMy(conn, report);
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
		
		return list;
	}
	
	
	public List<Report> topReportMonth(Report report){
		List<Report> list = new ArrayList<Report>();
		Connection conn = null;
		
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			ReportDao reportDao = new ReportDao();
			list = reportDao.topReportMonth(conn, report);
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
		
		return list;
	}
	
	
	
	public List<Report> topReportToday(Report report){
		List<Report> list = new ArrayList<Report>();
		Connection conn = null;
		
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			ReportDao reportDao = new ReportDao();
			list = reportDao.topReportToday(conn, report);
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
		
		return list;
	}
	
	public List<Report> topReportAll(Report report){
		List<Report> list = new ArrayList<Report>();
		Connection conn = null;
		
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			ReportDao reportDao = new ReportDao();
			list = reportDao.topReportAll(conn, report);
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
		
		return list;
	}
	
	
	public void AddReport(Report report) {
		Connection conn = null;		
		try {
			DBService dbService = new DBService();
			conn = dbService.getConnection();
			conn.setAutoCommit(false);
			ReportDao reportDao = new ReportDao();
			reportDao.addReport(conn, report);
			//System.out.println("serv"+report.getCount());
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
}
