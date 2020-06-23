package facebook.leetcode_2020.datastructure;

import java.util.Stack;

public class PrintLinkedListReverse {

    public static void main(String[] args) {
        ImmutableNode list = new ImmutableNode(1);
        list.next = new ImmutableNode(2);
        list.next.next = new ImmutableNode(3);
        list.next.next.next = new ImmutableNode(4);
        list.next.next.next.next = new ImmutableNode(5);
        list.next.next.next.next.next = new ImmutableNode(6);
        list.next.next.next.next.next.next = new ImmutableNode(7);
        list.next.next.next.next.next.next.next = new ImmutableNode(8);
        list.next.next.next.next.next.next.next.next = new ImmutableNode(9);

        PrintLinkedListReverse p = new PrintLinkedListReverse();
        p.printLinkedListInReverse(list);
    }

    public void printLinkedListInReverse(ImmutableListNode head) {
        if (head == null) {
            return;
        }

        ImmutableListNode temp = head;
        int n = 0;
        while (temp != null) {
            temp = temp.getNext();
            n++;
        }

        final int groupSize = (int) Math.sqrt(n) + 1;
        Stack<ImmutableListNode> groupHeads = new Stack<>();
        temp = head;

        for (int i = 0; i < groupSize; i++) {
            if (i % groupSize == 0) {
                groupHeads.push(temp);
            }
            temp = temp.getNext();
        }

        Stack<ImmutableListNode> workingStack = new Stack<>();
        ImmutableListNode start = null;
        ImmutableListNode end = null;

        while (!groupHeads.isEmpty()) {
            end = start;
            start = groupHeads.pop();
            temp = start;

            while (temp != end) {
                workingStack.push(temp);
                temp = temp.getNext();
            }

            while (!workingStack.isEmpty()) {
                workingStack.pop().printValue();
            }
        }
    }
}

class ImmutableNode implements ImmutableListNode {

    int value;

    ImmutableNode next;

    public ImmutableNode(int value) {
        this.value = value;
    }

    @Override
    public void printValue() {
        if (next == null) {
            System.out.print(value);
        } else {
            System.out.print(" -> " + value);
        }
    }

    @Override
    public ImmutableListNode getNext() {
        return next;
    }
}

interface ImmutableListNode {
    public void printValue(); // print the value of this node.
    public ImmutableListNode getNext(); // return the next node.
}