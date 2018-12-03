package leetcode.uber.dp;

public class DecodeWays91 {

	public static void main(String[] args) {
		
	}
	
	
	public int numDecodings(String s) {
		
//		if (s == null || s.isEmpty()) {
//			return 0;
//		}
		
		// Only support in java > 8
		if (s == null || s.isBlank()) {
			return 0;
		}
		
		char[] sc = s.toCharArray();
		
		int dp1 = 1;
		int dp2 = 1;
		
		for (int i = 0; i < sc.length; i++) {
			
			if(sc[i] == '0') {

				// check the correctness of number
				if (i == 0 || (sc[i - 1] != '1' && sc[i - 1] != '2')) {
					return 0;
				}
				
			}
			
		}
		
		return dp1;
	}
}
