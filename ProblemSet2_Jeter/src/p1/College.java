package p1;

public class College {
	private String name;
	private Address address;
	private StudentBag studentBag;
	private BookBag bookBag;

	public College(String name, Address address, int maxBookBagSize, int maxStudentSize) {
		this.name = name;
		this.address = address;
		bookBag = new BookBag(maxBookBagSize);
		studentBag = new StudentBag(maxStudentSize);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public StudentBag getStudentBag() {
		return studentBag;
	}

	public void setStudentBag(StudentBag studentBag) {
		this.studentBag = studentBag;
	}

	public BookBag getBookBag() {
		return bookBag;
	}

	public void setBookBag(BookBag bookBag) {
		this.bookBag = bookBag;
	}

	@Override
	public String toString() {
		return "College [name=" + name + ", address=" + address + ", studentBag=" + studentBag + ", bookBag=" + bookBag
				+ "]";
	}

}
