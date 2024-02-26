package p9;

public class Student {
	private String firstLastName;
	private String studentID;
	private String[] courses;
	private double gpa;

	public Student(String firstLastName, String studentID, String[] courses, double gpa) {
		this.firstLastName = firstLastName;
		this.studentID = studentID;
		this.courses = courses;
		this.gpa = gpa;
	}

//	Setters
	public void setFirstName(String firstLastName) {
		this.firstLastName = firstLastName;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public void setCourses(String[] courses) {
		this.courses = courses;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

//	Getters
	public String getFirstLastName() {
		return firstLastName;
	}

	public String getStudentID() {
		return studentID;
	}

	public String[] getCourses() {
		return courses;
	}

	public double getGpa() {
		return gpa;
	}

	public String toString() {
		return "Name: " + firstLastName + "\n ID #: " + studentID + "\n Courses: " + courses + "\n GPA: " + gpa;
	}
}
