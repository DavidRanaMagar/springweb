package com.spring.stock.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_info")
public class UserInfo {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private int uId;
    private String email;
	private String name;
	private String address;
	private int age;
	private String contactNo;
	public UserInfo() {
	}
	public UserInfo(int uId, String email,String name, String address, int age, String contactNo) {
		this.uId = uId;
                this.email=email;
		this.name = name;
		this.address = address;
		this.age = age;
		this.contactNo = contactNo;
	}
	public UserInfo(String name, String email, String address, int age, String contactNo) {
		super();
		this.name = name;
                this.email=email;
		this.address = address;
		this.age = age;
		this.contactNo = contactNo;
	}
	public int getuId() {
		return uId;
	}
	public void setuId(int uId) {
		this.uId = uId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
	
}
