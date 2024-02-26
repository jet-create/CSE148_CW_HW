package p8;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Rectangle[] rectangle = new Rectangle[3];

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			System.out.println("Length of Rectangle " + (i + 1) + ":");
			double length = sc.nextDouble();

			System.out.println("Width of Rectangle " + (i + 1) + ":");
			double width = sc.nextDouble();

			rectangle[i] = new Rectangle(length, width);
		}

		double totalArea = 0.0;
		for (int i = 0; i < 3; i++) {
			totalArea += rectangle[i].calculateArea();
		}

		for (int i = 0; i < 3; i++) {
			System.out.printf("\nRoom " + (i + 1) + "'s area: %.2f", rectangle[i].calculateArea());
		}

		System.out.printf("\nTotal Area: %.2f", totalArea);

		sc.close();
	}

}
