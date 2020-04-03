package facebook.leetcode_2020.divideconquer;

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        // idea:
        // let;s say we have l0, l1, l2, l3, l4, l5
        // l0 = l0 + l1 ; l2 = l2 + l3; l4 = l4 + l5
        // l0 = l0 + l2; l4
        // l0 = l0 + l4

        int interval = 1;
        while (interval < lists.length) {
            // merge sort idea
            for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
                lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
            }
            interval *= 2;
        }
        return lists[0];
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
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
        // for any left
        if (l1 == null) head.next = l2;
        if (l2 == null) head.next = l1;
        return ans.next;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
