package facebook.leetcode_2020.slidingwindow;

public class TrapRainWater {

    public static void main(String[] args) {

        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int ans = new TrapRainWater().trap(height);
        System.out.println(ans);
    }


    // O(N) Time
    // O(1) Space
    public int trap(int[] height) {
        int water = 0;
        if (height.length < 3) {
            return water;
        }

        int start = 0;
        int end = height.length - 1;

        while (start < end) {
            if (height[start] <= height[end]) {
                int edge = height[start];
                start++;
                while (start < end && height[start] < edge) {
                    water += edge - height[start];
                    start++;
                }

            } else {
                int edge = height[end];
                end--;
                while (start < end && height[end] < edge) {
                    water += edge - height[end];
                    end--;
                }
            }
        }
        return water;
    }
}
