package com.rackathon.vo;


public class LoginVO {
	
	private String UserID;
	private String Password;
	
	public LoginVO() {}
	
	public LoginVO(String userid, String password) {
		this.UserID=userid;
		this.Password=password;
	}
	
	public String getUserid() {
		return UserID;
	}

	public void setUserid(String userid) {
		this.UserID = userid;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	} 
	
    @Override
    public String toString() {
        return "LoginVO{" +
                "UserID" + UserID +
                ", Password='" + Password +
                '}';
    }
}
