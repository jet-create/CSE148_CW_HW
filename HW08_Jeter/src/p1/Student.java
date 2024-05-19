package p1;

public class Student extends Person {
	private Major major;
	private double gpa;

	public Student(String name, double gpa, Major major) {
		super(name);
		this.major = major;
		this.gpa = gpa;
	}

	public Student(String name) {
		super(name);
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "Student [" + super.toString() + "=" + major + ", gpa=" + gpa + "]";
	}

}
