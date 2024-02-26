package p1_final;

public class Student extends Person {
	private final String ID;

	public Student(String name, double gpa, String ID) {
		super(name, gpa);
		this.ID = ID;
	}

	public String getID() {
		return ID;
	}

//	public void setID(String ID) {
//		this.ID = ID;
//	}
	

}
