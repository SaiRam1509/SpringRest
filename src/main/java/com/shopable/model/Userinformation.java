package com.shopable.model;



public class Userinformation {
   
	
	private String username;

     private String password;
     
     
	public String getUsername() {
		return username;
	}
	public void setUsername(String userid) {
		this.username = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	  @Override
		public String toString() {
			return "Userinformation [user_id=" + username + ", password=" + password + "]";
		}
}
