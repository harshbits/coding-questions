package onlineAssessAz;

/**
 * Amazon phone interview A queue of people are waiting to buy ice cream from
 * you. Each person buys one ice cream, which sells for $5. Each customer is
 * holding a bill of $5, $10 or $20. Your initial balance is 0. Find whether you
 * will be able to make change for every customer in the queue. You must serve
 * customers in the order they come in.
 * 
 * For example 5, 5, 5, 10, 20 -> true, 5, 5, 10 -> true, 10, 10 -> false
 * 
 * @author hbhavsar
 *
 */
public class IceCreamQueue {

	
	public static void main(String[] args) {
		int[] dollars = { 5, 5, 5, 10, 20 };
		
		System.out.println(isChangeable(dollars));
		
		int[] dollars1 = { 10, 20 };
		
		System.out.println(isChangeable(dollars1));
	}
	private static boolean isChangeable(int[] dollars) {
		if (dollars == null || dollars.length == 0)
			return true;
		int fiveCount = 0;
		int tenCount = 0;
		for (int i : dollars) {
			if (i == 5) {
				++fiveCount;
			} else if (i == 10) {
				if (fiveCount < 1) {
					return false;
				}
				++tenCount;
				--fiveCount;
			} else if (i == 20) {
				if (tenCount > 0 && fiveCount > 0) {
					++tenCount;
					--fiveCount;
				} else if (fiveCount > 2) {
					fiveCount -= 3;
				} else {
					return false;
				}
			}
		}
		return true;
	}

}
