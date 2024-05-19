package p3_binary_io;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		String[] arr2 = {"A", "B", "C", "D", "R", "Z"};
		
		try 
			(FileOutputStream fos = new FileOutputStream("data/output/data.dat", false); // try with resources
			DataOutputStream dos = new DataOutputStream(fos);) { // wrapper class
//			dos.writeDouble(12445653.5002445435345);
//			dos.writeDouble(43453.234567);
//			dos.writeChar('A');
//			dos.writeChar('B');
//			dos.writeUTF("He");
//			for(int n : arr) {
//				dos.writeInt(n);
//			}
			for(String n : arr2) {
				dos.writeUTF(n);
			}
//			dos.close();
			System.out.println("Done Writing!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}

}
