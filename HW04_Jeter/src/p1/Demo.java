package p1;

public class Demo {

	public static void main(String[] args) {
		
		Shape c = new Circle(5.2);
		Shape r = new Rectangle(10.3, 4.23);
		
		System.out.println("Circle Area: " + c.area());
		System.out.println("Rectangle Area: " + r.area());
	}

}
