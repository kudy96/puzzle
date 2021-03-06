package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.AddReportService;
import vo.Report;

@WebServlet("/TopReportMy")
public class TopReportMy extends HttpServlet {
	private AddReportService addReportService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		String loginState = request.getParameter("loginState");
		System.out.println(loginState);
		Report report = new Report();	
		report.setMemberId(loginState);
		addReportService = new AddReportService();		
		List<Report> list = addReportService.topReportMy(report);
		
		Gson gson = new Gson();
		String gsonStr = gson.toJson(list);
		System.out.println(gsonStr);
		response.getWriter().write(gsonStr);
	}

}
