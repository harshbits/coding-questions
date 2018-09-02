package google.leetcode;

public class CouplesHoldingHands765 {

	public static void main(String[] args) {
		CouplesHoldingHands765 c = new CouplesHoldingHands765();
//		int[] row = { 2, 3, 1, 0, 5, 4 };
		int[] row = { 3, 5, 0, 2, 4, 1 };
		int ans = c.minSwapsCouples(row);
		System.out.println(ans);
	}

	public int minSwapsCouples(int[] row) {

		int ans = 0;
		int n = row.length;

		int[] partner = new int[n];
		int[] position = new int[n];

		
		for (int i = 0; i < n; i++) {
			// partner of each index
			partner[i] = i % 2 == 0 ? i + 1 : i - 1;
			// position of current person
			position[row[i]] = i;
		}
		
		for (int i = 0; i < n; i++) {
			// j = person at the position of current persons' partner
			for (int j = partner[position[partner[row[i]]]]; i != j; j = partner[position[partner[row[i]]]]) {
				swap(row, i, j);
				swap(position, row[i], row[j]);
				ans++;
			}
		}

		return ans;
	}
	
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
