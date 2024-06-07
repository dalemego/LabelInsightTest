package labelinsighttest;

import java.util.HashSet;
import java.util.Set;

public class MissingLetters {

    public static void main(String[] args) {
        String sentence1 = "A quick brown fox jumps over the lazy dog";
        String sentence2 = "A slow yellow fox crawls under the proactive dog";
        String sentence3 = "Lions, and tigers, and bears, oh my!";
        String sentence4 = "";
        System.out.println("Result 1: " + getMissingLetters(sentence1));
        System.out.println("Result 2: " + getMissingLetters(sentence2));
        System.out.println("Result 3: " + getMissingLetters(sentence3));
        System.out.println("Result 4: " + getMissingLetters(sentence4));
    }

    private static String getMissingLetters(String sentence) {
        //HashSet will allow me to have unique items to keep a record of missing letters
        Set<Character> letterSet = new HashSet<>();

        for(int i = 0 ; i< sentence.length(); i++) {
            char letter = sentence.charAt(i);
            //only look for alphabet characters
            if(letter >= 'a' && letter <= 'z') {
                letterSet.add(letter);
            }
            else if(letter >= 'A' && letter <= 'Z') {
                //if an uppercase is found we should convert it to lower case
                letterSet.add(Character.toLowerCase(letter));
            }
        }

        StringBuilder missingLetters = new StringBuilder();

        //iterate over a-z to find missing letters in the HashSet
        //this approach will also ensure the output is in order
        for(char c = 'a'; c <= 'z'; c++){
            if(!letterSet.contains(c)) {
                missingLetters.append(c);
            }
        }
        return missingLetters.toString();
    }
}
