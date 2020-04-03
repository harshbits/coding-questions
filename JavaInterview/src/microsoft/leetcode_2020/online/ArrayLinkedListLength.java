package microsoft.leetcode_2020.online;

public class ArrayLinkedListLength {

    public static void main(String[] args) {
//        int[] A = {1, 4, -1, 3, 2};
        int[] A = {0};
        int ans = solution(A);
        System.out.println(ans);
    }

    //
    public static int solution(int[] A) {
        // write your code in Java SE 8

        if (A == null || A.length == 0) {
            return 0;
        }

        // answer
        // Initialize with 1, since A has atleast of size 1.
        // even if A[0] consits = -1 then we are at the end of the list,
        // means there are no more node after this.
        int linkedListLength = 1;

        // first node is always located at A[0]
        int head = 0;

        // We need to check until we reach -1.
        // -1 represents last node of the list/
        while (head < A.length && A[head] != -1) {
            // next index
            head = A[head];

            // This can only be possible if the A does not contain -1.
            // we can also throw an error here
            if (linkedListLength >= A.length) {
                // throw new IllegalArgumentException("Invalid Input. There is no end of Linked List");
                break;
            }
            linkedListLength++;
        }

        return linkedListLength;
    }


}
