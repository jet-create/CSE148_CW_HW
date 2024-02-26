package p1;

public class BookBag {
	private Book[] books;
	private int nElems;
	
	public BookBag(int maxSize) {
		books = new Book[maxSize];
		nElems = 0;
	}
	
	public void insert(String title, String isbn, double price) {
		books[nElems++] = new Book(title, isbn, price);
	}
	
	public Book removeByISBN(String isbn) {
		int i;
		for(i = 0; i < nElems; i++) {
			if(books[i].getIsbn().equals(isbn)) {
				break;
			}
		}
		if(i == nElems) {
			return null;
		}else {
			Book temp = books[i];
			for(int j = i; j < nElems - 1; j++) {
				books[j] = books[j + 1];
			}
			return temp;
		}
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(books[i]);
		}
		System.out.println();
	}
	
}
