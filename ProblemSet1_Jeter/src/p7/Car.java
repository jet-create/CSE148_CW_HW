package p7;

public class Car {
	private String color;
	private int year;
	private String make;
	private double speed;
	
	public Car(String color, int year, String make, double speed) {
		this.color = color;
		this.year = year;
		this.make = make;
		this.speed = speed;
	}
	
//	Setters 
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void speedUp() {
		speed+=10;
	}
	
	public void slowDown() {
		speed-=10;
	}
	
//	Getters
	
	public String getColor() {
		return color;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getMake() {
		return make;
	}
	
	public double getSpeed() {
		return speed;
	}
	
	public String toString() {
		return "Color: "+color 
				+ "\nYear: "+year
				+"\nMake: "+make
				+"\nSpeed: "+speed+" mph";
	}

}

