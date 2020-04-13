package facebook.leetcode_2020.tree;

import java.util.*;

public class VerticalOrderTraversal {

    public static void main(String[] args) {
        new VerticalOrderTraversal().test();
    }

    private void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        var ans = verticalTraversal(root);
        System.out.println(ans);

        ans = verticalTraversal1(root);
        System.out.println(ans);

    }

    // Time: O(n log n)
    // Space: O(n)
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        if (root == null) {
            return traversal;
        }
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        List<Pair> list = new ArrayList<>();
        dfs(root, 0, 0, heap, list);
        Collections.sort(list);

        //O(n)
//        int prevX = Integer.MAX_VALUE;
//        List<Integer> newList = null;
//        while (!heap.isEmpty()) {
//            Pair pair = heap.poll();
//
//            if (pair.x != prevX) {
//                prevX = pair.x;
//                newList = new ArrayList<>();
//                traversal.add(newList);
//            }
//            // We always add the node's value to the latest report.
//            newList.add(pair.val);
//        }

        // O(n)
        int prevX = Integer.MAX_VALUE;
        List<Integer> newList = null;
        for (Pair pair : list) {
            // If the x value changed, it's part of a new report.
            if (pair.x != prevX) {
                prevX = pair.x;
                newList = new ArrayList<>();
                traversal.add(newList);
            }
            // We always add the node's value to the latest report.
            newList.add(pair.val);
        }

        return traversal;
    }

    private void dfs(TreeNode root, int x, int y, PriorityQueue<Pair> heap, List<Pair> list) {
        if (root == null) {
            return;
        }

        heap.add(new Pair(x, y, root.val));
        list.add(new Pair(x, y, root.val));

        dfs(root.left, x - 1, y + 1, heap, list);
        dfs(root.right, x + 1, y + 1, heap, list);
    }

    private class Pair implements Comparable<Pair> {
        int val;
        int x;
        int y;

        public Pair(int x, int y, int val) {
            this.val = val;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair that) {
            if (this.x == that.x && this.y == that.y) {
                return this.val - that.val;
            }
            if (this.x == that.x) {
                return this.y - that.y;
            }
            return this.x - that.x;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }


    // Time:
    public List<List<Integer>> verticalTraversal1(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        if (root == null) {
            return traversal;
        }

        // First map stores key = x
        // Nested map stores key = y
        // value is key data.
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> verticalData = new TreeMap<>();
        dfs(root, 0, 0, verticalData);

        for (TreeMap<Integer, PriorityQueue<Integer>> data : verticalData.values()) {
            traversal.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : data.values()) {
                List<Integer> list = traversal.get(traversal.size() - 1);
                while (!nodes.isEmpty()) {
                    list.add(nodes.poll());
                }
            }
        }

        return traversal;
    }

    private void dfs(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> verticalData) {
        if (root == null) {
            return;
        }

        // if not initialized x
        if (!verticalData.containsKey(x)) {
            verticalData.put(x, new TreeMap<>());
        }

        // if not initialized y
        if (!verticalData.get(x).containsKey(y)) {
            verticalData.get(x).put(y, new PriorityQueue<>());
        }

        verticalData.get(x).get(y).offer(root.val);

        dfs(root.left, x - 1, y + 1, verticalData);
        dfs(root.right, x + 1, y + 1, verticalData);
    }


    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return Integer.toString(val);
        }
    }
}
