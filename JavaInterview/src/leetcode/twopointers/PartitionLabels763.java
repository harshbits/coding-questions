package leetcode.twopointers;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.

 * @author habhavsar
 *
 */
public class PartitionLabels763 {

	public static void main(String[] args) {
		var S = "ababcbacadefegdehijhklij";
		var ans = new PartitionLabels763().partitionLabels(S);
		System.out.println(ans);
	}

	public List<Integer> partitionLabels(String S) {

		if(S == null || S.length() == 0) {
			return new ArrayList<>();
		}
		char[] sc = S.toCharArray();
		// O(1) Space
		// Constant Space
		var lastOcc = new int[26];
		// O(n) time
		for (int i = 0; i < S.length(); i++) {
			lastOcc[sc[i] - 'a'] = i;
		}
		var startIndex = 0;
		var endIndex = 0;
		List<Integer> ans = new ArrayList<>();
		// O(n) time
		for (int i = 0; i < S.length(); i++) {
			endIndex = Math.max(endIndex, lastOcc[sc[i] - 'a']);
			if (endIndex == i) {
				ans.add(endIndex - startIndex + 1);
				startIndex = endIndex + 1;
			}
		}
		return ans;
	}
}
