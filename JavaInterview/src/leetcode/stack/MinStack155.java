package leetcode.stack;

public class MinStack155 {

	public static void main(String[] args) {
		MinStack155 obj = new MinStack155();
		obj.push(1);
		obj.pop();
//		int param_3 = obj.top();
//		int param_4 = obj.getMin();
//		System.out.println(param_3);
//		System.out.println(param_4);
	}

//	private int min;
	
	private Node min;
	
	private Node head;
	
	/** initialize your data structure here. **/
	public MinStack155() {
//		this.min = Integer.MAX_VALUE;
	}

	public void push(int x) {
		if (head == null) {
			min = new Node(x);
			head = new Node(x);
		} else {
//			min = Math.min(x, min);
//			Node temp = head;
//			head = new Node(x);
//			head.next = temp;
			Node temp = new Node(x);
			temp.next = head;
			head = temp;
			if (x <= min.val) {
				Node tempMin = new Node(x);
				tempMin.next = min;
				min = tempMin;
			}
		}
	}

	public void pop() {
		if (head.val == min.val) {
			min = min.next;
		}
		head = head.next;
	}

	public int top() {
		return head.val;
	}

	public int getMin() {
		return min.val;
	}
	
	class Node {
		private int val;

		Node(int val) {
			this.val = val;
		}

		Node next;

		public int getValue() {
			return val;
		}
	}
}
