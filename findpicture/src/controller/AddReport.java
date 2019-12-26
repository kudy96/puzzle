package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.AddReportService;
import vo.Report;

@WebServlet("/AddReport")
public class AddReport extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String loginState = request.getParameter("loginState");
		int timerNum = Integer.parseInt(request.getParameter("timerNum"));
		int total = Integer.parseInt(request.getParameter("total"));
		
		//System.out.println("memberId :"+ loginState);
		//System.out.println("timerNum :"+ timerNum);
		//System.out.println("total :"+ total);
			
		Report report = new Report();
		report.setMemberId(loginState);
		report.setTimer(timerNum);
		report.setCount(total);
		
		AddReportService addReportService = new AddReportService();
		addReportService.AddReport(report);
		
		Gson gson = new Gson();
		String gsonStr = gson.toJson(report);
		response.getWriter().write(gsonStr);
	}

}
