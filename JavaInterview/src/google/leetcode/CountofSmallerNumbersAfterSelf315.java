package google.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Input: [5,2,6,1]
Output: [2,1,1,0] 
Explanation:
To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller elemen
 * 
 * @author hbhavsar
 *
 */
public class CountofSmallerNumbersAfterSelf315 {

	class Node {
		Node left, right;
		int val, leftNum, currentNum;

		public Node(int v) {
			val = v;
			currentNum = 1;
		}
	}

	public static void main(String[] args) {
		CountofSmallerNumbersAfterSelf315 c = new CountofSmallerNumbersAfterSelf315();
		int[] nums = { 3, 2, 2, 6, 1 };
		List<Integer> ans = c.countSmaller(nums);
		System.out.println(ans);
	}

	//
	public List<Integer> countSmaller(int[] nums) {
		if (nums == null || nums.length == 0) {
			return new ArrayList<>();
		}
		int n = nums.length;
		Integer[] count = new Integer[n];

		// starts with bottom, left most
		count[nums.length - 1] = 0;
		
		// 3, 2, 2, 6, 1
		// 1
		Node root = new Node(nums[n - 1]);
		
		for (int i = n - 2; i >= 0; i--) {
			count[i] = insert(root, nums[i]);
		}
		
//		System.out.println(root);
		return Arrays.asList(count);
	}
	
	// 3, 2, 2, 6, 1
	
	// 
	//	 			 	1 (1, 0)
	//						\
	//			   			 \
	//						6 (1, 3)
	//						/		
	//					   /
	//					2 (2, 1)
	//						\	
	//				   		  \
	//						3 ( 1, 0)			
				   
	
	
	public int insert(Node node, int value) {
		if (value < node.val) {
			++node.leftNum;
			if (node.left == null) {
				node.left = new Node(value);
				return 0;
			} else {
				return insert(node.left, value);
			}
		} else if (value > node.val) {
			if (node.right == null) {
				node.right = new Node(value);
				return node.currentNum + node.leftNum;
			} else {
				return node.currentNum + node.leftNum + insert(node.right, value);
			}
		}
		// both values are same
		else {
			++node.currentNum;
			return node.leftNum;
		}
	}
	
	
	
}
