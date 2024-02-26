package pt;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Circle[] circle = new Circle[2];

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 2; i++) {
			System.out.println("Enter radius of cirlce " + (i + 1) + ":");
			double radius = sc.nextDouble();

			circle[i] = new Circle(radius);
		}

		for (int i = 0; i < 2; i++) {
			System.out.println(circle[i].toString());
		}
	}

}
