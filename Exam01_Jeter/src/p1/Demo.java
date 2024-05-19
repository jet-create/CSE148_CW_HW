package p1;

public class Demo {

	public static void main(String[] args) {
		Item book1 = new Book("Book", "Java", "John Doe", " ", "82829191");
		Item book2 = new Book("Book", "JavaScript", "John Doe", " ", "983339221");
		
		Item musicCD1 = new MusicCD("Boredom", "Sony Entertainment Group", "MusicCD", " ","Tyler, the Creator", "Rap");
		Item musicCD2 = new MusicCD("ARE WE STILL FRIENDS?", "Sony Entertainment Group", "MusicCD"," ", "Tyler, the Creator", "Rap");
		
		Library library = new Library(10);
		
		library.addItem(book1);
		library.addItem(book2);
		library.addItem(musicCD1);
		library.addItem(musicCD2);
		
		System.out.println(library.removeByISBN("82829191"));
		System.out.println(library.searchByArtist("Tyler, the Creator"));
		System.out.println("Books: ");
		library.displayBooks();
		System.out.println("MusicCDs: ");
		library.displayMusicCDs();
		System.out.println("Entire Library: ");
		library.displayLibrary();
		library.removeByCallNumber("");



	}

}
