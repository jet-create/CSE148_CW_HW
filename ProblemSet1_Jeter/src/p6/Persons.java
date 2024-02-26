package p6;

public class Persons {
	private String name;
	private String socialSecNum;
	private int age;
	
	public Persons(String name, String socialSecNum, int age) {
		this.name = name;
		this.socialSecNum = socialSecNum;
		this.age = age;
	}
//	Setters
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSocialSecNum(String socialSecNum) {
		this.socialSecNum = socialSecNum;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
//	Getters
	
	public String getName() {
		return name;
	}
	
	public String getSocialSecNum() {
		return socialSecNum;
	}
	
	public int getAge() {
		return age;
	}
	
	public String toString() {
		return "Name: " + name +
				"\nSSN: " + socialSecNum +
				"\nAge: " + age;
	}
}
