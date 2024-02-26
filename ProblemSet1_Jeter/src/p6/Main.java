package p6;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Persons[] person = new Persons[2];
		
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0; i < 2; i++) {
			System.out.println("Name of Person " + (i+1)+ ":");
			String name = sc.nextLine();
			
			System.out.println("Person " + (i+1) + "'s SSN:");
			String ssn = sc.nextLine();
			
			System.out.println("Person " + (i+1) + "'s Age:");
			int age = sc.nextInt();
			sc.nextLine();
			
			person[i] = new Persons(name, ssn, age);
		}
		
		for(int i = 0; i < 2; i++) {
			System.out.println(person[i]);
			System.out.println();
		}

		sc.close();
//		System.out.println("Person Name: ");
//		String p1Name = sc.nextLine();
//		
//		System.out.println("SSN: ");
//		String p1SSN = sc.next();
//		
//		System.out.println("Age: ");
//		int p1Age = sc.nextInt();
//		sc.nextLine();
//		
//		Persons p1 = new Persons();
//		
//		p1.setName(p1Name);
//		p1.setSocialSecNum(p1SSN);
//		p1.setAge(p1Age);
//		
//		System.out.println(p1);
//		
//		System.out.println("\nPerson Name: ");
//		String p2Name = sc.nextLine();
//		
//		System.out.println("SSN: ");
//		String p2SSN = sc.next();
//		
//		System.out.println("Age: ");
//		int p2Age = sc.nextInt();
//		sc.nextLine();
//		
//		Persons p2 = new Persons();
//		
//		p2.setName(p2Name);
//		p2.setSocialSecNum(p2SSN);
//		p2.setAge(p2Age);
//		
//		System.out.println(p2);
	}

}
