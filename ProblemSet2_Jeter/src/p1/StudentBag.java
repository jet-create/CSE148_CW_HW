package p1;

public class StudentBag {
	private Student[] students;
	private int nElems;
	
	public StudentBag(int maxSize) {
		students = new Student[maxSize];
		nElems = 0;
	}
	
	public void insert(Student student) {
		students[nElems++] = student;
	}
	
//	storing student object in students array at index nElems++
	public void insert(String firstName, String middleInitial, String lastName, double gpa) {
		students[nElems++] = new Student(firstName, middleInitial, lastName, gpa);
	}
	
	public Student removeById(String id) {
		int i;
		for(i = 0; i < nElems; i++) {
			if(students[i].getId().equals(id)) {
				break;
			}
		}
		
		if(i == nElems) {
			return null;
		}else {
			Student temp = students[i];
			for(int j = i; j < nElems - 1; j++) {
				students[j] = students [j + 1];
			}
			nElems--;
			return temp;
		}
	}
	
	public Student searchById(String id) {
		for(int i = 0; i < nElems; i++) {
			if(students[i].getId().equals(id)) {
				return students[i];
			}
		}
		return null;
	}
	
	public void display() {
//		System.out.println("\nStudent Information Table:");
//		System.out.printf("%-20s %-15s %-20s %-15s\n", "ID", "Name", "GPA", "Address");
//		for(Student student : students) {
//			System.out.printf("%-20s %-15s %-20s %-15s\n", student.getId(), student.getName(), 
//					student.getGpa());
//		}
		
		for(int i = 0; i < nElems; i++) {
			System.out.println(students[i]);
		}
		System.out.println();
	}
}



