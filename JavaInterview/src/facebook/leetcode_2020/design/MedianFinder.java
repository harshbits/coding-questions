package facebook.leetcode_2020.design;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    public static void main(String[] args) {

        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        double med = obj.findMedian();
        System.out.println(med);
        med = obj.findMedianFollowUp1();
        System.out.println(med);
        med = obj.findMedianFollowUp2();
        System.out.println(med);

        obj.addNum(3);

        med = obj.findMedian();
        System.out.println(med);
        med = obj.findMedianFollowUp1();
        System.out.println(med);
        med = obj.findMedianFollowUp2();
        System.out.println(med);
    }

    // Original Question
    // Min heap = stores high values
    private PriorityQueue<Integer> high;
    // Max Heap = stored low values
    private PriorityQueue<Integer> low;


    // Follow Up 1:
    // If all integer numbers from the stream are between 0 and 100, how would you optimize it?
    // Array to keep count between 0-100
    private int[] nums;
    private int total;


    // Follow Up 2:
    // 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
    // Create 3 Arrays for 3 different groups
    // 1. num < 0
    private int[] ltZero;
    // 2. 99% of numbers 0 <= num <=100
    private int[] nums1;
    // 3. num > 100
    private int[] gtHundred;
    private int total1;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        this.high = new PriorityQueue<>();
        // WE COULD ALSO DO (a, b) -> b - a
        // this.low = new PriorityQueue<>((a, b) -> b - a);
        this.low = new PriorityQueue<>(Collections.reverseOrder());

        // Follow Up 1
        // Space = O(101) = O(1)
        this.nums = new int[101];
        this.total = 0;

        // Follow Up 2
        // Space = O(101 + 1 + 1) = O(1)
        this.ltZero = new int[1];
        this.nums1 = new int[101];
        this.gtHundred = new int[1];
        this.total1 = 0;
    }

    public void addNum(int num) {
        // Add to max heap
        low.add(num);
        // remove top from heap and add to min heap
        high.add(low.poll());

        // balancing
        // high should never have more element than low
        if (low.size() < high.size()) {
            low.add(high.poll());
        }

        // for Follow up 1:
        nums[num]++;
        total++;

        // for Follow up 2:
        if (num < 0) {
            ltZero[0]++;
        } else if (num > 100) {
            gtHundred[0]++;
        } else {
            nums1[num]++;
        }
        total1++;
    }

    public double findMedian() {

        if (low.size() > high.size()) {
            return low.peek();
        }
        return (double) (low.peek() + high.peek()) / 2;
    }


    // Time = O(101) = O(1) = constant
    public double findMedianFollowUp1() {

        int count = 0;
        int i = 0;
        // first half of the array
        while (count < total / 2) {
            count += nums[i++];
        }
        // second half
        int j = i;
        while (count < total / 2 + 1) {
            count += nums[j++];
        }

        // for odd total numbers
        if (total % 2 == 1) {
            //return  middle element
            return j - 1;
        } else {
            // for even
            // average of middle two
            // covert to double with 2.0
            return (i + j - 2) / 2.0;

        }
    }

    // Time = O(101) = O(1) = constant
    public double findMedianFollowUp2() {

        int count = ltZero[0];
        int i = 0;
        // first half of nums1
        while (count < total1 / 2) {
            count += nums1[i++];
        }

        count += gtHundred[0];
        int j = i;
        while (count < total1 / 2 + 1) {
            count += nums1[j++];
        }

        // for odd total numbers
        if (total1 % 2 == 1) {
            //return  middle element
            return j - 1;
        } else {
            // for even
            // average of middle two
            // covert to double with 2.0
            return (i + j - 2) / 2.0;
        }
    }
}
