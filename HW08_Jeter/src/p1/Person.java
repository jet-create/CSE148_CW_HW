package p1;

import java.io.Serializable;

public abstract class Person implements Serializable {
	protected String id;
	protected String name;

	private static int idCount = 0;

	public Person(String name) {
		super();
		this.id = String.valueOf(idCount++);
		this.name = name;
	}

	public Person() {
		super();
		this.id = String.valueOf(idCount++);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public static int getIdCount() {
		return idCount;
	}

	public static void setIdCount(int idCount) {
		Person.idCount = idCount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}

}
