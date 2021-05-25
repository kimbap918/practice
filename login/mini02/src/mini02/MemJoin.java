package mini02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/join")
public class MemJoin extends HttpServlet{
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
		MemberDAO dao = new MemberDAO();
		MemberVO vo = new MemberVO();		
		
		if(com != null && com.equals("addMember")) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String custRank = request.getParameter("custRank");
			vo.setID(id);
			vo.setPWD(pwd);
			vo.setName(name);
			vo.setEmail(email);
			vo.setCustRank(custRank);
			dao.addMember(vo);
		}else if(com != null && com.equals("delMember")) {
			String id = request.getParameter("id");
			dao.delMember(id);
		}
		out.print("<a href='http://localhost:8090/mini02/login.html'>");
		
		out.print("<html><body>");
		out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
		out.print("<td>���̵�</td><td>��й�ȣ</td><td>�̸�</td><td>�̸���</td><td>������</td></tr>");
		
		List<MemberVO> list = dao.listMembers();
		
		for(int i = 0; i < list.size(); i++) {
			MemberVO membervo = list.get(i);
			String id = membervo.getID();
			String pwd = membervo.getPWD();
			String name = membervo.getName();
			String email = membervo.getEmail();
			Date joinDate = membervo.getJoinDate();
			
			out.print("<tr><td>" + id + "</td><td>" + pwd + "</td><td>" + name 
					+ "</td><td>"  + email + "</td><td>"  + joinDate + "</td><tr>" );
		} //for
		out.print("<a href='http://localhost:8090/mini02/login.html'>"+
		"<input type='button' value='�α���ȭ��'>");
		out.print("</table></body></html>");
		 /**/
	}
	
}
