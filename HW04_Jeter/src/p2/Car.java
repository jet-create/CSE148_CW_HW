package p2;

public class Car implements Vehicle{

	@Override
	public void start() {
		System.out.println("Car is starting.");
	}

	@Override
	public void stop() {
		System.out.println("Car is stopping");
	}

	@Override
	public String getFuelType() {
		// TODO Auto-generated method stub
		return "Gasoline";
	}

}
