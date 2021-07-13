package com.cg.mts.dto;

public class CustomerDto {
	private Integer customerId;
	private String username;
	private String password;
	private String mobileNumber;
	private String email;
	private String address;

	public CustomerDto() {
		super();
	}

	public CustomerDto(Integer customerId, String username, String password, String mobileNumber, String email,
			String address) {
		super();
		this.customerId = customerId;
		this.username = username;
		this.password = password;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
	}

	public CustomerDto(Integer customerId) {
		super();
		this.customerId = customerId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}