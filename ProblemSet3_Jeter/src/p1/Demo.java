package p1;

public class Demo {

	public static void main(String[] args) {

		MerchandiseBag merchandiseBag = new MerchandiseBag(10);

		Tool PowerDrill = new PowerDrill("Tool", "Milwaukee Power Drill", "Milwaukee", 49.99,
				"Nice an deasy compact power drill", "", "In stock");
		Tool PowerWasher = new PowerWasher("Tool", "GE Power Washer", "GE", 49.99, "Good strong washer for any problem",
				"", "A lot in stock");
		Appliance PaniniPress = new PaniniPress("Appliance", "Ninja Panini Press", "Ninja", 44.99,
				"Great if you like melted sandwiches", "", "Running out fast!");
		Appliance PressureCooker = new PressureCooker("Appliance", "Ninja Pressure Cooker", "Ninja", 39.99,
				"Good for any food", "", "Running out!");
		Plant Rose = new Rose("Plant", "Rose", "Raizel's Flower Patch", 12.99, "Beautiful rose for any garden", "",
				"A lot in stock");
		Plant SunFlower = new SunFlower("Plant", "SunFlower", "Raizel's Flower Patch", 5.99, "Beautiful spring flower",
				"", "Get them fast!");

		merchandiseBag.insert(PowerDrill);
		merchandiseBag.insert(PaniniPress);
		merchandiseBag.insert(Rose);
		merchandiseBag.insert(PowerWasher);
		merchandiseBag.insert(PressureCooker);
		merchandiseBag.insert(SunFlower);

//		merchandiseBag.displayBag();

//		merchandiseBag.displayByCategory("tool");
//		System.out.println();
//		
//		merchandiseBag.displayByCategory("appliance");
//		System.out.println();
//
//		merchandiseBag.displayByCategory("plant");
//		System.out.println();

		System.out.println(merchandiseBag.searchBySKU("AP#0004"));
		System.out.println();
		System.out.println(merchandiseBag.removeBySKU("TO#0001"));
		
		System.out.println("Update: ");
		merchandiseBag.displayBag();
		

		

	}

}
