package google.leetcode_2020;

import java.util.*;

public class GrassHopperPosition {

    public static void main(String[] args) {

    }

    public Map<Integer, Map<Integer, Double>> findProbability(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        Map<Integer, Map<Integer, Double>> map = new HashMap<>();
        map.putIfAbsent(0, new HashMap<>());
        map.get(0).put(root.val, 1.0);
        int level = 0;
        while (!q.isEmpty()) {
            level += 1;
            int size = q.size();
            map.putIfAbsent(level, new HashMap<>());
            while (size-- > 0) {
                Node parent = q.poll();
                double branches = (double) parent.children.size();
                for (Node children : parent.children) {
                    Map<Integer, Double> temp = map.get(level);
                    double prob = (double) (map.get(level - 1).get(parent.val) * (1 / branches));
                    temp.put(children.val, temp.getOrDefault(children.val, 0.0) + prob);
                    q.offer(children);
                }
            }
        }
        return map;
    }

    static class Node {
        int val;
        List<Node> children;

        Node(int val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }
}
