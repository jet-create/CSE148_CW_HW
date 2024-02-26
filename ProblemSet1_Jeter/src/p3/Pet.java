package p3;

public class Pet {
	private String type;
	private String name;
	private String sound;
	
	public Pet(String type, String name, String sound) {
		this.type = type;
		this.name = name;
		this.sound = sound;
		}
	
	public String toString() {
		return "A " + type + " called " + name + " who " + sound ;
	}
}
