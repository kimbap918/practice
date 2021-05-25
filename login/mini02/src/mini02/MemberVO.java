package mini02;

import java.sql.Date;

public class MemberVO {
	private String id, pwd, name, email, custRank;
	public String getCustRank() {
		return custRank;
	}
	public void setCustRank(String custRank) {
		this.custRank = custRank;
	}
	private Date joinDate;
	
	public String getID() {
		return id;
	}
	public void setID(String id) {
		this.id = id;
	}
	public String getPWD() {
		return pwd;
	}
	public void setPWD(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	
}
