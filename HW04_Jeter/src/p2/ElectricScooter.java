package p2;

public class ElectricScooter implements Vehicle{

	@Override
	public void start() {
		System.out.println("Scooter is on.");
	}

	@Override
	public void stop() {
		System.out.println("Scooter has stopped.");
	}

	@Override
	public String getFuelType() {
		return "Electric";
	}

}
