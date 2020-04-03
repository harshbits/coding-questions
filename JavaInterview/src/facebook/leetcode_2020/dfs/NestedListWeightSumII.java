package facebook.leetcode_2020.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSumII {

    public static void main(String[] args) {
        new NestedListWeightSumII().test();
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


        int ans = depthSumInverse(nestedList);
        System.out.println(ans);
    }

    int flatSum = 0;
    int levelMultiplier = 2;

    // Using math
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int depthSum = dfs(nestedList, 1);
        return levelMultiplier * flatSum - depthSum;
    }

    private int dfs(List<NestedInteger> nestedIntegers, int level) {
        int sum = 0;
        for (NestedInteger ni : nestedIntegers) {
            if (ni.isInteger()) {
                sum += level * ni.getInteger();
                flatSum += ni.getInteger();
            } else {
                sum += dfs(ni.getList(), level + 1);
            }
        }
        levelMultiplier++;
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
