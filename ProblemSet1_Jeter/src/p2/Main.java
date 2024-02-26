package p2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("What is the circle's radius?");
		double radius = sc.nextDouble();

		Circle c1 = new Circle();

		c1.setRadius(radius);

		double area = c1.getArea();
		double diameter = c1.getDiameter();
		double circumference = c1.getCircumference();

		System.out.printf("Radius: %.3f\n", radius);
		System.out.printf("Area: %.3f\n", area);
		System.out.printf("diameter: %.3f\n", diameter);
		System.out.printf("Circumeference: %.3f\n", circumference);

		sc.close();
	}

}
