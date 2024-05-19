package p1;

public class Library {
	Item[] items;
	private int nElems;

	public Library(int maxSize) {
		items = new Item[maxSize];
		int nElems = 0;
	}

	public void addItem(Item item) {
		items[nElems++] = item;
	}

	public Item removeByISBN(String isbn) {
		int i;
		for (i = 0; i < nElems; i++) {
			if (items[i].equals(isbn)) {
				break;
			}
		}

		if (i == nElems) {
			return null;
		} else {
			Item temp = items[i];
			for (int j = i; j < nElems - 1; j++) {
				items[j] = items[j + 1];
			}
			nElems--;
			return temp;
		}
	}

	public MusicCD searchByArtist(String artist) {
		for (int i = 0; i < nElems; i++) {
			if (items[i].equals(artist)) {
				return (MusicCD) items[i];
			}
		}
		return null;
	}

	public void displayBooks() {
		for (int i = 0; i < nElems; i++) {
			if (items[i].getCategory().equalsIgnoreCase("Book")) {
				System.out.println(items[i]);
			}
		}
		System.out.println();
	}

	public void displayMusicCDs() {
		for (int i = 0; i < nElems; i++) {
			if (items[i].getCategory().equalsIgnoreCase("MusicCD")) {
				System.out.println(items[i]);
			}
		}
		System.out.println();
	}

	public void displayLibrary() {
		for (int i = 0; i < nElems; i++) {
			System.out.println(items[i]);
		}
		System.out.println();
	}

	public Item removeByCallNumber(String callNumber) {
		int i;
		for(i = 0; i < nElems; i++) {
			if(items[i].getCallNumber().equals(callNumber)) {
				break;
			}
		}
		
		if(i == nElems) {
			return null;
		}else {
			Item temp = items[i];
			for(int j = i; j < nElems - 1; j++) {
				items[j] = items[j + 1];
			}
			nElems--;
			return temp;
		}
	}

}
