// Problem Statement:


// Ananth interested in creating the acronyms for any word.
// The definition of acronym is another word with a concatenation of its first letter,
//  the number of letters between the first and last letter, and its last letter. 
 
//  If a word has only two characters, then it is an acronym of itself.
 
//  Examples:
// 	- Acronym of 'dog' is 'd1g'.
// 	- Acronym of 'another' is 'a5r'.
// 	- Acronym of 'ab' is 'ab'.

// You are given a list of vocabulary, and another list of words.
// Your task is to check is word with the vocabulary and
// return "true" if atleast one of the following rules satisfied:
// 	1. acronym of the word should not match with any of the acronyms of vocabulary
// 	2. if acronym of the word matches with any of the acronyms of vocabulary
// 	'the word' and matching words in vocabulary should be same.
// Otherwise, return 'false'.

// Input Format:
// -------------
// Line-1: Space separated strings, vocabulary[] 
// Line-2: Space separated strings, words[] 

// Output Format:
// --------------
// Print N boolean values, where N = words.length. 


// Sample Input-1:
// ---------------
// cool bell cool coir move more mike
// cool char move 

// Sample Output-1:
// ----------------
// true false false

import java.util.*;
public class ValidWordAbbrevation {
    HashMap<String, String> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<String, String>();
        for(String str:dictionary){
            String key = getKey(str);
            // If there is more than one string belong to the same key
            // then the key will be invalid, we set the value to ""
            if(map.containsKey(key) && !map.get(key).equals(str))
                map.put(key, "");
            else
                map.put(key, str);
        }
    }
    public boolean isUnique(String word) {
        String key = getKey(word);
        return !map.containsKey(key)||map.get(key).equals(word);
    }
    private String getKey(String str){
        if(str.length()<=2) return str;
        return str.charAt(0)+Integer.toString(str.length()-2)+str.charAt(str.length()-1);
    }
    
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String dictionary[]=sc.nextLine().split(" ");
        String words[]=sc.nextLine().split(" ");
        ValidWordAbbr vwa=new ValidWordAbbr(dictionary);
        for(String word:words)
            System.out.print(vwa.isUnique(word)+" ");
    }
}   

