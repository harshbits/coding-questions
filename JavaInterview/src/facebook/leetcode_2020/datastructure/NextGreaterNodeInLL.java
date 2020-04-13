package facebook.leetcode_2020.datastructure;

import java.util.*;

public class NextGreaterNodeInLL {

    public static void main(String[] args) {
        new NextGreaterNodeInLL().test();
    }

    private void test() {
        // 1,7,5,1,9,2,5,1
        ListNode head = new ListNode(1);
        head.next = new ListNode(7);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = new ListNode(1);

        int[] ans = nextLargerNodes(head);
        System.out.println(Arrays.toString(ans));

        int[] ans1 = nextLargerNodes1(head);
        System.out.println(Arrays.toString(ans1));
    }

    // O(n) time
    // faster than inbuilt stack
    // O(n) space
    public int[] nextLargerNodes(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> nodes = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            nodes.add(current.val);
            current = current.next;
        }
        int[] ans = new int[nodes.size()];

        int[] stack = new int[nodes.size()];
        int top = -1;

        for (int i = 0; i < nodes.size(); i++) {
            while (top > -1 && nodes.get(i) > nodes.get(stack[top])) {
                ans[stack[top--]] = nodes.get(i);
            }
            stack[++top] = i;
        }
        return ans;
    }




    public int[] nextLargerNodes1(ListNode head) {
        if (head == null) {
            return null;
        }

        List<Integer> nodes = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            nodes.add(current.val);
            current = current.next;
        }
        int[] ans = new int[nodes.size()];

        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nodes.size(); i++) {
            while (!stack.isEmpty() && nodes.get(i) > nodes.get(stack.peek())) {
//                System.out.println(stack);
                ans[stack.pop()] = nodes.get(i);
            }
            stack.push(i);
        }
        return ans;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
