package mini02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class MemberDAO {
	private Connection con;
	private PreparedStatement pst;
	private DataSource dataFactory;
	ResultSet rs;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context evnCtx = (Context)ctx.lookup("java:/comp/env");
			dataFactory = (DataSource)evnCtx.lookup("jdbc/oracle");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MemberVO getMember(String ID) {
		MemberVO vo = new MemberVO();
		ResultSet rs = null;
		try {
			con = dataFactory.getConnection();
			String query = "select * FROM t_member WHERE ID=?";
			pst = con.prepareStatement(query);
			pst.setString(1, ID);
			rs = pst.executeQuery();
			if(rs.next()) {
				vo.setID(rs.getString("ID"));
				vo.setPW(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setGrade(rs.getString("grade"));
				
			}else{
				vo = null;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(con != null) con.close();
				if(pst != null) pst.close();
				if(rs != null) rs.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	public void addMember(MemberVO memberVO){
		try{
			con = dataFactory.getConnection();
			String id =  memberVO.getID();
			String pwd =  memberVO.getPW();
			String name =  memberVO.getName();
			String email = memberVO.getEmail();
			String grade = memberVO.getGrade();
			
			String query = "insert into t_member";
			query += " (id, pwd, name, email, grade)";
			query += " values(?, ?, ?, ?, ?)";
			System.out.println("preapareStatement: " + query);
			pst = con.prepareStatement(query);
			pst.setString(1, id);
			pst.setString(2, pwd);
			pst.setString(3, name);
			pst.setString(4, email);
			
			if(id.equals("admin")) {
				pst.setString(5, "1");
			} else {
				pst.setString(5, grade);
			}
			pst.executeUpdate();
		
			pst.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void delMember(String id){
		try{
			con = dataFactory.getConnection();
			String query = "delete from t_member" + " where id=?";
			System.out.println("preapareStatement: " + query);
			pst = con.prepareStatement(query);
			pst.setString(1, id);
			pst.executeUpdate();
			pst.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void revMember(MemberVO vo){
		try{
											//pwd, name, email, id
			String query = "update t_member set pwd=?, name=?, email=? where id=?";
			System.out.println("preapareStatement: " + query);
			con = dataFactory.getConnection();
			pst = con.prepareStatement(query);
			
			pst.setString(1, vo.getPW());
			pst.setString(2, vo.getName());
			pst.setString(3, vo.getEmail());
			pst.setString(4, vo.getID());
			pst.executeUpdate();
			pst.close();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	//////////////////////////////////////////////////
		
	public List<MemberVO> listMembers(){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try{
			con = dataFactory.getConnection();
			String query = "select * from t_member";
			System.out.println("preapareStatement: " + query);
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			while(rs.next()){
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				String grade = rs.getString("grade");
				
				MemberVO vo = new MemberVO();
				vo.setID(id);
				vo.setPW(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				vo.setGrade(grade);
				
				list.add(vo);
			}
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List<MemberVO> listMember(String x){
		List<MemberVO> list = new ArrayList<MemberVO>();
		try{
			con = dataFactory.getConnection();
			String query = "select * from t_member ORDER BY x=?";
			System.out.println("preapareStatement: " + query);
			pst = con.prepareStatement(query);
			pst.setString(1, x);
			ResultSet rs = pst.executeQuery(query);
			while(rs.next()){
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				String grade = rs.getString("grade");
				
				MemberVO vo = new MemberVO();
				vo.setID(id);
				vo.setPW(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				vo.setGrade(grade);
				
				list.add(vo);
			}
			rs.close();
			pst.close();
			con.close();
		} catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}
}
