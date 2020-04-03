package microsoft.leetcode_2020.online;

import java.util.Arrays;
import java.util.Random;

public class CounterExample {
    public static void main(String[] args) {
        int N = 10;
        int[] A = new CounterExample().solution(N);
        System.out.println(Arrays.toString(A));

        int min = new CounterExample().find_min(A);
        System.out.println(min);
    }

    public int[] solution(int N) {
        if (N == 0) {
            return new int[0];
        }
        // random number generator
        Random rd = new Random();

        int[] array = new int[N];
        // keeping first element as 0
        // since the find_min starts checking from 1st index element.
        // it could be as well array[0] = 0; if we have all positives.

        array[0] = Integer.MIN_VALUE;

        for (int i = 1; i < N; i++) {
            array[i] = getRandomNumber(rd);
        }
        return array;
    }

    private int getRandomNumber(Random rd) {
        int random = rd.nextInt();

        // if not max then return + 1,
        // to avoid Integer.MIN_VALUE.
        if (random != Integer.MAX_VALUE) {
            return random + 1;
        }
        // if value is max then return
        return random;
    }

    private int find_min(int[] A) {
        int ans = 0;

        for (int i = 1; i < A.length; i++) {
            if (ans > A[i]) {
                ans = A[i];
            }
        }
        return ans;
    }
}
