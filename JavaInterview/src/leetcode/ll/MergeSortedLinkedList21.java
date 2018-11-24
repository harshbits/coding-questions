package leetcode.ll;

public class MergeSortedLinkedList21 {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		
		if(l1 == null && l2 == null) return l1;
		if( l1 == null) return l2;
		if( l2 == null) return l1;
		
//		ListNode ans = l1.val < l2.val ? new ListNode(l1.val) : new ListNode(l2.val);
		
//		ListNode ans = new ListNode(0);
		
		ListNode head = new ListNode(0);
		
		ListNode ans = head;
		
		while (l1 != null && l2 != null) {

			if (l1.val < l2.val) {
				head.next = l1;
				l1 = l1.next;
			} else {
				head.next = l2;
				l2 = l2.next;
			}
			head = head.next;
		}
		
		// for any unleft
		if(l1 == null) head.next = l2;
		if(l2 == null) head.next = l1;
		
		return ans.next;

	}

}

//  Definition for singly-linked list.
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
};
