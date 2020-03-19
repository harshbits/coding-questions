package google.leetcode_2020.matrix;

import java.util.*;


/*Visualizations help us to solve problems easily. How do we visualize? It is not easy,
it comes by practice. Here is the closer problem in Leetcode https://leetcode.com/problems/design-tic-tac-toe/.
This Leetcode problem can also be solved in constant time.

        Now, let us look at the problem you posted. Here the return type is boolean.
        In most cases, where the return type is boolean, we don't have to construct the whole array, instead,
        some logic can be applied to check whether it satisfies or not.
        Constructing/checking the whole array takes time and most of the game solutions don't do that.

        Let's speak about the solution now. It returns true if the complete row is 1's or the complete col is 1's.
         Checking the row is an easy one but how do I check whether any of the cols is completely filled with 1's after inserting an element?
          It is challenging cos the position of the elements changes after every insert.
          Let us assume the first column is filled with 1's, in this case the distance between the 1's in 1st row and 2nd row is n,
          also the distance between the 1's in 2nd row and 3rd row is n.....goes on.
          Here the distance between the 1's doesn't change even after insert.
           So we can use the sequence number to see if there are 1's placed 'n' number of times with distance 'n' (I used Deque for that).
           Also, we have to remove the seq number from the queue once it gets out of the grid (this line ----->dq.pollLast();).

        Any Questions? let me know. Gud Luck!*/

public class PushingMatrixGame {


    public static void main(String[] args) {
        PushGame game1 = new PushGame(3);
        int[] stream1 = {1, 1, 1};
        for (int s : stream1) {
            System.out.println(game1.isAWin(s));
        }
//        System.out.println("\n------------------------------------");
//        PushGame game2 = new PushGame(3);
//        int[] stream2 = {1, 0, 0, 1, 0, 0, 1};
//        for (int s : stream2) {
//            System.out.println(game2.isAWin(s));
//        }
//        System.out.println("\n------------------------------------");
//
//        PushGame game3 = new PushGame(3);
//        int[] stream3 = {0, 0, 1, 1, 0, 1, 0, 0, 1};
//        for (int s : stream3) {
//            System.out.println(game3.isAWin(s));
//        }
//        System.out.println("\n------------------------------------");
    }

}

class PushGame {

    int n;
    int[][] grid;
    int row;
    int col;
    int total;
    List<Deque<Integer>> list = null;

    public PushGame(int n) {
        this.n = n;
        this.row = 0;
        this.col = 0;
        // total element in matrix
        this.total = n * n;
        // default value is 0.
        this.grid = new int[n][n];
        this.list = new ArrayList<>();
        // add deque for all rows
        for (int i = 0; i < n; i++) {
            this.list.add(new ArrayDeque<>());
        }
    }


    public boolean isAWin(int num) {
        move();
        boolean result = false;
        // always push from top left
        grid[0][0] = num;
        System.out.println(Arrays.deepToString(grid));
        if (num == 1) {
            Deque<Integer> dq = list.get(col % n);
            dq.push(col);
            if (++row == n) {
                result = true;
            } else if (dq.size() == n) {
                if (col - dq.peekLast() < total) {
                    result = true;
                }
            }

            while (dq.size() >= n) {
                dq.pollLast();
            }
        } else {
            row = 0;
        }
        col++;
        return result;
    }

    private void move() {
        int idx = total - 1;
        while (idx > 0) {
            grid[idx / n][idx % n] = grid[(idx - 1) / n][(idx - 1) % n];
            --idx;
        }
    }
}