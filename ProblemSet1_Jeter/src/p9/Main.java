package p9;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Student[] students = new Student[3];

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < 3; i++) {
			System.out.println("Enter student " + (i + 1) + "'s info below");

			System.out.println("Full Name: ");
			String name = sc.nextLine();

			System.out.println("ID #: ");
			String id = sc.nextLine();

			System.out.println("How many classes this student enrolled in?");
			int numOfCourses = sc.nextInt();
			sc.nextLine();
			String[] courses = new String[numOfCourses];
			for (int j = 0; j < numOfCourses; j++) {
				System.out.println("Course " + (j + 1) + " name: ");
				courses[j] = sc.nextLine();
			}

			System.out.println("GPA: ");
			double gpa = sc.nextDouble();
			sc.nextLine();

			students[i] = new Student(name, id, courses, gpa);

		}

		System.out.println("\nStudent Information Table:");
		System.out.printf("%-20s %-15s %-20s %-15s\n", "Full Name", "ID", "Courses", "GPA");
		for (Student student : students) {
			System.out.printf("%-20s %-15s %-20s %.2f\n", student.getFirstLastName(), student.getStudentID(),
					Arrays.toString(student.getCourses()), student.getGpa());
		}

		sc.close();

	}
}
