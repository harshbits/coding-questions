package google.leetcode;

/**
 * 
 * There is a fence with n posts, each post can be painted with one of the k colors.

You have to paint all the posts such that no more than two adjacent fence posts have the same color.

Return the total number of ways you can paint the fence.

Note:
n and k are non-negative integers.

Example:

Input: n = 3, k = 2
Output: 6
Explanation: Take c1 as color 1, c2 as color 2. All possible ways are:

            post1  post2  post3      
 -----      -----  -----  -----       
   1         c1     c1     c2 
   2         c1     c2     c1 
   3         c1     c2     c2 
   4         c2     c1     c1  
   5         c2     c1     c2
   6         c2     c2     c1
 * 
 * @author hbhavsar
 *
 */
public class PaintFence276 {

	
	public static void main(String[] args) {
		PaintFence276 p = new PaintFence276();
		int ans = p.numWays(3, 2);
		System.out.println(ans);
	}
	
	
	public int numWays(int n, int k) {
		
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return k;
		}
		
		int diffColors = k * (k - 1);
		int sameColors = k;
		
		for (int i = 2; i < n; i++) {
			int temp = diffColors;
			diffColors = (diffColors + sameColors) * (k - 1);
			sameColors = temp;
		}
		
		return diffColors + sameColors;
	}
	
	
}
