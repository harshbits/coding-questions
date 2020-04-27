package facebook.leetcode_2020.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSum {

    public static void main(String[] args) {
        new NestedListWeightSum().test();
    }

    private void test() {
        // [1,[4,[6]]]
        List<NestedInteger> nestedList = new ArrayList<>();
        NestedInteger ni = new NestedInteger(1);
        nestedList.add(ni);

        NestedInteger ni1 = new NestedInteger(2);
        ni.add(ni1);

        NestedInteger ni2 = new NestedInteger(6);
        ni1.add(ni2);

        int ans = depthSum(nestedList);
        System.out.println(ans);
    }


    // BFS
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return 0;
        }

        // bfs
        int sum = 0;
        int level = 1;
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);

        // level order traversal;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                NestedInteger ni = queue.poll();
                if (ni.isInteger()) {
                    sum += level * ni.getInteger();
                } else {
                    queue.addAll(ni.getList());
                }
            }

            level++;
        }

        return sum;
    }


    public int depthSumDFS(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> nestedIntegers, int level) {
        int sum = 0;
        for (NestedInteger ni : nestedIntegers) {
            if (ni.isInteger()) {
                sum += level * ni.getInteger();
            } else {
                sum += dfs(ni.getList(), level + 1);
            }
        }

        return sum;
    }


    public class NestedInteger {

        Integer value;

        List<NestedInteger> nestedList;

        // Constructor initializes an empty nested list.
        public NestedInteger() {
            super();
        }

        // Constructor initializes a single integer.
        public NestedInteger(int value) {
            this.value = value;
        }

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return value != null;
        }

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return value;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {
            this.value = value;
        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {
            if (nestedList == null) {
                nestedList = new ArrayList<>();
            }
            nestedList.add(ni);
        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return nestedList;
        }
    }
}
