package p6;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class MainRandomAccessFile {
	
	public static void main(String[] args) {
		char[] arr = {'a', 'b', 'c', 'd', 'e'};
		try(RandomAccessFile randFile = new RandomAccessFile("data/output/letter.dat", "rw");){
			for(char c : arr) {
				randFile.writeChar(c);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
