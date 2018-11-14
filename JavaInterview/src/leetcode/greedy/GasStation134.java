package leetcode.greedy;

public class GasStation134 {

	public static void main(String[] args) {
		int[] gas = { 1, 2, 3, 4, 5 };
		int[] cost = { 3, 4, 5, 1, 2 };
		
		var ans = new GasStation134().canCompleteCircuit(gas, cost);
		System.out.println(ans);
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {

		int total = 0;
		int start = 0;
		int tank = 0;
		
		for (int i = 0; i < gas.length; i++) {
			tank += gas[i] - cost[i];
			
			if (tank < 0) {
				// move starting position forward
				start = i + 1;
				// add the negative tank value to total
				total += tank;
				tank = 0;
			}
		}
		return total + tank < 0 ? -1 : start;
	}

	
	public int canCompleteCircuit1(int[] gas, int[] cost) {
		// determine if we have a solution
		int total = 0;
		for (int i = 0; i < gas.length; i++) {
			total += gas[i] - cost[i];
		}
		//if total is less than 0 then we can not reach to our original start point
		if (total < 0) {
			return -1;
		}

		// find out where to start
		int tank = 0;
		int start = 0;
		for (int i = 0; i < gas.length; i++) {
			tank += gas[i] - cost[i];
			if (tank < 0) {
				 //move starting position forward
				start = i + 1;
				tank = 0;
			}
		}
		return start;
	}
}
