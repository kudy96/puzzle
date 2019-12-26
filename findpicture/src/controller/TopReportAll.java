package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.AddReportService;
import vo.Report;

@WebServlet("/TopReportAll")
public class TopReportAll extends HttpServlet {
	private AddReportService addReportService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
				
		Report report = new Report();	
		addReportService = new AddReportService();		
		List<Report> list = addReportService.topReportAll(report);
		
		Gson gson = new Gson();
		String gsonStr = gson.toJson(list);
		System.out.println(gsonStr);
		response.getWriter().write(gsonStr);
		
	}

}
