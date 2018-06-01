package leetcode;

public class FindTheBug {

	
	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		int x = 140;
		int y = 0;
		
		MakeTheNumbersMatch(a, b, x, y);
		
	}
	public static void MakeTheNumbersMatch(int a, int b, int x, int y) {
		// Wrong
//		while (a != x && b != y) {
//			if (a > x) {
//				a--;
//			} else {
//				a++;
//			}
//			if (b > y) {
//				b--;
//			} else {
//				b++;
//			}
//		}
		
		// Approach 1 = iterating 2 times
//		while (a != x) {
//			if (a > x) {
//				a--;
//			} else {
//				a++;
//			}
//		}
//		while ( b != y) {
//			if (b > y) {
//				b--;
//			} else {
//				b++;
//			}
//		}
		
		// Approach 2 = adding conditions in while loop
		while (a != x || b != y) {
			if (a != x) {
				if (a > x) {
					a--;
				} else {
					a++;
				}
			}
			if (b != y) {
				if (b > y) {
					b--;
				} else {
					b++;
				}
			}
		}
		
		System.out.println(a);
		System.out.println(b);
		
		
	}

}
