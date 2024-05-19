package p1;

public class Book extends Item {
	private String isbn;

	public Book() {
		super();
	}
	
	public Book(String category, String title, String publisher, String callNumber, String isbn) {
		super(title, publisher, category, callNumber);
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "Book [ISBN: " + isbn + "]";
	}
	
	
	
	
	
	
}
