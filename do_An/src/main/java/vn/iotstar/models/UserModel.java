package vn.iotstar.models;

import java.io.Serializable;
import java.sql.Date;

public class UserModel implements Serializable {

	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String fullname;
	private Date createdDate;
	private String gender;
	private String email;
	private String phone;
	private String password;
	

	public UserModel() {
		super();
	}


	public UserModel(String username, String fullname, Date createdDate, String gender, String email, String phone,
			String password) {
		super();
		this.username = username;
		this.fullname = fullname;
		this.createdDate = createdDate;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}


	public UserModel(int id, String username, String fullname, Date createdDate, String gender, String email,
			String phone, String password) {
		super();
		this.id = id;
		this.username = username;
		this.fullname = fullname;
		this.createdDate = createdDate;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}


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


	public String getFullname() {
		return fullname;
	}


	public void setFullname(String fullname) {
		this.fullname = fullname;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", fullname=" + fullname + ", createdDate="
				+ createdDate + ", gender=" + gender + ", email=" + email + ", phone=" + phone + ", password="
				+ password + "]";
	}

	

}
