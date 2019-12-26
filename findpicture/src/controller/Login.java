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

@WebServlet("/Login")
public class Login extends HttpServlet {
	private MemberService memberService;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");		
		HttpSession session = request.getSession();
		
		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		//System.out.println("memberId :"+ memberId);
		//System.out.println("memberPw :"+ memberPw);
		
		Member member = new Member();
		member.setMemberId(memberId);
		member.setMemberPw(memberPw);				
		
		memberService = new MemberService();		
		String sessionInfo = memberService.login(member);
		
		session.setAttribute("sessionInfo", sessionInfo);
		
		Gson gson = new Gson();
		String gsonStr = gson.toJson(sessionInfo);
		response.getWriter().write(gsonStr);
	
	}

}
