package facebook.leetcode_2020.greedy;

import java.util.*;

public class CampusBikes {

    public static void main(String[] args) {

        int[][] workers = {{0, 0}, {1, 1}, {2, 0}}, bikes = {{1, 0}, {2, 2}, {2, 1}};

        // bucket sort
        int[] ans = new CampusBikes().assignBikes(workers, bikes);
        System.out.println(Arrays.toString(ans));

        // heap
        int[] ans1 = new CampusBikes().assignBikes1(workers, bikes);
        System.out.println(Arrays.toString(ans1));
    }


    // Time: O(m*n)
    public int[] assignBikes(int[][] workers, int[][] bikes) {

        int m = workers.length;
        int n = bikes.length;

        // answer
        int[] assignedBikes = new int[m];
        // assigned bikes
        boolean[] assigned = new boolean[m];
        // Occupied bikes
        boolean[] occupied = new boolean[n];

        // Step 1. Prepare Buckets
        // Maximum possilbe distance:
        // 0 <= workers[i][j], bikes[i][j] < 1000.
        // Manhattan distance between any worker and bike is between 0 and 2000.
        // Point (0, 1000) and (1000, 0)
        List<DistanceNode>[] buckets = new ArrayList[2001];
        // Time: O(m * n)
        for (int i = 0; i < m; i++) {
            int[] worker = workers[i];
            for (int j = 0; j < n; j++) {
                int[] bike = bikes[j];
                // manhattan distance
                int dist = Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
                if (buckets[dist] == null) {
                    buckets[dist] = new ArrayList<>();
                }
                buckets[dist].add(new DistanceNode(dist, i, j));
            }
        }

        // assign bikes from buckets.
        for (int i = 0; i < 2001; i++) {
            if (buckets[i] == null) {
                continue;
            }
            int size = buckets[i].size();
            for (int j = 0; j < size; j++) {

                int worker = buckets[i].get(j).worker;
                int bike = buckets[i].get(j).bike;

                if (!assigned[worker] && !occupied[bike]) {
                    assignedBikes[worker] = bike;
                    assigned[worker] = true;
                    occupied[bike] = true;
                }
            }
        }
        return assignedBikes;
    }

    // Priority Queue / Sort
    // Time: O(m*n) log (m*n)) + O(m); m = workers, n = bikes
    // Space:  O(m*n) + o(m)
    public int[] assignBikes1(int[][] workers, int[][] bikes) {

        int[] assignedBikes = new int[workers.length];
        // by default unvisited
        Arrays.fill(assignedBikes, -1);

        // Order by distance asc, worker index asc, bike index asc.
        // asc = ascending
        PriorityQueue<DistanceNode> heap = new PriorityQueue<>();

        // loop through every possible pairs of bikes and people,
        // calculate their distance, and then throw it to the heap.
        // Time: O(m*n) log (m*n))
        for (int i = 0; i < workers.length; i++) {
            int[] worker = workers[i];
            for (int j = 0; j < bikes.length; j++) {
                int[] bike = bikes[j];
                int manhattanDistance = Math.abs(bike[0] - worker[0]) + Math.abs(bike[1] - worker[1]);
                heap.add(new DistanceNode(manhattanDistance, i, j));
            }
        }

        // Time: O(m)
        Set<Integer> bikeAssigned = new HashSet<>();
        while (bikeAssigned.size() < workers.length) {
            DistanceNode node = heap.poll();
            // if not visited
            if (assignedBikes[node.worker] == -1
                    && !bikeAssigned.contains(node.bike)) {
                assignedBikes[node.worker] = node.bike;
                bikeAssigned.add(node.bike);
            }
        }

        return assignedBikes;
    }

    private class DistanceNode implements Comparable<DistanceNode> {
        // manhattan distance
        int dist;
        // worker index
        int worker;
        // bike index
        int bike;

        public DistanceNode(int dist, int worker, int bike) {
            this.dist = dist;
            this.worker = worker;
            this.bike = bike;
        }

        // 1. By distance
        // 2. if same distance then by worker index
        // 3. if same worker index then by bike
        @Override
        public int compareTo(DistanceNode that) {
            if (this.dist != that.dist) {
                return this.dist - that.dist;
            }
            return this.worker == that.worker ? this.bike - that.bike : this.worker - that.worker;
        }
    }
}
