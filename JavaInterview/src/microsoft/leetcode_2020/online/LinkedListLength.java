package microsoft.leetcode_2020.online;

public class LinkedListLength {


    public static void main(String[] args) {

        IntList L = new IntList(1);
//        L.next = new IntList(2);

        int ans = solution(null);
        System.out.println(ans);

    }

    public static int solution(IntList L) {
        // write your code in Java SE 8

        // basic checks
        // Though it mentioned in question that linked list is always non-empty
        if (L == null) {
            return 0;
        }

        int linkedListLength = 0;
        while (L != null) {
            L = L.next;
            linkedListLength++;
        }

        return linkedListLength;
    }

    static class IntList {
        public int value;
        public IntList next;

        public IntList(int value) {
            this.value = value;
        }
    }
}
