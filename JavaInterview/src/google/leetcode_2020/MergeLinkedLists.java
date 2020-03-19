package google.leetcode_2020;


public class MergeLinkedLists {
    public static void main(String[] args) {
        new MergeLinkedLists().test();
    }

    public void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(4);
        l2.next.next = new ListNode(5);

        ListNode ans = mergeTwoLists(l1, l2);
        System.out.println(ans);
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
//                head = head.next;
//            } else if (l1.val == l2.val) {
//                head.next = l1;
//                head.next.next = l2;
//                l1 = l1.next;
//                l2 = l2.next;
//                head = head.next.next;
            } else {
                head.next = l2;
                l2 = l2.next;
//                head = head.next;
            }
            head = head.next;
        }
        // for any unleft
        if(l1 == null) head.next = l2;
        if(l2 == null) head.next = l1;

        return ans.next;
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
