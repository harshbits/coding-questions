package google.leetcode_2020;

public class PrintLinkedListReverse {

    public static void main(String[] args) {


//        new PrintLinkedListReverse().printLinkedListInReverse();
    }


    // o(n)
    //
    public void printLinkedListInReverse(ImmutableListNode head) {

        if(head == null){
            return;
        }
        printLinkedListInReverse(head.getNext());
        head.printValue();
    }

    interface ImmutableListNode {
        public void printValue(); // print the value of this node.

        public ImmutableListNode getNext(); // return the next node.
    }

    ;
}
