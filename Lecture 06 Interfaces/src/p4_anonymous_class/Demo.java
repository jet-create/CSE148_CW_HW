package p4_anonymous_class;

public class Demo {

	public static void main(String[] args) {
		double gpa = 2.5;
		
		GPACurveable c1 = new GPACurveable() {

			@Override
			public double curveGpa(double amount) {
				return gpa + amount;
			}
		};
		
		System.out.println(c1.curveGpa(0.5));
	}

}
