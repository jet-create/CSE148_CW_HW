package problem_4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SettingBag {
	private Setting[] arr;
	private int nElems;
	
	public SettingBag(int maxSize){
		arr = new Setting[maxSize];
	}
	
	public void insert(String key, String value) {
		Setting setting = new Setting(key, value);
		arr[nElems++] = setting;
	}
	
	public void display() {
		for(int i = 0; i < nElems; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();
	}
	
	public Setting getValue(String key) {
		for(int i = 0; i < nElems; i++) {
			if(arr[i].getKey().equals(key)) {
				return arr[i];
			}
		}
		return null;
	}
	
	public void FillBag(String path) {
		try(BufferedReader br = new BufferedReader(new FileReader(path));){
			String line;
			while((line = br.readLine()) != null) {
				String[] data = line.split("=");
				insert(data[0], data[1]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
