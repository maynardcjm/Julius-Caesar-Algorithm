import java.util.Scanner;

public class simple_JC_alg{
// Global Scanner
	public static Scanner sc = new Scanner(System.in);
// Global Variable
	public static char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	
	public static void main(String[] args) {
		String message = "";
		int selection = 0;
		int key = 0;
		
		
		while(selection!=9) {
			
			System.out.println("Main Menu:");		
			System.out.println("1) CaesarEncrypt\n2) caesarDecrypt\n9) quit");	
			System.out.println("Please select a method by entering the associated integer number");
			
			selection = sc.nextInt(); // get user's selection
			
			if(selection == 1) {caeserEncryption();  }
			if(selection == 2) { 
				
				message = "ez oz zc yze ez oz esle td esp bfpdetzy";
				key = 11;//caeserHack(message);
				System.out.println("Decryption in process.......");
			//	caesarDecryption(message,key);
				cDecrypt();
			}
		}// end of menu loop
			

		System.out.println("GoodBye!");
		
		
	}// end of main method
	
	public static void cDecrypt() {
		/* Method Description:
		 * 
		 * 
		 * 
		 * */

		// Method Storage: 
		
		int key = 1; // key == 0 means no encryption
		int n = 0;
		int decipher_index = 0;
		int calculation=0;
		
		System.out.println("Please enter a message to encrypt: ");
		String message = sc.next() + sc.nextLine(); // apparently, scanner.next____ can get confused when reading the data type in front and will register the new string as null. 
		// Respond With Received Message		
		System.out.println("you entered the message " + message);
		String message_temp = "";
		
		
		// Removes Spaces from message
		for(int i = 0; i < message.length(); i++) {
			if(message.charAt(i) == ' ') {
			}
			else {
				message_temp += message.charAt(i);
			}
		}
		
		message = message_temp;
		int[] index_of_cipherText =  get_letter_index(message); // Function call to get index values	
		
		System.out.println("The cipher text you are trying to hack is: " + message);
		
		String[] decryption = new String[26]; // holds the message deciphered by different key values
		
		// To avoid null pointer exception
		// Java will naturally set unspecified values to = null when not initiated
		// Therefore each instance of the array must be initiated to an empty string to avoid null pointers
		for(int i = 0; i < decryption.length; i++) {
			decryption[i] = "";}
	
		// Note to self: similar to caeser decrypt, but requires a nested loop to range through all possible keys
		System.out.println("Attempting to crack code: ");
		System.out.println();
		//--- FLAG changed i < 26 to i <= FLAG ---
		for(int i = 0; i <= 26; i++) { // loops through possible key values
			for(int position = 0; position < index_of_cipherText.length; position++) { // loop through letters in message
				if(n==26) {break;}
				if(key <= index_of_cipherText[position]) {
						
					decipher_index = index_of_cipherText[position]-key;
					decryption[n]+= alpha[decipher_index];
	
				}
				else {
					calculation = key-index_of_cipherText[position];
					decipher_index = 25 - calculation+1;
			//		System.out.println(" cipher index = " + decipher_index);
					decryption[n]+= alpha[decipher_index];
				} 
				System.out.print(alpha[decipher_index]);
				
			} // end of inner for
			System.out.println();
				key++;
				n++;
		} // end of outer for
		
	}// end of method

	public static void caeserEncryption() {
		/* Method Description:
		 * Ask user for a message to encrypt
		 * Ask user for a key to use for encryption algorithm
		 * Then loops through each letter of message and performs calculations
		 * -> for the cipher text of the message. Creates an encrypted message.
		 * 
		 * */
			
			// Method Variables and Obtaining User Input	
			String encryption = "";	// store encrypted message
			int key = 0;            // store key
			// Prompt User for message
			System.out.println("Please enter a message to encrypt: ");
			String message = sc.next() + sc.nextLine(); // apparently, scanner.next____ can get confused when reading the data type in front and will register the new string as null. 
			// Respond With Received Message		
			System.out.println("you entered the message " + message);
			// Prompt User for Encryption Key
			System.out.println("Please enter an encryption key: ");
			key = sc.nextInt();
			
			
			// Encrypt Message using Julius Caeser Encryption Algorithm
			for(int i = 0; i < message.length(); i++) { // loops through all letters in message
				for(int j = 0; j < 26; j++) {          // loops through all letters in the alphabet
			
			// When letter in alphabet equals the current letter in the message
			// Calculate the julius caesar algorithm for the letter at j with specified key 	
			// Adds the letter within the alphabet of ciphertext to make an encrypted message.		
					if(message.charAt(i) == alpha[j]) {
					encryption+=alpha[(int)((j+key)%26)];
					
					}	// end of if
				} // end of nested for
			}// end of outer for
			
			// Displays the new encrypted message
			System.out.println("The encrypted message is: " + encryption);
			System.out.println(); System.out.println();
	} // end of method caesarEncryption() 
	public static int[] get_letter_index(String message) {
		
		// Get index values for cipher text or plain text letters
		// Values range from 0 - 25 
		// zero represents 'a' then the index increments chronologically through 'z' which is 25
		
		int[] index = new int[message.length()]; // creates an integer array to hold the index

		for(int i = 0; i < message.length(); i++) {
			for(int j = 0; j < 26; j++) {
				if(message.charAt(i) == alpha[j]) {
				index[i]=j;
				}	// end of if
			} // end of inner for
//			System.out.print(index[i] + " ,"); // outputs the indexes
		} // end of outer for

		return index;
	}
} // END OF CLASS