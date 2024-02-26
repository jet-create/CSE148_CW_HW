package p2;

public class Course {
	private String course;
	private double credits;
	private int numberOfStudents;
	
	public Course(String course, double credits, int numberOfStudents) {
		super();
		this.course = course;
		this.credits = credits;
		this.numberOfStudents = numberOfStudents;
	}

	public Course() {
//		super();
	}
	
	public Course(String course, double credits) {
		super();
		this.course = course;
		this.credits = credits;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public double getCredits() {
		return credits;
	}

	public void setCredits(double credits) {
		this.credits = credits;
	}

	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(int numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	@Override
	public String toString() {
		return "Course [course=" + course + ", credits=" + credits + ", numberOfStudents=" + numberOfStudents + "]";
	}

	
	
}
