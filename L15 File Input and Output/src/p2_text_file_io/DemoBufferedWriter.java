package p2_text_file_io;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// efficient with writers
//file writer and print writer
public class DemoBufferedWriter {

	public static void main(String[] args) throws FileNotFoundException {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter("data/bufferedWriter.txt"));){
			bw.write("I love my girlfriend so much!!!!");
			bw.newLine();
//			System.out.println("Done writing!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		File file = new File("data/bufferedWriter.txt");
		Scanner sc = new Scanner(file);
		System.out.println(sc.nextLine());
	}

}
