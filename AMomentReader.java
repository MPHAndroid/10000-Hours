//This java application will read a file and output some of the file to a new file
//It has been copied from http://www.javapractices.com/topic/TopicAction.do?Id=42

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AMomentReader {
	
	public static void main(String... aArgs) throws IOException {
		AMomentReader text = new AMomentReader();
		
		text.readLargerTextFile(FILE_NAME);
	}
	
	final static String FILE_NAME = "C:\\URS-Data\\Android\\JDK\\bin\\Input.txt";
	final static Charset ENCODING =  StandardCharsets.UTF_8;
	
	void readLargerTextFile(String aFileName) throws IOException {
		long counter = 0;
		Path path = Paths.get(aFileName);
		try (Scanner scanner = new Scanner(path, ENCODING.name())){
			while (scanner.hasNextLine()){
				// System.out.println(scanner.nextline());
				if (processLine(scanner.nextLine(), "SEGMENT")){
					for (int x = 1; x < 7; x=x+1){
						// read the next six lines
						//Scanner scanner3 = new Scanner(scanner.nextLine());
						log(scanner.nextLine());
						//log(scanner3);
					}
					log(processLoads(scanner.nextLine(),3));
				}
			}
		}
		log("number of STAGES");
		log(counter);
	}
	
	boolean processLine(String aLine, String searchTerm){
		//log(aLine);
		Scanner scanner = new Scanner(aLine);
		scanner.useDelimiter(" ");
		while(scanner.hasNext()){
			if(scanner.next().equals(searchTerm)){
				log("Found " + searchTerm);
				return true;
			}
			//if(!scanner.hasNext()){
			//	log("Empty Line");
			//}
		}
		return false;
	}
	
	String processLoads(String aLine, int numAcross){
		int counter = 0;
		Scanner scanner2 = new Scanner(aLine);
		scanner2.useDelimiter(" ");
		while(scanner2.hasNext()){
			counter = counter + 1;
			if (counter == numAcross){
				return scanner2.next();
			}
		}
		return "Not Found";
	}
	
	private static void log(Object aMsg){
		System.out.println(String.valueOf(aMsg));
	}

}