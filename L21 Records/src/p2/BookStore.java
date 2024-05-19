package p2;

import java.util.List;

public class BookStore {

	public static void main(String[] args) {
		Book book1 = new Book("AAA", "Author 1", 39.99);
		Book book2 = new Book("BBB", "Author 2", 29.99);
		Book book3 = new Book("BBB", "Author 3", 19.99);
		
		Customer customer = new Customer("John Doe", "JohnDoe@gmail.com");
		
		Order order = new Order(customer, 10198201, List.of(book1, book2, book3));
		
		printOrderInformation(order);

	}
	
	public static void printOrderInformation(Order order) {
		System.out.println("Order Details: ");
		System.out.println("Order #: " + order.OrderNum +
				"\nCustomer: " + order.customer.name + "-" + order.customer.email );
		System.out.println("Books Ordered: ");
		for(Book book : order.books()) {
			System.out.println(book.title() + "by" + book.author() + " - $" + book.price());
		}
	}
	
	public record Book(String title, String author, double price) {}
	public record Customer(String name, String email) {}
	public record Order(Customer customer, int OrderNum, List<Book> books) {}

}
