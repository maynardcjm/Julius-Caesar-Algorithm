// Packages
import java.util.Scanner;

public class Juilius_Ceasar_Algorithm {
	// Global Scanners
	public static Scanner sc = new Scanner(System.in);
//	public static Scanner scan = new Scanner(System.in);
	// Global Variable
	public static char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

//-----Class Methods---------Class Methods---------Class Methods---------Class Methods-------------//	
	public static void caeserEncryption() {
	/* Method Description:
	 * Ask user for a message to encrypt
	 * Ask user for a key to use for encryption algorithm
	 * Then loops through each letter of message and performs calculations
	 * -> for the cipher text of the message. Creates an encrypted message.
	 * 
	 * */
		
		
		
		// Method Variables:		
		String encryption = "";	// creates a variable for the new encrypted message
		int key = 0;
		
		// Prompt User for input
		System.out.println("Please enter a message to encrypt: ");
		
		String message = sc.next() + sc.nextLine(); // apparently, scanner.next____ can get confused when reading the data type in front and will register the new string as null. 
				
		System.out.println("you entered the message " + message);
		
		System.out.println();
		System.out.println("Please enter an encryption key: ");
		key = sc.nextInt();
		
		
		// Encrypt Message using Julius Caeser Encryption Algorithm
		for(int i = 0; i < message.length(); i++) { // loops through all letters in message
			for(int j = 0; j < 26; j++) { // loops through all letters in the alphabet
		
		// When letter in alpha bet equals the current letter in the message
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
	} // end of caesarEncryption() // end of caesarEncryption() // end of caesarEncryption()
	public static void calculate_real_message(String[] decryption_pos) {
		
		/*This method will create an array of the most commonly used English words
		 * Then compare the decryption possibilities and count how many of the common
		 * words are used in the message.
		 * 
		 * Keep an array for each message containing the number of matches, and
		 * return the message with the most commonly used words in it.
		 * 
		 * */
		boolean swt = false;
		int best_decryption = 0;
		String[] common_words = {"the","be","to","of","and","i","in","that","it","for","not","on","with","as","do","at","this"};
		int[] message_score = new int[decryption_pos.length];
		// loop through possible decryptions
		for(int outer = 0; outer < decryption_pos.length; outer++) {
			
			
			if(outer == decryption_pos.length-1 && swt == false) {
				
				if(message_score[outer+1] < message_score[outer]) {
					best_decryption = outer;
					
				}
				
				
				
				if(outer == decryption_pos.length-2) {
					swt = true;
				}
				continue;
			}
			
			// loops through common words
			for(int inner = 0; inner < common_words.length; inner++) {
				
				if(decryption_pos[outer].contains(common_words[inner])) {
					message_score[outer] +=1; // counts common words found in message
					
				}
				
				
				
			}
			
		}
		
	}
	
	public static void caesarDecryption(String message, int key) {
		/* A message and key is passed to the method
		 * With this data, the get_letter_index function is called to return the numerical position of 
		 * each letter of the message.
		 * 
		 * Once the indexing of the message is complete an algorithm is performed to decrypt the message.
		 * Outputs the plain text message
		 * */
		
		
		// ----FLAG MOVED FROM CAESARHACK() ALGORITHM FLAG-----
		String message_temp = "";
		// Remove Spaces		
		for(int i = 0; i < message.length(); i++) {
			if(message.charAt(i) == ' ') {
			}
			else {
				message_temp += message.charAt(i);
			}
		}
		
		message = message_temp;
		
		
		
		//System.out.println("The message you are trying to decrypt is: " + message);
		// Method Storage: 
		int[] index_of_cipherText = get_letter_index(message); // Function call to get index values		
		int decipher_index = 0;
		int calculation=0;
		
	/*	
		System.out.print("The indexes of the message you are trying to decrypt is: ");
		for(int i = 0; i < message.length(); i ++) {
		System.out.print("  " + index_of_cipherText[i]);
		}
		System.out.println();
		
	*/	
		System.out.print("The message is: ");
		
		// Decryption Algorithm: 
		for(int position = 0; position < index_of_cipherText.length; position++) { // loop through letters in message
			
// While key is less than the cipher text shifting text can be done simply by subtraction
			if(key <= index_of_cipherText[position]) {
					decipher_index = index_of_cipherText[position]-key;
				
			}
			else { 
// if the key is greater than the cipher text must go back from 25 the distance from cipher letter to zero  
// add one to account for zero in calculation
				calculation = key-index_of_cipherText[position]; // can't i make these one line?
				decipher_index = 25 - calculation+1; // these
			} 
			// Outputs message
			System.out.print(alpha[decipher_index]);
			
		} // end of inner for
		
		
		
		System.out.println();System.out.println();
}
	
	public static int caeserHack(String message) {
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
		
		
		String message_temp = "";
		
		// Removes Spaces 
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
	//	for (int i = 0; i < decryption.length; i ++) {
	//	System.out.println("Message Decryption using key: " + (i+1) + decryption[i]);
	//	}
		
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		// Get real message
		// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		
		/* The following code loops through a number of common words and calculates the message 
		 * with the most common words, assuming that the real message will contain the most real words
		 * */
		
		boolean swt = false;
		int best_decryption = 0;
		String[] common_words = {"the","be","to","of","and","i","in","that","it","for","not","on","with","as","do","at","this"};
		int[] message_score = new int[decryption.length];
		// loop through possible decryptions
		for(int outer = 0; outer < decryption.length; outer++) {
			// loops through common words
			for(int inner = 0; inner < common_words.length; inner++) {
				
				if(decryption[outer].contains(common_words[inner])) {
					message_score[outer] +=1; // counts common words found in message
					
				}
			}
	//		System.out.println("Message word count " + (outer+1)+": " + message_score[outer]);
		}
		
		
		for(int i = 0; i < message_score.length; i++) {
			if(message_score[i] > best_decryption) {
				best_decryption = i;
				
			}
		}
		System.out.println();System.out.println();
		
		key = best_decryption +1; // adds one to account for zero
		caesarDecryption(message,key);
		
		
		return key;
	}
	
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
	
	
	public static String get_message() {
		sc.reset();
		String message ="";
		int select = 0;
		
		while(select!=9) {
			System.out.println("What message would you like to use?");
			System.out.println("1) Use cipher text: ez oz zc yze ez oz esle td esp bfpdetzy");			
			System.out.println("2) Use cipher text: jryy qbar v nccergvngr vg");
		//	System.out.print("3) Type your own message: ");
		//	System.out.println("9) Quit"); // Consider this will lead you in the above method.. will not bring you to main menu unless specific branches are defined.

			select = sc.nextInt();
			//sc.reset();
			//if(select == 1) { message = "to do or not to do"; select = 9;}
			if(select == 1) { message = "ez oz zc yze ez oz esle td esp bfpdetzy"; select = 9; }
			if(select == 2) { message = "jryy qbar v nccergvngr vg"; select = 9;}
		//	if(select == 3) {message = sc.next()+ sc.nextLine(); select = 9;}
			
			
		//	if(select == 9) { message = ""; return message;} 
			
		}		
		

		return message;
	}
	
	
	//----Main Methods-------Main Methods-------Main Methods-------Main Methods-------Main Methods---//
	public static void main(String[] args) {
		
		String message = "";
		int selection = 0;
		int key = 0;
		
		
		while(selection!=9) {
			
			System.out.println("Main Menu:");
			
			System.out.println("1) CaesarEncrypt\n2) caeserHack\n3) caesarDecrypt\n9) quit");
			
			System.out.println("Please select a method by entering the associated integer number");
			
			selection = sc.nextInt();
			
			if(selection == 1) {caeserEncryption();  }
			if(selection == 2) { 
				
				message = get_message();
				System.out.println("The key for the algorithm is probably: " + caeserHack(message)); }
			
			if(selection == 3) {
				
				message = get_message();
				System.out.println("Getting key from hacker.......");
				key = 11;//caeserHack(message);
				System.out.println("Received key from hacker.......");
				System.out.println("Decryption in process.......");
				caesarDecryption(message,key);
			}
			}
			

		System.out.println("GoodBye!");
		
		
		
		
/*		WORKING CODE COMMENTED OUT FOR BUILDING NEW INTERFACE	
String message = "to do or not to do that is the question";
String encryption = "";



int key = 11;



// Encrypt Message
for(int i = 0; i < message.length(); i++) {
	for(int j = 0; j < 26; j++) {
	if(message.charAt(i) == alpha[j]) {
		encryption+=alpha[(int)((j+key)%26)];
		}	// end of if
	} // end of nested for
}// end of outer for

System.out.println(encryption);
System.out.print("Indexes: ");
/////////////////////////////////////////////////////////////////////////////////

// Get index values for cipher text letters
// Values range from 0 - 25 
// zero represents 'a' then the index increments chronologically through 'z' which is 25
encryption = "jryyqbarvnccergvngrvg";

int[] index = new int[encryption.length()];

for(int i = 0; i < encryption.length(); i++) {
	for(int j = 0; j < 26; j++) {
		if(encryption.charAt(i) == alpha[j]) {
		index[i]=j;
		}	// end of if
	} // end of inner for
	System.out.print(index[i] + " ,"); // outputs the indexes
} // end of outer for

System.out.println();

System.out.println("Array length: " + index.length);


caeserHack(index);

//caesarDecryption(index , 11);

*/
//////////////////////// end of main ///////////////////////////////////////////
	}
	// End of Class	// End of Class	// End of Class	// End of Class	// End of Class	// End of Class 
}
