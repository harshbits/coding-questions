package facebook.leetcode_2020.design;

import java.util.*;

public class RandomizedSetDuplicate {

    public static void main(String[] args) {
        new RandomizedSetDuplicate().test();
    }

    private void test() {
        // Init an empty collection.
        RandomizedCollection collection = new RandomizedCollection();
        // Inserts 1 to the collection. Returns true as the collection did not contain 1.
        System.out.println(collection.insert(1));
        // Inserts another 1 to the collection. Returns false as the collection contained 1. Collection now contains [1,1].
        System.out.println(collection.insert(1));
        // Inserts 2 to the collection, returns true. Collection now contains [1,1,2].
        System.out.println(collection.insert(2));
        // getRandom should return 1 with the probability 2/3, and returns 2 with the probability 1/3.
        System.out.println(collection.getRandom());
        // Removes 1 from the collection, returns true. Collection now contains [1,2].
        System.out.println(collection.remove(1));
        // getRandom should return 1 and 2 both equally likely.
        System.out.println(collection.getRandom());
    }

    // Time: O(N)
    // Space: O(N)
    public class RandomizedCollection {
        private List<Integer> nums;
        private Map<Integer, Set<Integer>> locs;
        private Random rand;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            nums = new ArrayList<>();
            locs = new HashMap<>();
            rand = new Random();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean contain = locs.containsKey(val);
            if (!contain) {
                //LinkedHashSet maintains the order of insertion
                locs.put(val, new LinkedHashSet<>());
            }
            locs.get(val).add(nums.size());
            nums.add(val);
            return !contain;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         * <p>
         * The key here is that we don't care about order.
         * For the purposes of this problem, if we want to remove the element at the ith index,
         * we can simply swap the ith element and the last element,
         * and perform an O(1) pop (technically we don't have to swap,
         * we just have to copy the last element into index i because it's popped anyway).
         */
        public boolean remove(int val) {
            boolean contain = locs.containsKey(val);
            if (!contain) {
                return false;
            }
            int loc = locs.get(val).iterator().next();
            locs.get(val).remove(loc);
            // if the location is not last element
            if (loc < nums.size() - 1) {
                // swap the index of ith and last elements
                int lastone = nums.get(nums.size() - 1);
                nums.set(loc, lastone);
                // udpdate the index of last element
                locs.get(lastone).remove(nums.size() - 1);
                locs.get(lastone).add(loc);
            }
            // remove last element: O(1)
            nums.remove(nums.size() - 1);

            // clean up
            if (locs.get(val).isEmpty()) {
                locs.remove(val);
            }
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        // O(1)
        public int getRandom() {
            return nums.get(rand.nextInt(nums.size()));
        }
    }
}