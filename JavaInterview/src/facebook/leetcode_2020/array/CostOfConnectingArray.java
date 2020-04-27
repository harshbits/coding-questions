package facebook.leetcode_2020.array;

import java.util.Collections;
import java.util.PriorityQueue;

public class CostOfConnectingArray {

    public static void main(String[] args) {
        int[] A = {4, 2, 1, 3};
        int ans = new CostOfConnectingArray().connectSticks(A);
        System.out.println(ans);

        ans = new CostOfConnectingArray().connectSticks2(A);
        System.out.println(ans);
    }


    // get maximum of adjacent arrays
    // Time: O(N)
    // Space: O(1)
    public int connectSticks(int[] A) {

        int cost = 0;
        if (A == null || A.length == 0) {
            return cost;
        }

        int n = A.length;
        int x = -1;
        int y = -1;

        // Step 1. Find Maximum adjancent pair
        // Time: O(N)
        for (int i = 1; i < n; i++) {
            if (x == -1 || A[i - 1] + A[i] > A[x] + A[y]) {
                x = i - 1;
                y = i;
            }
        }

        int currCost = A[x] + A[y];
        cost = currCost;
        x--;
        y++;

        // Step 2. Look from both side
        // Time: O(N)
        while (x >= 0 || y < n) {
            int xx = x < 0 ? Integer.MIN_VALUE : A[x];
            int yy = y >= n ? Integer.MIN_VALUE : A[y];

            if (xx > yy) {
                currCost += xx;
                x--;
            } else {
                currCost += yy;
                y++;
            }
            cost += currCost;
        }
        return cost;
    }

    // Get minimum of any 2 numbers
    public int connectSticks2(int[] sticks) {
        // for maximum, just reverse the PQ
        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : sticks) {
            pq.offer(s);
        }
        int sum = 0;
        while (pq.size() > 1) {
            int two = pq.poll() + pq.poll();
            sum += two;
            pq.offer(two);
        }
        return sum;
    }
}
