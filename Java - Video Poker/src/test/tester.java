package test;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.*; // Import the Scanner class to read text files

public class tester {
  public static void main(String[] args) {
	String data = new String();
	int n_tokens;
	
	int i = 0;
    try {
      File myObj = new File("C:\\Users\\pedro\\Desktop\\POO\\Projeto\\Test Files\\card-file.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        data = data + myReader.nextLine();
        //data = data.replaceAll("\\s+"," ");
        i++;
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    StringTokenizer token = new StringTokenizer(data);
    
    n_tokens = token.countTokens();
    
    String[] string = new String[n_tokens];
    
    while(token.hasMoreTokens())
    {
    	string[i] = token.nextToken();
    	System.out.println(string[i]);
    }
    
    System.out.println(string);
  }
}
