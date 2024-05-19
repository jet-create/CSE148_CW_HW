package p1;

public abstract class Item {
	protected String category;
	private String title;
	private String publisher;
	private String callNumber;
	
	private static int count;
	
	public Item(){
		this.callNumber = generateNumber();
	}
	
	public Item(String category, String title, String publisher, String callNumber) {
		super();
		this.title = title;
		this.publisher = publisher;
		this.callNumber = generateNumber();
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getCallNumber() {
		return callNumber;
	}

	private final String generateNumber() {
		return title.substring(0, title.length()-1).toLowerCase()+"-"+String.valueOf(++count);
	}

	@Override
	public String toString() {
		return "Item [Title: " + title + ", Publisher:" + publisher + ", Call Number: " + callNumber + "]";
	}
	
	
	
}
