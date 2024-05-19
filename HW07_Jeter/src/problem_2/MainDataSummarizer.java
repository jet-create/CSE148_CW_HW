package problem_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainDataSummarizer {

	public static void main(String[] args) {
		
		String[] arr = new String[100];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = String.valueOf((Math.random()*(100-1+1)+1));
		}
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter("data/numbers.txt"));
			for(String i : arr) {
				bw.write(i + "\n");
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("data/numbers.txt"));
			String line;
			double sum = 0.0;
			int lineNumber = 0;
			while((line = br.readLine()) != null) {
				lineNumber++;
				double num = Double.parseDouble(line);
				sum += num;
			}
			System.out.println("Sum of all nums: " + sum);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}

}
