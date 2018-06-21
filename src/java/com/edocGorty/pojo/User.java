package com.edocGorty.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private int id; //主键id
	private String name;//姓名
	private  String username;//登录名
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User() {
	}

	public User(int id, String name, String username) {
		this.id = id;
		this.name = name;
		this.username = username;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
