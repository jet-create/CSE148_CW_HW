package p1;

public class Demo {

	public static void main(String[] args) {

		PersonBag bag = new PersonBag(10);

		bag.importStudents("data/existingStudent.dat", bag);
		bag.importInstructors("data/existingInstructor.dat", bag);
		bag.display();

		System.out.println();

//		FileHandler.saveToFile(bag);

		bag.display();
		System.out.println();
		bag.exportStudents("data/bagToFile.dat", bag);
		bag.exportInstructors("data/bagToFile2.dat", bag);
	}

}
