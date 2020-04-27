package facebook.leetcode_2020.array;

import java.util.HashMap;
import java.util.Map;

public class ReverseToMakeEqual {

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4};
        int[] B = {1, 4, 3, 2};

        boolean ans = new ReverseToMakeEqual().areEqual(A, B);
        System.out.println(ans);
    }


    public boolean areEqual(int[] A, int[] B) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for (int b : B) {
            map.put(b, map.getOrDefault(b, 0) - 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0) {
                return false;
            }
        }

        return true;
    }
}
