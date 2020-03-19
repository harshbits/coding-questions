package google.leetcode_2020;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class ReachUsingRopesAndBricks {

    public static void main(String[] args) {

//        int[] building = {4, 2, 7, 6, 9, 11, 14, 12, 8};
//        int bricks = 5;
//        int ropes = 2;
//        int ans = new ReachUsingRopesAndBricks().howFarWeCanReach(building, bricks, ropes);
//        System.out.println(ans);

        int[] building = {4, 2, 7, 6, 9, 11, 14, 12, 8};
        int bricks = 5;
        int ropes = 1;
        int ans = new ReachUsingRopesAndBricks().findFarthestDistance(building, bricks, ropes);
        System.out.println(ans);
    }


    public int findFarthestDistance(int[] arr, int bricks, int ropes) {
        int maxDistance = dfs(arr, bricks, ropes, 0);
        return Math.min(arr.length, maxDistance);
    }

    private int dfs(int[] arr, int b, int r, int index) {
//        System.out.println("buildings,  " + b + ",  " + r + ",  " + index);
        if (index == arr.length - 1) {
            return index;
        }
        if (b == 0 && r == 0) {
            return arr[index] >= arr[index + 1] ? dfs(arr, b, r, index + 1) : index;
        }
        if (r < 0) {
            return index - 1;
        }
        if (arr[index] >= arr[index + 1]) {
            return dfs(arr, b, r, index + 1);
        }
        int height = arr[index + 1] - arr[index];
        if (height > b) {
            return dfs(arr, b, r - 1, index + 1);
        }
        return Math.max(dfs(arr, b - height, r, index + 1), dfs(arr, b, r - 1, index + 1));
    }


    // Using DFS
    public int howFarWeCanReach(int[] buildings, int bricks, int ropes) {
        int maxDistance = dfsHelper(buildings, bricks, ropes, 0);
        // whichever is minimum
        return Math.min(buildings.length, maxDistance);
    }

    private int dfsHelper(int[] buildings, int bricks, int ropes, int index) {
//        System.out.println("buildings,  " + bricks + ",  " + ropes + ",  " + index);
        // 1. Termination conditions
        // last index
        if (index == buildings.length - 1) {
            return index;
        }
        // no longer bricks and ropes available
        // If next building is smaller then current else return current index.
        if (bricks == 0 && ropes == 0) {
            return buildings[index] >= buildings[index + 1]
                    ? dfsHelper(buildings, bricks, ropes, index + 1)
                    : index;
        }
        // if rope is no longer available
        if (ropes < 0) {
            return index - 1;
        }
        // If next building is smaller then go to next one
        if (buildings[index] >= buildings[index + 1]) {
            dfsHelper(buildings, bricks, ropes, index + 1);
        }

        // 2. Logic
        // height difference between next and current building
        int difference = buildings[index + 1] - buildings[index];
        // if not enough bricks then try to use rope
        if (difference > bricks) {
            dfsHelper(buildings, bricks, ropes - 1, index + 1);
        }

        // Max based on bricks or ropes
        return Math.max(dfs(buildings, bricks - difference, ropes, index + 1),
                dfs(buildings, bricks, ropes - 1, index + 1));
    }


    // Using Greedy
    // Max Heap
    // Time = O ( N + N ) = O(N)
    // Space = O (ropes  + 1 + 1 ) = O(ropes)
    public int howFarWeCanReach1(int[] buildings, int bricks, int ropes) {

        // O(ropes) space
        TreeSet<Integer> set = new TreeSet<>(Collections.reverseOrder());
        int temp = buildings[0];
        buildings[0] = 0;

        // O(N) time; N = num of buildings
        for (int i = 1; i < buildings.length; i++) {
            if (buildings[i] > temp) {
                int diff = buildings[i] - temp;
                temp = buildings[i];
                buildings[i] = diff;
                int poll = Integer.MIN_VALUE;
                if (set.size() == ropes) {
                    poll = set.pollLast();
                }
                set.add(Math.max(poll, diff));
            } else {
                temp = buildings[i];
                buildings[i] = 0;
            }
        }

//        System.out.println(Arrays.toString(buildings));x
//        System.out.println(set);

        // O(N) time; N = num of buildings
        int ans = 1;
        for (int i = 1; i < buildings.length; i++) {

            if (buildings[i] > 0) {
                if (set.contains(buildings[i]) && ropes != 0) {
                    ropes--;
                } else {
                    if (bricks - buildings[i] >= 0) {
                        bricks -= buildings[i];
//                        if (bricks == 0) {
//                            break;
//                        }
                    } else {
                        if (ropes == 0) {
                            break;
                        }
                    }
                }
            } else if (buildings[i] == 0) {
                ans++;
                continue;
            }

            if (ropes == 0 && bricks == 0) {
                break;
            }
            ans++;
        }

        return ans;
    }
}
