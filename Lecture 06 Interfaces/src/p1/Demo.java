package p1;

public class Demo {

	public static void main(String[] args) {
		Computable c1; // allowed to declare datatype;
	//	c1 = new Computable(); not allowed to create object, same as in abstract class
		
		Computable calc1 = new Calculator();
		calc1.printBye(); // using default method
		Computable.printHello(); // using the static method
		System.out.println(calc1.add(1.5, 2.5));
		System.out.println(calc1.subtract(1.5, 2.5));
//		System.out.println(Computable.PI); not allowed because it is always public static final

	}

}
