package facebook.leetcode_2020.design;

import java.util.TreeMap;

public class SnapshotArray {

    public static void main(String[] args) {
        SnapshotArray s = new SnapshotArray(3);
        s.set(0, 5);
        System.out.println(s.snap());
        s.set(0, 6);
        System.out.println(s.get(0, 0));
    }

    ////////////////////////////////
    ////////IMPLEMENTATION//////////
    ////////////////////////////////

    private TreeMap<Integer, Integer>[] array;

    private int snapId;

    //Time O(length)
    //Space O(length)
    public SnapshotArray(int length) {
        this.array = new TreeMap[length];
        for (int i = 0; i < length; i++) {
            // initialize
            array[i] = new TreeMap<Integer, Integer>();
            array[i].put(0, 0);
        }
        this.snapId = 0;
    }

    // Time: O(log Snap)
    public void set(int index, int val) {
        array[index].put(snapId, val);
    }

    // Time: O(1)
    public int snap() {
        return snapId++;
    }

    // O(log Snap)
    public int get(int index, int snapId) {
        return array[index].get(snapId);
    }
}
