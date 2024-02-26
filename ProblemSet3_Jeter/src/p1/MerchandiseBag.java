package p1;

public class MerchandiseBag {
	private Merchandise[] merchandises;
	private int nElems;

	public MerchandiseBag(int maxSize) {
		merchandises = new Merchandise[maxSize];
		nElems = 0;
	}

	public void insert(Merchandise merchandise) {
		merchandises[nElems++] = merchandise;
	}

	public Merchandise removeBySKU(String sku) {
		int i;
		for(i = 0; i < nElems; i++) {
			if(merchandises[i].getSku().equals(sku)) {
				break;
			}
		}
		if(i == nElems) {
			return null;
		}else {
			Merchandise temp = merchandises[i];
			for(int j = i; j < nElems - 1; j++) {
				merchandises[j] = merchandises[j+1];
			}
			nElems--;
			return temp;
		}
	}
	
	public Merchandise searchBySKU(String sku) {
		for(int i = 0; i < nElems; i++) {
			if(merchandises[i].getSku().equals(sku)) {
				return merchandises[i];
			}
		}
		return null;
	}
	
	public void displayBag() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(merchandises[i]);
		}
		System.out.println();
	}
	
	public void displayByCategory(String category) {
		for(int i = 0; i < nElems; i++) {
			if(merchandises[i].getCategory().equalsIgnoreCase(category)) {
				System.out.println(merchandises[i]);
			}
		}
		System.out.println();
	}
}
