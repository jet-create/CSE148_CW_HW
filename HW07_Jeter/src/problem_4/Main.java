package problem_4;

public class Main {

	public static void main(String[] args) {
		SettingBag bag = new SettingBag(10);
		bag.FillBag("data/settings.txt");
		bag.display();
		System.out.println(bag.getValue("phone"));
		
			

		
	}

}
