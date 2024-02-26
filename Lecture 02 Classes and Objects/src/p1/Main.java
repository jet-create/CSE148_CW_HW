package p1;

public class Main {

	public static void main(String[] args) {
		Book b1 = new Book(); // default constructor
								// special method used to create objects
		
//		System.out.println(b1.toString());
//		System.out.println(b1);
		
		Book b2 = new Book("HTML", "Jane Doe", 4.99);
		Book b3 = new Book("Javascript", "Joey Doe", 2.99);
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(b3);
		
		b3.setPrice(0.00);
		System.out.println(b3);
	}

}
