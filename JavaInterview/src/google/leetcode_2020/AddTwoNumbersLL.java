package google.leetcode_2020;

public class AddTwoNumbersLL {

    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode current = new ListNode(0);
        int carry = 0;
        ListNode answer = current;

        while (l1 != null || l2 != null || carry != 0) {
//            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            int sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            current.next = new ListNode(sum % 10);
            carry = sum / 10;
//            l1 = l1.next;
//            l2 = l2.next;
            current = current.next;
        }
        return answer.next;
    }


    //Definition for singly-linked list.
    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}




