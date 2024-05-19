package p1;

public class MainRecursion {
	// recursion is when a method calls itself
	private static int count = 0;
	
	public static void main(String[] args) { // caller
		showMessage("Hi"); // callee
	}

	private static void showMessage(String message) {
		System.out.println(message);
		count++;
		
		if(count > 5) // base case
			return; // finish printing
		showMessage("Hi");
		
	}

	public static int sum(int x, int y) {
		return x + y;
	}
}
// a base case is a mechanism that stops the recursive call.
// a base case is always needed to properly implement recursion.

// call stack contains stack frames
// A stack frame contains:
// (1) an array of all local variables
// (2) Operand stack
// (3) meta data: fields and references of other method in the class