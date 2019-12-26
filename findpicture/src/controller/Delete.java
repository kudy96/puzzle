package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import service.MemberService;
import vo.Member;

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private MemberService memberService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		
		String loginState = request.getParameter("loginState");
		System.out.println("loginState : " + loginState);
		
		Member member = new Member();
		member.setMemberId(loginState);
		
		memberService = new MemberService();
		memberService.delete(member);
		
		Gson gson = new Gson();
		String gsonStr = gson.toJson(member);
		response.getWriter().write(gsonStr);
		
	}

}
