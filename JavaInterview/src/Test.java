import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test {

	public static void main(String[] args) {

		int a[] = { 13, 10, 21, 20, 4, 7, 8, 11 };
		System.out.println(moves2(a));
		
//		int ones = (Integer.highestOneBit(5) << 1) - 1;
	}
	

	static int moves2(int[] a) {
		int[] a1 = a;
		int count = 0;
		for (int i = a.length - 1; i >= 0; i--) {
			int current = a1[i];
			if (a1[i] % 2 == 0 && i - 1 > 0 && a1[i - 1] % 2 != 0) {
				a1 = swap(a1, 0, i, a1[0], a1[i]);
				count++;
			}
		}
		System.out.println(Arrays.toString(a1));
		return count;
	}

	static int[] swap(int[] a, int index1, int index2, int value1, int value2) {
		int[] a1 = a;
		int temp = a1[index1];
		a1[index1] = a1[index2];
		a1[index2] = temp;
		return a1;
	}
	
	
	
	static int moves(int[] a) {
		int count = 0;
//		for (int i = 0; i < a.length; i++) {
//
//			// if current is odd and next one is even, put even at place 0
//
//			// SINCE IT'S NOT ASKING FOR THE ACTUAL ARRAY, JUST THE COUNT, DON'T EVEN WORRY
//			// IF ARRAY IS CORRECT...
//			if (a[i] % 2 != 0 && a[i + 1] % 2 == 0) {
//				// a[0] = a[i];
//				count++;
//			}
//		}
		
		
		for (int i = a.length - 1; i >= 0; i--) {

			
			// if current is odd and next one is even, put even at place 0

			// SINCE IT'S NOT ASKING FOR THE ACTUAL ARRAY, JUST THE COUNT, DON'T EVEN WORRY
			// IF ARRAY IS CORRECT...
			
			if (a[i] % 2 == 0 && a[i-1] %2 !=0) {
				// a[0] = a[i];
				count++;
			}
		}
		return count;
	}

	
	
	
	
	static int moves1(int[] a) {
		int startIndex = 0;
		int endIndex = a.length - 1;

		int operations = 0;
		while (startIndex < endIndex) {
			if (a[startIndex] % 2 != 0 && a[endIndex] % 2 == 0) {
				int temp = a[startIndex];
				a[startIndex] = a[endIndex];
				a[endIndex] = temp;
				operations++;
			}

			if (a[endIndex] % 2 != 0) {
				endIndex--;
				operations++;
			}

			if (a[startIndex] % 2 == 0) {
				startIndex++;
				operations++;
			}
		}
		//
		// for (int i = 0; i < size; i++) {
		// System.out.print(arr[i] + " ");
		// }

		return operations;
	}

	//
	// int x1 = 4/0;
	//
	// int[] arr = { 5, 4, 3, 12, 3, 1 };
	// // int[] arr = new int[10];
	//
	// // Integer iInteger = new Integer(1);
	// // String ans = Arrays.asList(arr).contains(1) ? "YES" : "NO";
	// // System.out.println(ans);
	//
	// int x = getIntegerComplement(5);
	//
	// System.out.println(x);
	//
	// System.out.println(new
	// Test().firstNonRepeatingStringElement("geeksforgeeks"));
	//
	// System.out.println(firstNonRepeating("geeksforgeeks"));
	// }

	// public static void dhomdhom() {
	// int[] array = { 1, 3, 3, 4, 5, 8, 0 };
	// int temp = 0;
	//
	// for (int i = 0; i <= array.length - 1; i++) {
	// if (array[i] % 2 == 0) {
	// for (int j = i; j <= array.length - 1 - i; j++) {
	//
	// array[j] = array[i];
	// }
	// }
	//
	// // array[j+1]=array[i]
	//
	// else if (array[i] % 2 != 0) {
	// for (int j = array.length; j == 0; j--)
	// array[k + 1] = array[i];
	// System.out.println(array[j]);
	// }
	// }
	//
	// }

	//

	static int getIntegerComplement(int n) {

		
		// 101
		int ones = (Integer.highestOneBit(n) << 1) - 1;
		return n ^ ones;
	}

	public char firstNonRepeatingStringElement(String input) {
		int l = input.length();
		CountIndex[] countInx = new CountIndex[256];

		for (int i = 0; i < l; i++) {
			if (countInx[input.charAt(i)] == null)
				countInx[input.charAt(i)] = new CountIndex(i);
			else
				countInx[input.charAt(i)] = countInx[input.charAt(i)].increaseCount();

		}
		int minIndex = Integer.MAX_VALUE;
		for (int i = 0; i < 256; i++) {
			if (countInx[i] != null && countInx[i].count == 1 && minIndex > countInx[i].index) {
				minIndex = countInx[i].index;
			}
		}
		return input.charAt(minIndex);
	}

	class CountIndex {
		int count = 1;
		int index;

		public CountIndex(int index) {
			this.index = index;
		}

		public CountIndex increaseCount() {
			count = count + 1;
			return this;
		}

		@Override
		public String toString() {
			return "count=" + count + ", index=" + index;

		}
	}

	private static String firstNonRepeating(String s) {
		Map<Character, Integer> map = new LinkedHashMap<>();
		for (int i = 0; i < s.length(); i++) {
			Character ch = s.charAt(i);
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		for (Map.Entry<Character, Integer> entry : map.entrySet())
			if (entry.getValue() == 1)
				return entry.getKey().toString();

		//

		return null;
	}

}
