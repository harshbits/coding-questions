package facebook.leetcode_2020.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {
    // Space: O(n); n = total inserts

    private List<Integer> nums;

    // stores the value and it's index in the list
    private HashMap<Integer, Integer> dictionary;

    private Random rand;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        nums = new ArrayList<>();
        dictionary = new HashMap<>();
        this.rand = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    // O(1)
    public boolean insert(int val) {
        if (dictionary.containsKey(val)) {
            return false;
        }

        // value and it's index.
        dictionary.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    // Time: O(1)
    public boolean remove(int val) {

        if (!dictionary.containsKey(val)) {
            return false;
        }

        int index = dictionary.get(val);
        // not the last one than swap the last one with this val
        if (index < nums.size() - 1) {
            int lastone = nums.get(nums.size() - 1);
            nums.set(index, lastone);
            dictionary.put(lastone, index);
        }
        dictionary.remove(val);
        nums.remove(nums.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

