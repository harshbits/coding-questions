import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SeatSelection {

	public static void main(String[] args) {
//
//		String[] sss = "1A".split("((?<=[a-zA-Z])(?=[0-9]))|((?<=[0-9])(?=[a-zA-Z]))");
//		System.out.println(sss[0]);
//		System.out.println(sss[1]);
//		
//		sss = "A1".split("((?<=[a-zA-Z])(?=[0-9]))|((?<=[0-9])(?=[a-zA-Z]))");
//		System.out.println(sss[0]);
//		System.out.println(sss[1]);
		
		int N = 2;
		String S = "1A 2F 1C";
		int ans = new SeatSelection().solution(N, S);
		System.out.println(ans == 4);
		
		
		N = 3;
		S = "1A 1B 1C";
		ans = new SeatSelection().solution(N, S);
		System.out.println(ans == 8);
		
		N = 3;
		S = "1M 1B 1C";
		ans = new SeatSelection().solution(N, S);
		System.out.println(ans == 8);
		
		
		
		
		
		
	}
	
	private static final Map<String, Integer> seatLabels = new HashMap<>() {
		private static final long serialVersionUID = 1L;
		{
			put("A", 0);
			put("B", 1);
			put("C", 2);
			put("D", 3);
			put("E", 4);
			put("F", 5);
			put("G", 6);
			put("H", 7);
			put("J", 8);
			put("K", 9);
		}
	};

	public int solution(int N, String S) {
		// write your code in Java SE 8

		// if there are no rows
		if (N <= 0) {
			return 0;
		}

		// for Java 11
		// if (S == null || S.isBlank())) {

		// if there are no seats reserved
		if (S == null || S.trim().isEmpty()) {
			// As one row can contain 3 families
			return N * 3;
		}

		int[][] seats = new int[N][10];

		// reserved seats
		String[] reserved = S.split(" ");

		for (String s : reserved) {
			// Get row and column
//			int row = Integer.parseInt(s.substring(0, s.length() - 1)) - 1;
//			int column = seatLabels.get(s.substring(s.length() - 1));

			// we can also split this by regex
			String[] parts = s.split("((?<=[a-zA-Z])(?=[0-9]))|((?<=[0-9])(?=[a-zA-Z]))");
			int row = Integer.parseInt(parts[0]) - 1;
			int column = seatLabels.get(parts[1]);
			
			// for performance improvement, we can convert to char array and convert it.
//			char[] sc = s.toCharArray();
//			for (int i = 0; i < sc.length; i++) {
//			}
//			column = seatLabels.get(String.valueOf(sc[s.length() - 1]));

			// mark occupied seat as 1
			seats[row][column] = 1;

		}

		int maxFamily = 0;
		// Count available number of seats for family by row
		for (int i = 0; i < seats.length; i++) {

			int currentFree = 0;
			
			for (int j = 0; j < 3; j++) {
				int seatValue = seats[i][j];

				if (seatValue != 1) {
					currentFree++;
				} else {
					currentFree = 0;
					break;
				}
			}
			if (currentFree == 3) {
				maxFamily++;
				currentFree = 0;
			}
			
			
			for (int j = 3; j < 7; j++) {

			}
			
			
			for (int j = 7; j < seats[0].length; j++) {

			}
			
			
			
			for (int j = 0; j < seats[0].length; ++j) {

				int seatValue = seats[i][j];
				
				if (seatValue != 1) {
					currentFree++;
				}
				
				// Analyze first block (A,B,C)
				if (j < 3 && seatValue == 1) {
					j = 2;
					currentFree = 0;
					continue;
				}
				if (j == 2) {
					if (currentFree >= 3) {
//						System.out.println("max family first block");
						maxFamily++;
					}
					currentFree = 0;
					continue;
				}

				// Analyze second block (D,E,F,G)
				if (j > 2 && j < 7) {
					if (currentFree >= 3) {
//						System.out.println("max family second block");
						maxFamily++;
						j = 6;
						currentFree = 0;
						continue;
					}
					
					if (currentFree > 0 && seatValue == 1) {
						j = 6;
						currentFree = 0;
						continue;
					}
				}

				// Analyze third block (H,J,K)
				if (j > 6 && seatValue == 1) {
					j = seats[0].length;
					currentFree = 0;
					continue;
				}
				if (j == 9) {
					if (currentFree >= 3) {
//						System.out.println("max family third block");
						maxFamily++;
					}
					currentFree = 0;
					continue;
				}

			}

		}

		return maxFamily;
	}
}
