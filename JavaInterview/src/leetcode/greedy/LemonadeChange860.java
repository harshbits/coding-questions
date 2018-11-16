package leetcode.greedy;

public class LemonadeChange860 {

	public static void main(String[] args) {
		int[] bills = { 5, 5, 10 };
		var ans = new LemonadeChange860().lemonadeChange(bills);
		System.out.println(ans);

		int[] bills1 = {5,5,5,10,20};
		ans = new LemonadeChange860().lemonadeChange(bills1);
		System.out.println(ans);

		
		int[] bills2 = { 5, 5, 10, 10, 20 };
		ans = new LemonadeChange860().lemonadeChange(bills2);
		System.out.println(ans);
	
	}

	public boolean lemonadeChange(int[] bills) {

		if (bills == null || bills.length == 0)
			return true;
		
		int total5 = 0;
		int total10 = 0;
//		int total20 = 0;

		for (int b : bills) {

			if (b == 5) {
				total5++;
			} else if (b == 10) {
				if (total5 == 0) {
					return false;
				}
				total5--;
				total10++;

			} else {
				if (total5 > 0 && total10 > 0) {
					total10--;
					total5--;
				}
				else if (total5 >= 3) {
					total5 -= 3;
				} else {
					return false;
				}
//				total20++;
				
				if (total10 > 0) {
					
				}
			}
		}

		return true;
	}
}
