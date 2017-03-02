//This java application will read a file and output some of the file to a new file
//It has been copied from http://www.javapractices.com/topic/TopicAction.do?Id=42

import java.io.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AMomentWriter {
	
	public static void main(String... aArgs) throws IOException {
		AMomentWriter text = new AMomentWriter();
		StringBuilder lines = new StringBuilder();
		lines = text.readLargerTextFile(FILE_NAME);
		// log(lines);
		// lines.append("First Test");
		// lines.append(lines);
		text.writeToFile(lines,OUT_NAME);
	}
	
	final static String FILE_NAME = "C:\\URS-Data\\Android\\JDK\\bin\\Input.txt";
	final static Charset ENCODING =  StandardCharsets.UTF_8;
	final static String OUT_NAME = "C:\\URS-Data\\Android\\JDK\\bin\\Output.txt";
	
	StringBuilder readLargerTextFile(String aFileName) throws IOException {
		long counter = 0;
		StringBuilder receivedData = new StringBuilder();
		String NL = System.getProperty("line.separator");
		// receivedData.append("I've added this");
		Path path = Paths.get(aFileName);
		try (Scanner scanner = new Scanner(path, ENCODING.name())){
			while (scanner.hasNextLine()){
				// System.out.println(scanner.nextline());
				if (processLine(scanner.nextLine(), "SEGMENT")){
					for (int x = 1; x < 6; x=x+1){
						// read the next six lines
						//Scanner scanner3 = new Scanner(scanner.nextLine());
						scanner.nextLine();
						//log(scanner3);
					}
					// receivedData.add(processLoads(scanner.nextLine(),4));
					receivedData.append(processLoads(scanner.nextLine(),4));
					receivedData.append(NL);
				}
			}
		}
		log("number of STAGES");
		log(counter);
		return receivedData;
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
		String readData;
		int counter = 0;
		Scanner scanner2 = new Scanner(aLine);
		scanner2.useDelimiter(" ");
		while(scanner2.hasNext()){
			readData = scanner2.next();
			//log("found ["+readData+"]");
			if (!readData.equals("")){
				// log(scanner2.next() + "Im at location" + counter);
				counter = counter + 1;
				if (counter == numAcross){
					//log("counter is now " + counter + " data is [" + readData + "]");
					return readData;
				}
			}
		}
		return "Not Found";
	}
	
	private static void log(Object aMsg){
		System.out.println(String.valueOf(aMsg));
	}
	
	void writeToFile(StringBuilder aLines, String aFileName) throws IOException {
		Writer out = new OutputStreamWriter(new FileOutputStream(aFileName), ENCODING);
		try {
			out.write(aLines.toString());
		}
		finally {
			out.close();
		}
	}

}