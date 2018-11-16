package leetcode.greedy;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation874 {

	public static void main(String[] args) {
		int[] commands = { 4, -1, 4, -2, 4 };
		int[][] obstacles = { { 2, 4 } };
		
		var ans = new WalkingRobotSimulation874().robotSim(commands, obstacles);
		System.out.println(ans);
	}

	private static int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public int robotSim(int[] commands, int[][] obstacles) {

//		int north = 0, east = 1, south = 2, west = 3;
		// 1 = North, -1 = South, -2 = West, 2 = East

		// By default it is North
//		int direction = north;
		int direction = 0;

		// x and y axis, starting position is 0, 0
		int[] position = new int[] { 0, 0 };

		// convert 2D array to obstacles
		Set<Long> obstablesSet = getObstaclesSet(obstacles);

		int maxDistance = 0;

		for (int c : commands) {
			if (c < 0) {
				direction = determineDirection(c, direction);
			} else {
				for (int i = 1; i <= c; i++) {

					// X
					int newX = position[0] + directions[direction][0];

					// Y
					int newY = position[1] + directions[direction][1];

//					System.out.println(newX + ", " + newY);
					long hash = generateHash(newX, newY);
					if (!obstablesSet.contains(hash)) {
						position[0] = newX;
						position[1] = newY;

						maxDistance = Math.max(maxDistance, (position[0] * position[0] + position[1] * position[1]));
					}
				}
			}
		}

		return maxDistance;
	}

	private int determineDirection(int value, int currentDirection) {

		if (value == -2) {
			// 3/4 will 270 degree, as we have to go by 270
			// -90 degree === 270 degree
			return (currentDirection + 3) % 4;
		}

		// go to right => +90 degree
		return (currentDirection + 1) % 4;

	}

	private Set<Long> getObstaclesSet(int[][] obstacles) {

		Set<Long> set = new HashSet<>();
		for (int[] o : obstacles) {

			// generate hash code for combination
			long hash = generateHash(o[0], o[1]);
			set.add(hash);
		}
		return set;
	}

	private Long generateHash(int x, int y) {
		long ox = (long) x + 30000;
		long oy = (long) y + 30000;

		// ox * (2^16) + oy
		long hash = (ox << 16) + oy;
		return hash;
	}

}
