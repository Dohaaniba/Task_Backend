package com.taskpro.Taskpro.Dto;


public class UserDto {
	
	private Integer id;
	
	private String lastName;
	private String firstName;
	private String email;
	private String password;
	
	public UserDto() {}
	public UserDto(Integer id, String lastName , String firstName, String email , String password) {
		this.id=id;
		this.firstName=firstName;
		this.lastName= lastName;
		this.email= email;
		this.password= password;
		
	}
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
	public String ToString() {
		return "User { "
				+ "id" +id +
				" , lastname" + lastName +
				" ,firstName" + firstName +
				" ,email " + email +
				" password " + password +
				"}"
				
				
				;
		
	}

}
