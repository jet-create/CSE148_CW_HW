package pt;

public class Circle {
	private double radius;
	private String id;
	private static int idCount;
	private static double pi = 3.14159;
	
	
	public Circle(double radius) {
		this.radius = radius;
		this.id = String.valueOf(++idCount);
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public double calculateCircleArea() {
		return pi*(radius*radius);
	}

	@Override
	public String toString() {
		return "Circle " + id + " [radius = " + radius + ", Circle Area = " + calculateCircleArea() + "]";
	}
	
}
