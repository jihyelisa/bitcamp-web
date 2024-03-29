package io;

import java.io.Serializable;

public class PersonDTO implements Serializable {
	//Serializable은 인터페이스지만 추상메소드가 없어 오버라이딩 할 필요 x
	
	private String name;
	private int age;
	private double height;
	
	public PersonDTO(String name, int age, double height) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
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
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}

}
