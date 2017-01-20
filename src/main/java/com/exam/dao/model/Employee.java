package com.exam.dao.model;

public class Employee {
	
	private int id;
	private String name;
	private int age;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {

		return "Hello " + "I am " + this.name + ". I am " + this.age + "years old. My Id is :" + this.id;
	}

}
