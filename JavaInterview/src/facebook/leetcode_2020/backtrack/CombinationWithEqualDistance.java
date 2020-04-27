package facebook.leetcode_2020.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationWithEqualDistance {

    public static void main(String[] args) {
        CombinationWithEqualDistance c = new CombinationWithEqualDistance();
        var ans = c.allCombinations(3);
        for (int[] x : ans) {
            System.out.println(Arrays.toString(x));
        }
    }

    //Time: O(N!)
    public List<int[]> allCombinations(int n) {

        // all its elements initialized by -1
        int[] elements = new int[2 * n];
        Arrays.fill(elements, -1);

        // start from element 1
        List<int[]> combinations = new ArrayList<>();
        backtrack(combinations, elements, 1, n);
        return combinations;
    }

    private void backtrack(List<int[]> combinations, int[] elements, int element, int n) {
        // if all elements are filled
        if (element > n) {
            // copy, not reference
            combinations.add(Arrays.copyOf(elements, elements.length));
            return;
        }

        // Try all possible combinations for element
        for (int i = 0; i < 2 * n; i++) {
            //if position and distanced position is not occupied
            if (elements[i] == -1 && (i + element + 1) < 2 * n && elements[i + element + 1] == -1) {
                elements[i] = element;
                elements[i + element + 1] = element;

                // recurse for next element
                backtrack(combinations, elements, element + 1, n);

                // backtrack
                elements[i] = -1;
                elements[i + element + 1] = -1;
            }
        }
    }
}
