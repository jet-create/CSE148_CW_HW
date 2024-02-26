package p1;

public abstract class Merchandise {
	protected String category;
	private String name;
	private String brand;
	private double price;
	private String description;
	private String sku;
	private String inventory;

	private static int skuCount;

	public Merchandise() {
		this.sku = String.valueOf(++skuCount);
	}

	public Merchandise(String category, String name, String brand, double price, String description, String sku,
			String inventory) {
		super();
		this.category = category;
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.description = description;
		this.sku = generateSku();
		this.inventory = inventory;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSku() {
		return sku;
	}

	private final String generateSku() {
//		return category.substring(0, 2).toLowerCase() + "-" + category + "#" + String.valueOf(++skuCount);
		String sku = category.substring(0, 2).toLowerCase() + "-" +category.toLowerCase()+ "-" + String.valueOf(++skuCount);

		int zeroAdd = String.valueOf(skuCount).length();

		switch (zeroAdd) {
		case 1:
			sku = sku.substring(0, sku.length() - 1) + "000" + sku.charAt(sku.length() - 1);
			break;
		case 2:
			sku = sku.substring(0, sku.length() - 2) + "00" + sku.substring(sku.length() - 2);
			break;
		case 3:
			sku = sku.substring(0, sku.length() - 3) + "0" + sku.substring(sku.length() - 3);
			break;
		}
		return sku;

//		int digits = String.valueOf(skuCount).length();
//		int zerosToAdd = 4 - digits;
//
//		for (int i = 0; i < zerosToAdd; i++) {
//			sku = "0" + sku;
//		}
//
//		return sku;

	}

	public String getInventory() {
		return inventory;
	}

	public void setInventory(String inventory) {
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "Merchandise\nCategory: " + category + "\nName: " + name + "\nBrand: " + brand + "\nPrice: " + price
				+ "\nDescription: " + description + "\nSKU: " + sku + "\nInventory: " + inventory;
	}

}
