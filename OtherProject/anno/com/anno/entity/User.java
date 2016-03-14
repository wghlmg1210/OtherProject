package com.anno.entity;

import java.io.Serializable;

import com.anno.anno.Column;
import com.anno.anno.Table;

@Table("user")
public class User implements Serializable {

	private static final long serialVersionUID = -6077944280899179096L;

	@Column("username")
	private String username;

	@Column("age")
	private int age;

	@Column("sex")
	private String sex;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
