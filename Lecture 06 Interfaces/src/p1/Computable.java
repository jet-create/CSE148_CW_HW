package p1;

// Like abstract classes, one cannot use an Interface to create an object
// Interfaces are used to define a datatype, like any classes
// An interface can have the following public methods:
//1. abstract methods without body
//2. static methods with body
//3. default methods with body

public interface Computable {
	// variables are all static, final, public
	double PI = 3.14159;
	
	double add(double n1, double n2);
	
	double subtract(double n1, double n2);
	
	static void printHello() {
		System.out.println("Hello");
	}
	
	default void printBye() {
		System.out.println("Bye");
	}
}


