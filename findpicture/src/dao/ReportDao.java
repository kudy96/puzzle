package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.Report;

public class ReportDao {
	
	public List<Report> topReportMy(Connection conn, Report report){
		List<Report> list = new ArrayList<Report>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from report where member_id=? order by timer asc limit 10";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, report.getMemberId());
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				report = new Report();
				report.setReportId(rs.getInt("report_id"));
				report.setMemberId(rs.getString("member_id"));
				report.setCount(rs.getInt("count"));
				report.setReportDate(rs.getString("report_date"));
				report.setTimer(rs.getInt("timer"));
				list.add(report);			
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}
	
	public List<Report> topReportMonth(Connection conn, Report report){
		List<Report> list = new ArrayList<Report>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from report where month(report_date) = month(now()) order by timer asc limit 10";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				report = new Report();
				report.setReportId(rs.getInt("report_id"));
				report.setMemberId(rs.getString("member_id"));
				report.setCount(rs.getInt("count"));
				report.setReportDate(rs.getString("report_date"));
				report.setTimer(rs.getInt("timer"));
				list.add(report);			
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}
	
	
	public List<Report> topReportToday(Connection conn, Report report){
		List<Report> list = new ArrayList<Report>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from report where date(report_date) = date(now()) order by timer asc limit 10";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				report = new Report();
				report.setReportId(rs.getInt("report_id"));
				report.setMemberId(rs.getString("member_id"));
				report.setCount(rs.getInt("count"));
				report.setReportDate(rs.getString("report_date"));
				report.setTimer(rs.getInt("timer"));
				list.add(report);			
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}
	
	public List<Report> topReportAll(Connection conn, Report report) {
		List<Report> list = new ArrayList<Report>();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		String sql = "select * from report order by timer asc limit 10";
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				report = new Report();
				report.setReportId(rs.getInt("report_id"));
				report.setMemberId(rs.getString("member_id"));
				report.setCount(rs.getInt("count"));
				report.setReportDate(rs.getString("report_date"));
				report.setTimer(rs.getInt("timer"));
				list.add(report);			
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch(Exception e1) {
				e1.printStackTrace();
			}
		}
		return list;
	}
	
	public void addReport(Connection conn, Report report) {		
		PreparedStatement stmt = null;
		//System.out.println("DAo"+report.getCount());
		try {
			stmt = conn.prepareStatement("insert into report(member_id, report_date, count, timer) values(?,now(),?,?)");
			stmt.setString(1, report.getMemberId());
			stmt.setInt(2, report.getCount());
			stmt.setInt(3, report.getTimer());
			stmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
