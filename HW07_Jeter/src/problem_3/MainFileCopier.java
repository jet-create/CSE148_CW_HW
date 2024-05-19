package problem_3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class MainFileCopier {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter source file path: ");
		String sourceFilePath = sc.nextLine();
		System.out.println("Enter destination file path: ");
		String destinationFilePath = sc.nextLine(); 
		
		try {
			File sourceFile = new File(sourceFilePath);
			if(!sourceFile.exists()) {
				throw new FileNotFoundException("Source File not found " + sourceFilePath);
			}
			
			File destinationFile = new File(destinationFilePath);
			if(!destinationFile.exists()) {
				destinationFile.createNewFile();
			}

			Files.copy(sourceFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
			log();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}	
		
	}
	
	private static void log() {
		String message = "";
		try(FileWriter w = new FileWriter("data/copyLogs.txt", true);){
			LocalDate date = LocalDate.now();
			LocalTime time = LocalTime.now();
			message = "A copy was logged on: " + date + " at: " + time;
			System.out.println(message);
			w.write(message + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
