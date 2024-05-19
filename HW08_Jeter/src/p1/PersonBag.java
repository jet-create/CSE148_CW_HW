package p1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.function.Predicate;

public class PersonBag implements Serializable{
	private Person[] arr;
	private int nElems;
	
	public PersonBag(int maxSize) {
		arr = new Person[maxSize];
	}
	
	public void insert(Person p) {
		arr[nElems++] = p;
	}
	
//	public void insertStudents(String id, String name, Major major, double gpa) {
//		Student student = new Student(id, name, gpa, major);
//		arr[nElems++] = student;
//	}
//	
//	public void insertInstructor(String id, String name, Rank rank, double salary) {
//		Instructor instructor = new Instructor(id, name, salary, rank);
//		arr[nElems++] = instructor;
//	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public Person[] delete(Predicate<Person> predicate) {
		Person[] foundArr = new Person[nElems];
		int count = 0;
		for(int i = 0; i < nElems; i++) {
			if(predicate.test(arr[i])) {
				foundArr[count++] = arr[i];
				for(int j = i; j < nElems - 1; i++) {
					arr[j] = arr[j + 1];
				}
				nElems--;
				i--;
			}
		}
		return Arrays.copyOf(foundArr, count);
	}
	
	public Person[] search(Predicate<Person> predicate) {
		Person[] foundArr = new Person[nElems];
		int count = 0;
		for(int i = 0; i < nElems; i++) {
			if(predicate.test(arr[i])) {
				foundArr[count++] = arr[i];
			}
		}
		return Arrays.copyOf(foundArr, count);
	}
	
	public void importStudents(String path, PersonBag bag) {
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line;
			while((line = br.readLine()) != null) {
				String[] arr = line.split(" ");
				if(arr.length >= 3) {
					String name = arr[0] + " " + arr[1];
					Major major = Major.valueOf(arr[2]);
					double gpa = Double.parseDouble(arr[3]);
					bag.insert(new Student(name, gpa, major));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void importInstructors(String path, PersonBag bag) {
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line;
			while((line = br.readLine()) != null) {
				String[] arr = line.split(" ");
				if(arr.length >= 3) {
					String name = arr[0] + " " + arr[1];
					Rank rank = Rank.valueOf(arr[2]);
					double salary = Double.parseDouble(arr[3]);
					bag.insert(new Instructor(name, salary, rank));
				}
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void exportStudents(String path, PersonBag bag) {
		try {
			File file = new File(path);
			if(!file.exists()) {
				file.createNewFile();
			}
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path));){
				for(int i = 0; i < nElems; i++) {
					Person p = arr[i];
					if(p instanceof Student) {
						bw.write(p.toString());
						bw.newLine();
					}
				}
				System.out.println("Successfully transferred Students!");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}	catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	public void exportInstructors(String path, PersonBag bag) {
		try {
			File file = new File(path);
			if(!file.exists()) {
				file.createNewFile();
			}
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(path));){
				for(int i = 0; i < nElems; i++) {
					Person p = arr[i];
					if(p instanceof Instructor) {
						bw.write(p.toString());
						bw.newLine();
					}
				}
				System.out.println("Successfully transferred Instructors!");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}	catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
}
