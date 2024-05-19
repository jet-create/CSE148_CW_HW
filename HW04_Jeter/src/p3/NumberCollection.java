package p3;

public class NumberCollection implements Sortable {
	private int[] numbers;

	@Override
	public void sort() {
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = 0; j < numbers.length - i - 1; j++) {
				if (numbers[j] > numbers[j + 1]) {
					// Swap numbers[j] and numbers[j+1]
					int temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
	}

}
