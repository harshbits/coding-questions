package facebook.leetcode_2020.datastructure;

public class RemoveNthNodeLL {


    // Time: O(N)
    // Space: O(2)  = O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // slow
        ListNode p1 = dummy;
        // fast
        ListNode p2 = dummy;

        while (n-- >= 0) {
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

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
