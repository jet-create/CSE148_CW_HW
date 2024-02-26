package p2;

public class Circle {
	private double radius;
	private double pi;
	
	public Circle() {
		radius = 0.0;
		pi = 3.14159;
	}
	
//	Setters
	
	public void setRadius(double radius) {
		this.radius = radius;
	}
	
//	Getters
	
	public double getRadius() {
		return radius;
	}
	
	public double getArea() {
		return pi * radius * radius;
	}
	
	public double getDiameter() {
		return radius * 2;
	}
	
	public double getCircumference() {
		return 2 * pi * radius;
	}

	
	
}
