package amazon;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * Example
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) 
 * Output: 7 -> 0 -> 8 
 * Explanation: 342 + 465 = 807.
 * 
 * @author hbhavsar
 *
 */
public class Add2Numbers {
	
	
	public static void main(String[] args) {

		new Add2Numbers().helper();
	}

	public void helper() {
		ListNode l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);

		ListNode ans = addTwoNumbers(l1, l2);
		System.out.println(ans);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

//		ListNode lt1 = l1;
//		ListNode lt2 = l2;
		ListNode current = new ListNode(0);
		ListNode answer = current;
		int carry = 0;
//		while (lt1 != null && lt2 != null) {
//			int val1 = lt1 != null ? lt1.val : 0;
//			int val2 = lt2 != null ? lt2.val : 0;
//			if (answer == null) {
//				answer = new ListNode(val1 + val2);
//				current = answer;
//			}else {
//				current.next = new ListNode(val1 + val2);
//				current = current.next;
//			}
//			lt1 = lt1.next;
//			lt2 = lt2.next;
//		}
		
		while (l1 != null || l2 != null || carry != 0) {
			if (l1 != null) {
				carry += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				carry += l2.val;
				l2 = l2.next;
			}
			current.next = new ListNode(carry % 10);
			carry /= 10;
			current = current.next;
		}
		
		return answer.next;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}

		@Override
		public String toString() {
			return "ListNode [val=" + val + ", next=" + next + "]";
		}
		
	}
}
