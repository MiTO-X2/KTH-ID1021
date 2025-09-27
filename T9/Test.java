import java.util.Arrays;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

class Test {


    public static void main(String[] arg) {

	String file = "kelly.txt";

	// try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"))) {
	    String word;
	    while ((word = br.readLine()) != null) {
		System.out.print(word + ": \n   ");
		for(int i = 0; i < word.length(); i++) {
		    System.out.print(" " + word.charAt(i));
		}
		System.out.print("\n   ");

		for(int i = 0; i < word.length(); i++) {
		    System.out.print(" " + (int)word.charAt(i));
		}
		System.out.print("\n   ");

		byte[] bytes = word.getBytes();
		for(int i = 0; i < bytes.length; i++) {
		    System.out.print(" " + bytes[i]);
		}		
		
		System.out.print("\n");		
	    }
	} catch (Exception e) {
	    System.out.println(" file " + file + " not found or corrupt");
	}

    }
    

}
