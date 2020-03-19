package google.leetcode_2020.tree;
/**
 * Range Sum Query
 * Binary Index Query
 * 
 * @author hbhavsar
 *
 */
public class FenwickTree {
	
	// Numbers
	int[] nums;
	// Binary Index Tree
	int[] BIT;
	// Length of nums
	int n;

	
	public FenwickTree(int[] nums) {
		this.nums = nums;
		this.n = nums.length;

		for (int i = 0; i < n; i++) {
			init(i, nums[i]);
		}
	}
	
	
	// Initialize Binary Index Tree
	public void init(int i, int value) {

		i++;
		while (i <= n) {
			BIT[i] += value;
			// Update i
			// bitwise end with opposite binary
			// to get last bit
			i += (i & -i);
		}

	}
	
	public void update(int i, int val) {
		// Difference between old and new value
		int diff = val - nums[i];
		// update with new value
		nums[i] = val;
		init(i, diff);

	}
	
	
	private int getSum(int i) {
		int sum = 0;
		i++;
		while (i > 0) {
			sum += BIT[i];
			i -= (i & -i);
		}
		return sum;
	}

	public int sumRange(int i, int j) {
		return getSum(j) - getSum(i - 1);
	}
}

/**
 * Your NumArray object will be instantiated and called as such: NumArray obj =
 * new NumArray(nums); obj.update(i,val); int param_2 = obj.sumRange(i,j);
 */