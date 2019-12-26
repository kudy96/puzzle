package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import service.MemberService;
import vo.Member;

@WebServlet("/GetSessionInfo")
public class GetSessionInfo extends HttpServlet {
	private MemberService memberService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");		
		HttpSession session = request.getSession();	
		//session.setAttribute("dsad", "dasdas");
			
		String sessionInfo = (String)session.getAttribute("sessionInfo");
		//System.out.println(sessionInfo);
		
		Member member = new Member();
		memberService = new MemberService();
		memberService.login(member);
		
		Gson gson = new Gson();
		String json = gson.toJson(sessionInfo);
		//System.out.println(json);
		
		response.getWriter().write(json);
	}

}
