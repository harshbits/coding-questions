package facebook.leetcode_2020.dfs;

import java.util.*;

public class MinumumRefuelStops {

    public static void main(String[] args) {

        int K = 10;
        int D = 17;
        int B = 3;
        List<GasStation> gasStations = new ArrayList<>();
        gasStations.add(new GasStation(4, 10));
        gasStations.add(new GasStation(2, 40));
        gasStations.add(new GasStation(9, 15));
        gasStations.add(new GasStation(5, 7));
        gasStations.add(new GasStation(10, 12));

        System.out.println(minRefuelStops(K, D, B, gasStations));
    }

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        if (startFuel >= target) {
            return 0;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        int fuelStops = 0;
        int curFarthest = startFuel;

        for (int[] station : stations) {
            // take the gas from the maximum gas station
            if (curFarthest >= target) {
                return fuelStops;
            }

            while (curFarthest < station[0]) {
                // no lstation to get the fue
                if (maxHeap.isEmpty()) {
                    return -1;
                }
                curFarthest += maxHeap.poll();
                fuelStops++;
            }
            maxHeap.offer(station[1]);
        }

        while (curFarthest < target) {
            if (maxHeap.isEmpty()) {
                return -1;
            }
            curFarthest += maxHeap.poll();
            fuelStops++;
        }

        return fuelStops;
    }

    // K = car tank volume
    // D = destination D km away
    // N gas stations
    // distance[] = d[i] = distance from origin for the gas station
    // price[] = p[i] = fuel cost at each ith gas station
    public static int minRefuelStops(int K, int D, int B, List<GasStation> gasStations) {

        int fuelStops = 0;
        int fuel = K;
        int position = 0;

        Deque<Integer> deque = new LinkedList<>();
        // Dummy Station
        gasStations.add(new GasStation(3, 0));

        for (int i = 0; i < gasStations.size(); i++) {
            GasStation g = gasStations.get(i);
            int dist = g.distance;
            int price = g.price;

            while (!deque.isEmpty() && gasStations.get(deque.peekFirst()).distance < dist - K) {
                deque.pollFirst();
            }

            fuel -= dist - position;
            position = dist;

            if (fuel < 0 && deque.isEmpty()) {
                return -1; // no available station
            }

            int pr = fuel < 0 ? gasStations.get(deque.peekFirst()).price : 0;
            while (!deque.isEmpty() && gasStations.get(deque.peekLast()).price >= price) {
                deque.pollLast();
            }

            if (fuel >= 0) {
                continue;
            }

            fuelStops += pr * (-fuel);
            fuel = 0;
        }
        gasStations.remove(gasStations.size() - 1);
        return fuelStops;
    }

    static class GasStation {
        int distance;
        int price;

        public GasStation(int distance, int price) {
            this.distance = distance;
            this.price = price;
        }
    }
}