
public class DeleteNodeInSinglyLinkedList {

	public static void main(String[] args) {
		new DeleteNodeInSinglyLinkedList().helper();
	}

	public void helper() {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		
		System.out.println(node);
		
		deleteNode(node.next);
		
		System.out.println(node);
	}
	
	
	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
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
