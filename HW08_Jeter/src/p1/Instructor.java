package p1;

public class Instructor extends Person {
	private double salary;
	private Rank rank;

	public Instructor(String name, double salary, Rank rank) {
		super(name);
		this.salary = salary;
		this.rank = rank;
	}

	public Instructor(String id, String name) {
		super(name);
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "Instructor [" + super.toString() + "=" + salary + ", rank=" + rank + "]";
	}

}
