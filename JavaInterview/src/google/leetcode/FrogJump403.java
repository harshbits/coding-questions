package google.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJump403 {

	public static void main(String[] args) {
		FrogJump403 f = new FrogJump403();
		int[] stones = { 0, 1, 3, 5, 6, 8, 12, 17 };
		boolean ans = f.canCross(stones);
		System.out.println(ans);

	}

	public boolean canCross(int[] stones) {

		if (stones == null || stones.length == 0) {
			return false;
		}
		int n = stones.length;
		if (n == 1 && stones[0] == 0) {
			return true;
		}
		if (stones[1] != 1) {
			return false;
		}
		if (n == 2) {
			return true;
		}
		Set<Integer> stonesSet = new HashSet<>();
		for (int i = 0; i < stones.length; i++) {
			// check whether frog can jump in realisitic distance
			if (i > 3 && stones[i] > 2 * stones[i - 1]) {
				return false;
			}
			stonesSet.add(stones[i]);
		}

		return canReach(stonesSet, stones[n - 1], 0, 0);
	}

	private boolean canReach(Set<Integer> stones, int last, int position, int jump) {

		if (position + jump + 1 == last || position + jump - 1 == last || position + jump == last) {
			return true;
		}

		if (stones.contains(position + jump + 1) && canReach(stones, last, position + jump + 1, jump + 1)) {
			return true;
		}

		if (stones.contains(position + jump) && canReach(stones, last, position + jump, jump)) {
			return true;
		}
		if (stones.contains(position + jump - 1) && canReach(stones, last, position + jump - 1, jump - 1)) {
			return true;
		}

		return false;
	}

	public boolean canCrossBruteForce(int[] stones) {

		if (stones == null || stones.length == 0) {
			return true;
		}

		Map<Integer, Set<Integer>> map = new HashMap<>(stones.length);
		for (int i = 0; i < stones.length; i++) {
			map.put(stones[i], new HashSet<>());
		}
		map.get(0).add(1);

		for (int i = 0; i < stones.length; i++) {

			int stone = stones[i];
			for (int step : map.get(stone)) {

				int reach = step + stone;
				if (reach == stones[stones.length - 1]) {
					return true;
				}

				Set<Integer> jumps = map.get(reach);
				if (jumps != null) {
					jumps.add(step);
					if (step - 1 > 0)
						jumps.add(step - 1);
					jumps.add(step + 1);
				}
			}
		}

		return false;
	}

}
