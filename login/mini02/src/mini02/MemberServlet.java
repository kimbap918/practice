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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member3")
public class MemberServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		doHandle(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException{
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		PrintWriter out = response.getWriter();
		String command = request.getParameter("command");
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("id");
		
		if (command != null && command.equals("addMember")){
			MemberVO vo = getVO(request);
			dao.addMember(vo);			
			response.sendRedirect("/mini02/login.jsp");//������ �̵�
		}else if(command != null && command.equals("del")){
			String id = request.getParameter("id");
			dao.delMember(id);
			response.sendRedirect("/mini02/MemberList.jsp");
		}else if(command != null && command.equals("change")){
			String id = request.getParameter("id");
			MemberVO vo = getVO(request);
			
			dao.revMember(vo); //id PWD name email
			
			vo = dao.getMember(id);
			
			session.setAttribute("id", vo.getID());
			session.setAttribute("pwd", vo.getPWD());
			session.setAttribute("name", vo.getName());
			session.setAttribute("email", vo.getEmail());
			session.setAttribute("custRank", vo.getCustRank());
			response.sendRedirect("/mini02/login.jsp");
		}
		
		if(userid != null && userid.equals("admin")) {
			List<MemberVO> list = dao.listMembers();
			out.print("<html><body>");
			out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
			out.print("<h1>�� ������ �ϲ���. ");
			out.print("<a href='http://localhost:8080/mini02/login.jsp'>"+ 
		     "<input type='button' value='�α׾ƿ�' ></a> </h1>");
			out.print("<td>ID</td><td>PWD</td><td>이름</td><td>EMAIL</td><td>유저등급</td></tr>");
			
			for(int i = 0; i < list.size(); i++){
				MemberVO memberVO = (MemberVO) list.get(i);
				String id = memberVO.getID();
				String pwd = memberVO.getPWD();
				String name = memberVO.getName();
				String email = memberVO.getEmail();
				Date joinDate = memberVO.getJoinDate();
				String custRank = memberVO.getCustRank();
				
				session.setAttribute("id", memberVO.getID());
				session.setAttribute("name", memberVO.getName());
				
				out.print("<form action='MemInfo.jsp' method='post'>"
						+ "<input type='hidden' name='command' value='change'>"
						+ "<td> <input type='text' name ='id' value='" + id + "' readonly='readonly'> </td>"
						+ "<td> <input type='text' name ='pwd' value='" + pwd + "'> </td>"
						+ "<td> <input type='text' name ='name' value='" + name + "'> </td>"
						+ "<td> <input type='text' name ='email' value='" + email + "'> </td>"
						+ "<td> " + joinDate + "</td>"
						+ "<td> <input type='text' name ='custRank' value='"+ custRank + "'> </td>"
						+ "<td> <button type='submit'> ���� </button> </td>"
						+ "<td> <a href='/mini02/member3?command=del&id="+ id + "'> ���� </a> </td>"
						+ "</tr> </form>" );
			}
			out.print("</table> </body> </html>");
		}
		
	}
	
	public MemberVO getVO(HttpServletRequest request) {
		String _id = request.getParameter("id");
		String _pwd = request.getParameter("pwd");
		String _name = request.getParameter("name");
		String _email = request.getParameter("email");
		String _custRank = request.getParameter("custRank");
		
		if(_custRank == null) {
			_custRank = "0";
		}
		
		MemberVO vo = new MemberVO();
		vo.setID(_id);
		vo.setPWD(_pwd);
		vo.setName(_name);
		vo.setEmail(_email);
		vo.setCustRank(_custRank);
		
		return vo;
	}
}

