package mini02;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
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
			
			// 1. mysql DB 연결 관련 정보
			String url = "jdbc:mysql://choicho.mysql.database.azure.com:3306/?autoReconnect=true&amp;serverTimezone=UTC";
		    String username = "choi_admin@choicho";
		    String password = "jun901800!";
		    String driver = "org.gjt.mm.mysql.Driver";
			
		    // 2. 드라이버 로딩
			Class.forName(driver);
			
			// 3. mysql 서버 연결
			con = DriverManager.getConnection(url, username, password);

			
			Context ctx = new InitialContext();
            //ctx의 lookup메서드를 이용해서 "java:comp/env" 에 해당하는 객체를 찾아서 evnCtx에 삽입
			Context evnCtx = (Context)ctx.lookup("java:/comp/env");
            //envCtx의 lookup메서드를 이용해서 "jdbc/orcl"에 해당하는 객체를 찾아서 dataFactory에 삽입
			dataFactory = (DataSource)evnCtx.lookup("jdbc/mysql");
			
		    
		}catch (Exception e) {
			System.out.println("연동실패 : " + e);
		}
	}
	 
	/*Context context = new InitialContext();
    DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
    Connection con = dataSource.getConnection(); */
   
	public MemberVO getMember(String ID) {
		MemberVO vo = new MemberVO();
		ResultSet rs = null;
		try {
			con = dataFactory.getConnection();
			String query = "select * FROM shop_db.customer_manage WHERE id=?";
			pst = con.prepareStatement(query);
			pst.setString(1, ID);
			rs = pst.executeQuery();
			if(rs.next()) {
				vo.setID(rs.getString("id"));
				vo.setPWD(rs.getString("pwd"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
				vo.setCustRank(rs.getString("custRank"));
				
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
			String pwd =  memberVO.getPWD();
			String name =  memberVO.getName();
			String email = memberVO.getEmail();
			String custRank = memberVO.getCustRank();
			
			String query = "insert into shop_db.customer_manage";
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
				pst.setString(5, custRank);
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
			String query = "delete from shop_db.customer_manage" + " where id=?";
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
			String query = "update shop_db.customer_manage set pwd=?, name=?, email=? where id=?";
			System.out.println("preapareStatement: " + query);
			con = dataFactory.getConnection();
			pst = con.prepareStatement(query);
			
			pst.setString(1, vo.getPWD());
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
			String query = "select * from shop_db.customer_manage";
			System.out.println("preapareStatement: " + query);
			pst = con.prepareStatement(query);
			ResultSet rs = pst.executeQuery(query);
			while(rs.next()){
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				String custRank = rs.getString("custRank");
				
				MemberVO vo = new MemberVO();
				vo.setID(id);
				vo.setPWD(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				vo.setCustRank(custRank);
				
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
			String query = "select * from shop_db.customer_manage ORDER BY x=?";
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
				String custRank = rs.getString("custRank");
				
				MemberVO vo = new MemberVO();
				vo.setID(id);
				vo.setPWD(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				vo.setCustRank(custRank);
				
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

