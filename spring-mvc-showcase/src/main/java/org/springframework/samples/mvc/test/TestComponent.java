package org.springframework.samples.mvc.test;

import org.springframework.stereotype.Component;

@Component("component")
public class TestComponent {

	private String userName;
	
	private int age;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
