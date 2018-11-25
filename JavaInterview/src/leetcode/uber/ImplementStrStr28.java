package leetcode.uber;

public class ImplementStrStr28 {

	public static void main(String[] args) {
		// doesnt work in var
//		var haystack = "hello", needle = "ll";
		var haystack = "hello";
		var needle = "ll";
		var ans = new ImplementStrStr28().strStr(haystack, needle);
		System.out.println(ans);
		
		
		haystack = "aaa";
		needle = "aaaa";
		ans = new ImplementStrStr28().strStr(haystack, needle);
		System.out.println(ans);
	}

	// default java
	// beats 99.83 % of the result
//	public int strStr(String haystack, String needle) {
//		return haystack.indexOf(needle);
//	}
	
	
	// beats 57.47% of the results
	public int strStrImproved(String haystack, String needle) {
		
		if(needle.length() == 0) return 0;
		
//		if(haystack == null || haystack == null) return 0;
//		
//		if (haystack.length() == 0 && needle.length() == 0) return 0;
		 
		char[] hc = haystack.toCharArray();
		char[] nc = needle.toCharArray();
		for (int i = 0; i < hc.length; i++) {
			
			// as there is no solution exists
			if(needle.length() > haystack.length() - i) return -1;
			
//			int ii = i;
//			int count = 0;
			for (int j = 0; j < nc.length; j++) {
				if (i + j < hc.length && hc[i + j] != nc[j]) {
//					count++;
					break;
				}
				
				if(j == needle.length() - 1) return 1;
			}
		}
			
		return -1;
	}
	
	
	
	// beats only 8.96%
	public int strStr(String haystack, String needle) {
		
		if(haystack == null || haystack == null) return 0;
		
		if (haystack.length() == 0 && needle.length() == 0) return 0;
		 
		char[] hc = haystack.toCharArray();
		char[] nc = needle.toCharArray();
		for (int i = 0; i < hc.length; i++) {
			
			int ii = i;
			int count = 0;
			for (int j = 0; j < nc.length; j++) {
				if (ii < hc.length && hc[ii] == nc[j]) {
					ii++;
					count++;
				}else {
					break;
				}
			}
			if(count == nc.length) {
				return i;
			}
		}
			
		return -1;
	}

}
