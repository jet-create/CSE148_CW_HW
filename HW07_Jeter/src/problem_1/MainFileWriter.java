package problem_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainFileWriter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Create your text file: ");
		String filePath = sc.nextLine();
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));){
			System.out.println("What would you like to write?");
			String type = sc.nextLine();
			bw.write(type);
			System.out.println("Successfully written!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("Enter path of text file: ");
		String path = sc.nextLine();
		boolean isPath = true;
		do{
			File file = new File(path);
			if(file.exists()) {
				isPath = true;
				System.out.println("Path accepted.");
			} else {
				isPath = false;
				System.out.println("Path doesnt exist, re-enter: ");
				path = sc.nextLine();
			}
		}while(!isPath);
		
		
		System.out.println();
		boolean toRead;
		System.out.println("Would you like to read the text file?");
		String response = sc.nextLine();
		if(response.equalsIgnoreCase("yes")) {
			try (BufferedReader br = new BufferedReader(new FileReader(filePath));){
				System.out.println("Contents of your file: ");
				System.out.println(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Check out your text file anytime!!");
		}
		
	}

}
