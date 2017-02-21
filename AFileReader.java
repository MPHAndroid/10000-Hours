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

public class AFileReader {
	
	public static void main(String... aArgs) throws IOException {
		AFileReader text = new AFileReader();
		
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
				if (processLine(scanner.nextLine())){
					counter = counter + 1;
					log(counter);
			}

		}
		log("number of STAGES");
		log(counter);
	}
	}
	
	boolean processLine(String aLine){
		//log(aLine);
		Scanner scanner = new Scanner(aLine);
		scanner.useDelimiter(" ");
		while(scanner.hasNext()){
			if(scanner.next().equals("STAGE")){
				log("Found STAGE");
				return true;
			}
			//if(!scanner.hasNext()){
			//	log("Empty Line");
			//}
		}
		return false;
	}
	
	private static void log(Object aMsg){
		System.out.println(String.valueOf(aMsg));
	}

}