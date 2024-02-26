package p1;

public class Info {
	private String name;
	private String address;
	private int age;
	private String phoneNumber;
	
//	Personal Constructor
	public Info(String name, String address, int age, String phoneNumber) {
		this.name = name;
		this.address = address;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}
	
//	Getters
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getPhoneNumber() {
		return phoneNumber; 
	}
	
	public String toString() {
		return name + "\n" + address + "\n" + age + "\n" + phoneNumber;
	}
	
//	Setters
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
