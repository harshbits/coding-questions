package leetcode.twopointers;

public class TrappingRainWater42 {

	public static void main(String[] args) {

		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int ans = new TrappingRainWater42().trap(height);
		System.out.println(ans);

	}

	public int trap(int[] height) {
		int max = 0;
		if (height == null || height.length < 3) {
			return max;
		}

		int s = 0;
		int e = height.length - 1;

		while (s < e) {
			if (height[s] <= height[e]) {
				int edge = height[s];
				++s;

				while (s < e && height[s] < edge) {
					max += edge - height[s];
					++s;
				}

			} else {
				int edge = height[e];
				--e;
				while (s < e && height[e] < edge) {
					max += edge - height[e];
					--e;
				}
			}
		}

		return max;
	}
}
