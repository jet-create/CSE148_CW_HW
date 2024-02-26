package p2_abstract;

public class Demo {

	public static void main(String[] args) {
//		Polymorphism
		Person s1 = new Student("John", "123", 3.5);
		s1.greetings();
		
		Person instructor1 = new Instructor("Jane", "456", 1000.0);
		instructor1.greetings();
		
		// instanceof allows you to determine what type of object it is
		Person arr[] = {s1, instructor1};
		System.out.println(s1 instanceof Person);
		System.out.println(s1 instanceof Student);
		System.out.println(s1 instanceof Instructor);
		
		Person child = new Person(null, null){
			public void greetings() {
				System.out.println("Hello from a child...");
			}
		};
		child.greetings();
	}

}
