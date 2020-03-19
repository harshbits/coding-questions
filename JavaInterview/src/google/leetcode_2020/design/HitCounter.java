package google.leetcode_2020.design;

import java.util.ArrayList;
import java.util.List;

public class HitCounter {

//    // space O(300) + O(300) = constant = O(1)
//    private int[] times;
//    private int[] hits;
//
//    /**
//     * Initialize your data structure here.
//     */
//    public HitCounter() {
//        // past 300 seconds
//        // each index represents the second of past 300 seconds
//        this.times = new int[300];
//        this.hits = new int[300];
//    }
//
//    /**
//     * Record a hit.
//     *
//     * @param timestamp - The current timestamp (in seconds granularity).
//     */
//    public void hit(int timestamp) {
//        int second = timestamp % 300;
//        // if it's not as before
//        // which means we passed past 5 minutes mark
//        if (times[second] != timestamp) {
//            // since it's repeating
//            times[second] = timestamp;
//            // reset to 1
//            hits[second] = 1;
//        } else {
//            hits[second]++;
//        }
//    }
//
//
//    /**
//     * Return the number of hits in the past 5 minutes.
//     *
//     * @param timestamp - The current timestamp (in seconds granularity).
//     */
//    public int getHits(int timestamp) {
//        int total = 0;
//        for (int i = 0; i < 300; i++) {
//            if (timestamp - times[i] < 300) {
//                total += hits[i];
//            }
//        }
//        return total;
//    }


    List<Integer> hits;

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {
        hits = new ArrayList<>();
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        hits.add(timestamp);
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        int hitCount = 0;
        int min = timestamp - 300;
        for (int i = hits.size() - 1; i >= 0; --i) {
            if (hits.get(i) > min) {
                hitCount++;
            } else {
                // we can add delete logic
                // also we can add async logic
                // range of all below that
                // hits.removeAll();
                break;
            }
        }

        return hitCount;
    }

    public static void main(String[] args) {
        HitCounter counter = new HitCounter();
// hit at timestamp 1.
        counter.hit(1);

// hit at timestamp 2.
        counter.hit(2);

// hit at timestamp 3.
        counter.hit(3);

// get hits at timestamp 4, should return 3.
        int hits = counter.getHits(4);
        System.out.println(hits);

// hit at timestamp 300.
        counter.hit(300);

// get hits at timestamp 300, should return 4.
        hits = counter.getHits(300);
        System.out.println(hits);

// get hits at timestamp 301, should return 3.
        hits = counter.getHits(301);
        System.out.println(hits);
    }

}
