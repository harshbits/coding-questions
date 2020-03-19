package google.leetcode_2020.backtracking;

import java.util.ArrayList;
import java.util.List;

public class WordUsingADice {

    public static void main(String[] args) {
        char[][] arrays = {
                {'a', 'l', 'c', 'd', 'e', 'f'},
                {'a', 'b', 'c', 'd', 'e', 'f'},
                {'a', 'b', 'c', 'h', 'e', 'f'},
                {'a', 'b', 'c', 'd', 'o', 'f'},
                {'a', 'b', 'c', 'l', 'e', 'f'},};
        char[] pat = {'h', 'e', 'l', 'l', 'o'};

        List<Path> results = new ArrayList<Path>();
        List<Integer> visited = new ArrayList<>();
        System.out.println(find(arrays, pat, results, 0, visited));
    }

    // backtracking

    // O(mnk)
    // m = row
    // n = column
    // k = length of pattern

    // O(mnk)
    public static boolean find(char[][] arrays, char[] pat, List<Path> result,
                               int seqCount, List<Integer> visited) {

        if (seqCount == pat.length) {  //goal
            System.out.println(result);
            return true;
        }

        //choices
        for (int i = 0; i < arrays.length; i++) {

            char[] seq = arrays[i];
            for (int j = 0; j < seq.length; j++) {

                //constraints
                if (seq[j] == pat[seqCount] && !visited.contains(i)) {
                    result.add(new Path(i, j));
                    visited.add(i);
                    if (find(arrays, pat, result, seqCount + 1, visited)) {
                        return true;
                    }
                    // not find then
                    //back track
                    result.remove(result.size() - 1);
                    visited.remove(visited.size() - 1);
                }
            }
        }
        return false;
    }

    static class Path {
        int i;
        int j;

        public Path(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
