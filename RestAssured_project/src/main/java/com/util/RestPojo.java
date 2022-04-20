package com.util;

public class RestPojo {
	
	private String email;
	private String password;
	
	public RestPojo(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	
	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	
	
	
	
	
	/*public String getName() {
		return name;
	}
	
	public void setName(String myname) {
		name = myname;
	}*/
	
	/*public static void main(String[] args)
	{
		RestPojo r = new RestPojo();
		r.setName("Chai");
		System.out.println(r.getName());
	}*/
	
	@Override
	public String toString()
	{
		return "RestPojo[mail=" + this.email + ", password=" + this.password + "]";
	}

}
