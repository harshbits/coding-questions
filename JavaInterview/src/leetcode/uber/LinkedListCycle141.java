package leetcode.uber;


/**
 * 
 * Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 * @author habhavsar
 *
 */
public class LinkedListCycle141 {

	public static void main(String[] args) {

	}

	/**
	 * 
	 * 
	 *  1 -> 2 -> 3 -> 4 -> 5 -> 1 
	 * 
	 * 	a)	slow = 1, fast = 2
	 * 	b)	slow = 2, fast = 4
	 * 	c)	slow = 3, fast = 1
	 * 	d)	slow = 4, fast = 3
	 * 	e)	slow = 5, fast = 5
	 * 	
	 * 
	 * @param head
	 * @return
	 */
	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null) {
			return false;
		}

		ListNode slow = head;
		ListNode fast = head.next;

		while (slow != fast) {
			if (fast == null || fast.next == null) {
				return false;
			}
			slow = slow.next;
			fast = fast.next.next;
		}

		return true;
	}

	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

}
