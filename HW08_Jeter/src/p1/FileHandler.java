package p1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileHandler {

	public static void saveToFile(PersonBag bag) {
		try(FileOutputStream fos = new FileOutputStream("data/bag.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos);){
			oos.writeObject(bag);
			oos.writeObject(Person.getIdCount());
			System.out.println("The bag is backed up! Goodbye.");
		} catch(IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static PersonBag loadFromFile() {
		try(FileInputStream fis = new FileInputStream("data/bag.dat");
				ObjectInputStream ois = new ObjectInputStream(fis);){
			PersonBag bag = (PersonBag)ois.readObject();
			int idCount = (Integer)ois.readObject();
			Person.setIdCount(idCount);
			System.out.println("Welcome back!, bag is restored.");
			return bag;
		} catch(IOException e ) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
