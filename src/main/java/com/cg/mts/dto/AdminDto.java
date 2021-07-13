package com.cg.mts.dto;

public class AdminDto {
	private Integer adminId;
	private String username;
	private String password;
	private String mobileNumber;
	private String email;
	private String address;

	public AdminDto() {
		super();
	}

	public AdminDto(Integer adminId) {
		super();
		this.adminId = adminId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public AdminDto(Integer adminId, String username, String password, String mobileNumber, String email,
			String address) {
		super();
		this.adminId = adminId;
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
	}

	public Integer getAdminId() {
		return adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}