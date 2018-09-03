package google.leetcode.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

a) it                      --> it    (no abbreviation)

     1
     ↓
b) d|o|g                   --> d1g

              1    1  1
     1---5----0----5--8
     ↓   ↓    ↓    ↓  ↓    
c) i|nternationalizatio|n  --> i18n

              1
     1---5----0
     ↓   ↓    ↓
d) l|ocalizatio|n          --> l10n
Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

Example:

Given dictionary = [ "deer", "door", "cake", "card" ]

isUnique("dear") -> false
isUnique("cart") -> true
isUnique("cane") -> false
isUnique("make") -> true
 * 
 * @author hbhavsar
 *
 */
public class UniqueWordAbbreviation288 {

	public static void main(String[] args) {
		
		String[] dictionary = { "deer", "door", "cake", "card" };
		UniqueWordAbbreviation288 u = new UniqueWordAbbreviation288(dictionary);
		System.out.println(u.isUnique("dear"));
		System.out.println(u.isUnique("cart"));
		System.out.println(u.isUnique("cane"));
		System.out.println(u.isUnique("make"));
		
	}
	
	private Set<String> dictionary;
	
	private Map<String, Boolean> abbreviatedDictionary;
	
	public UniqueWordAbbreviation288(String[] dictionary) {
		this.dictionary = new HashSet<>();
		this.abbreviatedDictionary = new HashMap<>();
		
		if (dictionary != null) {
			for (String s : dictionary) {
				this.dictionary.add(s);
				String as = covertToAbbreviation(s);
				// abbreviatedDictionary.add(as);
//				if (abbreviatedDictionary.containsKey(as)) {
//					abbreviatedDictionary.put(as, false);
//				} else {
//					abbreviatedDictionary.put(as, true);
//				}
				abbreviatedDictionary.put(as, !abbreviatedDictionary.containsKey(as));
			}
		}
//		System.out.println("loaded");
	}

	public boolean isUnique(String word) {
		String s = covertToAbbreviation(word);
		// return abbreviatedDictionary.get(s) != null ? abbreviatedDictionary.get(s) :
		// true;
		Boolean hasAbbr = abbreviatedDictionary.get(s);
		return hasAbbr == null || (hasAbbr && dictionary.contains(word));

	}
	
    
    private String covertToAbbreviation(String word) {
    	if(word.length() <=2) {
    		return word;
    	}
		int middle = word.length() - 2;
//		StringBuilder sb = new StringBuilder();
//		sb.append(word.charAt(0)).append(middle).append(word.charAt(word.length() - 1));		
		String s = word.charAt(0) + Integer.toString(middle) + word.charAt(word.length() - 1);
    	return s;
    }
	
	
	
}
