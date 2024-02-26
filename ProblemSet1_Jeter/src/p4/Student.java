package p4;

public class Student {
	private String name;
	private double gpa;
	
	public Student(String name, double gpa) {
		this.name = name;
		this.gpa = gpa;
	}
	
//	Setters
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
//	Getters 
	
	public String getName() {
		return name;
	}
	
	public double getGpa() {
		return gpa;
	}
	
	public double curveAmount() {
		return gpa + 0.2;
	}
	
	public String toString() {
		return "Student name: "+ name + "\nGPA: "+ gpa;
	}
}
