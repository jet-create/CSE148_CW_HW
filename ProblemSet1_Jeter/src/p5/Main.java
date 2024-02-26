package p5;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Book[] books = new Book[2];

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 2; i++) {
			System.out.println("Enter Book " + (i + 1) + "'s Information Below");

			System.out.println("Book " + (i + 1) + " Name:");
			String title = sc.nextLine();

			System.out.println("Book " + (i + 1) + " Author:");
			String author = sc.nextLine();

			System.out.println("Book " + (i + 1) + " Price:");
			double price = sc.nextDouble();
			sc.nextLine();

			books[i] = new Book(title, author, price);
		}

		for (int i = 0; i < 2; i++) {
			System.out.println(books[i]);
		}

		sc.close();

//		System.out.println("Book 1 Title: ");
//		String title1 = sc.nextLine();
//		
//		System.out.println("Book 1 Author: ");
//		String author1 = sc.nextLine();
//		
//		System.out.println("Book 1 Price: ");
//		double price1 = sc.nextDouble();
//		sc.nextLine();
//		Book b1 = new Book();
//		
//		b1.setTitle(title1);
//		b1.setAuthor(author1);
//		b1.setPrice(price1);
//		
//		System.out.println(b1);
//		
//		System.out.println();
//		
//		System.out.println("Book 2 Title: ");
//		String title2 = sc.nextLine();
//		
//		System.out.println("Book 2 Author: ");
//		String author2 = sc.nextLine();
//		
//		System.out.println("Book 2 Price: ");
//		double price2 = sc.nextDouble();
//		Book b2 = new Book();
//		
//		b2.setTitle(title2);
//		b2.setAuthor(author2);
//		b2.setPrice(price2);
//		
//		System.out.println(b2);
	}

}
