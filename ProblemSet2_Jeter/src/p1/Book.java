package p1;

public class Book {
	private String title;
	private String isbn;
	private double price;
	
	private static int isbnCount;
	
	public Book() {
		
	}
	
	public Book(String title, String isbn, double price) {
		this.title = title;
		this.isbn = isbn;
		this.price = price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", isbn=" + isbn + ", price=" + price + "]";
	}
	
	
}
