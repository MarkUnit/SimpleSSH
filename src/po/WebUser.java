package po;

import javax.persistence.Id;

import org.hibernate.annotations.Entity;

@Entity
public class WebUser {
	private int id;
	private String username;
	private String psw;
	
	@Id
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPsw() {
		return psw;
	}
	public void setPsw(String psw) {
		this.psw = psw;
	}
}
