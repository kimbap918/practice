package mini02;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LogIn extends HttpServlet{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String ut = "utf-8";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doHandle(request, response);
	}//doPost
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding(ut);
		response.setContentType("text/html;charset="+ut);
		PrintWriter out = response.getWriter();
		String com = request.getParameter("command");
		MemberVO vo = new MemberVO();
		MemberDAO dao = new MemberDAO();
		String id = "", PWD = "";
		
		if(com != null && com.equals("login")) {
			id = request.getParameter("id");
			PWD = request.getParameter("pwd");
			vo = dao.getMember(id);
		}
		
		if(id.equals("admin")) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			vo = dao.getMember(id);
			response.sendRedirect("/mini02/MemberList.jsp");//member3");
		}else{
			if(vo != null) {	
				if(PWD.equals(vo.getPWD())) {
					HttpSession session = request.getSession();
					//session.setAttribute("user", vo);
					session.setAttribute("id", vo.getID());
					session.setAttribute("pwd", vo.getPWD());
					session.setAttribute("name", vo.getName());
					session.setAttribute("email", vo.getEmail());
					session.setAttribute("CustRank", vo.getCustRank());
					response.sendRedirect("/mini02/MemInfo.jsp");
				}else {
					out.print("PWD Ʋ��<br>");
					out.print("<a href='/mini02/login.jsp'>"
							+ "<input type='button' value='�α���ȭ��'></a>");
				}
			}else {
				out.print("id ����<br>");
				out.print("<a href='/mini02/login.jsp'>"
						+ "<input type='button' value='�α���ȭ��'></a>");
			}
		}
	}

}
