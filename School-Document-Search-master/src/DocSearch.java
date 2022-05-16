import java.io.*;
import java.util.*;

public class DocSearch {
	private static HashMap<String, Integer> searchWords = new HashMap<String, Integer>();

	
	public static void main(String[] args) throws IOException {
		Scanner keyboard = new Scanner(System.in);

	    System.out.println("Please input the name of the file path of the file you want to search");
		String fileName = keyboard.nextLine();
		
		while(true){
			System.out.println("Please enter the word you want to search in this doccument");
			String searchWord = keyboard.next();
			searchWords.put(searchWord, 0);
			
			System.out.println("Would you like to search more words? (Y/N)");
			String option = keyboard.next();
			if(option.equals("N")|| option.equals("n")){
				break;
				}
			}
		
		 // This will reference one line at a time
	    String line = null;
	
	    try {
	        // FileReader reads text files in the default encoding.
	        FileReader fileReader = 
	            new FileReader(fileName);
	
	        // Always wrap FileReader in BufferedReader.
	        BufferedReader bufferedReader = 
	            new BufferedReader(fileReader);
	
	        while((line = bufferedReader.readLine()) != null) {
	            for(String key:searchWords.keySet()){
	            	if(line.contains(key)){
	            		searchWords.put(key, searchWords.get(key)+1);
	            	}
	            }
	        }
	        for(String key:searchWords.keySet()){
	        	System.out.print(key +": ");
	        	System.out.println(searchWords.get(key));
	        }
	        
	        // Always close files.
	        bufferedReader.close();         
	    }
	    catch(FileNotFoundException ex) {
	        System.out.println(
	            "Unable to open file '" + 
	            fileName + "'");                
	    }
	    catch(IOException ex) {
	        System.out.println(
	            "Error reading file '" 
	            + fileName + "'");                  
	    }
	      
	}
	

	
}
	
	