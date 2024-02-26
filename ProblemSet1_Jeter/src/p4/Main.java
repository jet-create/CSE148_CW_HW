package p4;

public class Main {

	public static void main(String[] args) {
		Student s1 = new Student("Jeter", 2.9);
		System.out.println(s1);

		double curveGpa = s1.curveAmount();
		System.out.printf("GPA after curve: %.2f", curveGpa);
	}

}
