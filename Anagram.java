/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String processed1 = preProcess(str1);
		String processed2 = preProcess(str2);
		String copy = "";
		boolean found = false;
		if (processed1.length() != processed2.length()){
        return false;
		}
		else{
			for (int i = 0; i< processed1.length(); i++){
				for (int j = 0; j < processed2.length(); j++){
					if (processed2.charAt(j) != processed1.charAt(i) || found == true){
						copy = copy + processed2.charAt(j);
					}
					else {
						if (processed2.charAt(j) == processed1.charAt(i) && found == false){
							found = true;
						}
					}	
				}
				processed2 = copy;
				found = false;
                if (processed2.length()== processed1.length()) {
					return false;
				}		
			}
			return true;
		}
	}




	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String processed = "";
		String original = str;
		for (int i = 0; i < str.length(); i++){
			if (str.charAt(i)>= 'a' && str.charAt(i)<= 'z' ){
				processed = processed + str.charAt(i);
			}
			else{
				if (str.charAt(i)>= 65 && str.charAt(i)<= 90){
					String lower= str.charAt(i)+ "";
					lower = lower.toLowerCase();
					processed = processed + lower;
					
				}
				
			}
		}
		
		return processed;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String copy = str;
        String copy2 ="";
		String random = "";
		while (random.length() < str.length()){
			int index = (int) (Math.random () * copy.length()) ;
			random = random + copy.charAt(index);
			for (int i = 0; i < copy.length(); i++){
                if ( i != index){
					copy2 = copy2 + copy.charAt(i);
				}
			}
			copy = copy2;
			copy2 = "";
		}
		return random;
		
	}
}
