package p1;

public class Student {
	private String name;
	private double gpa;
	private int age;
	private static String collegeName;

// 	Methods - Getters
	public String getName() {
		return name;
	}

	public double getGpa() {
		return gpa;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getCollegeName() {
		return collegeName;
	}
	
//	Methods - Setters
	public void setName(String newName) {
		name = newName;
	}
	
	public void setGpa(double newGpa) {
		gpa = newGpa;
	}
	
	public void setAge(int newAge) {
		age = newAge;
	}
	
	public void setCollegeName(String newCollegeName) {
		collegeName = newCollegeName;
	}
	
	public void doHomework() {
		System.out.println("Doing homework");
	}
	
	public String submitHomework(String hw) {
		return hw;
	}
}
