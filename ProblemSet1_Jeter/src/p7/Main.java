package p7;

public class Main {

	public static void main(String[] args) {
		Car c1 = new Car("Bergundy", 2013, "Honda", 92.7);

		System.out.println(c1);

		c1.speedUp();
		c1.speedUp();
		c1.speedUp();
		c1.speedUp();
		c1.speedUp();

		c1.slowDown();
		c1.slowDown();
		c1.slowDown();
		c1.slowDown();

//		double c1Speed = c1.getSpeed();
		System.out.printf("New speed of car is %.1f mph", c1.getSpeed());
	}

}
