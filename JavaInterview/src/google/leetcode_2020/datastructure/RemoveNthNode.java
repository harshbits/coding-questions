package google.leetcode_2020.datastructure;

public class RemoveNthNode {

    public static void main(String[] args) {

        new RemoveNthNode().test();

    }

    void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(head);
        ListNode ans = removeNthFromEnd(head, 2);
        System.out.println(ans);
    }

    // 1 -> 2 -> 3 -> 4 -> 5
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // slow
        ListNode p1 = dummy;
        // fast
        ListNode p2 = dummy;

        // n = 2
        // p2 = 1
        // n = 1
        // p2 = 2
        // n = 0
        // p2 = 3
        // n = -1
        // break
        while (n-- >= 0) {
//            System.out.println(p2.val);
            p2 = p2.next;
        }

        // move both till end
        while (p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        // remove the element
        p1.next = p1.next.next;
        return dummy.next;
    }

    //Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val);
            ListNode some = next;
            while (some != null) {
                sb.append("->").append(some.val);
                some = some.next;
            }
            return sb.toString();
        }
    }

}

