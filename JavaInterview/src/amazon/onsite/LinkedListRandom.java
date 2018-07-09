package amazon.onsite;

import java.util.Random;

/**
 * Given a singly linked list, return a random node's value from the linked list. 
 * Each node must have the same probability of being chosen.

Follow up:
What if the linked list is extremely large and its length is unknown to you? 
Could you solve this efficiently without using extra space?

Example:

// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();

 * 
 * 
 * @author hbhavsar
 *
 */
public class LinkedListRandom {

	ListNode head = null;
	Random r = new Random();
	
	public LinkedListRandom(ListNode head) {
		this.head = head;
	}
	
	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);

		LinkedListRandom l = new LinkedListRandom(head);

		int ans = l.getRandom();

		System.out.println(ans);

	}

	/** Returns a random node's value. */
	public int getRandom() {
		int result = this.head.val;
		ListNode node = this.head.next;
		int k =1;
        int i = 1;
        
        // O (n)
		while (node != null) {
			double x = r.nextDouble();
			// Reservoir Sampling
			double y = k / (k + i * 1.0);
			if (x <= y) {
				result = node.val;
			}
			i++;
			node = node.next;
		}
		return result;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
