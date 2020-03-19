package google.leetcode_2020.disjoint;

import java.util.HashMap;
import java.util.Map;

public class DisjointSet {

    // count total nodes
    int n;

    // total disjoint sets
    int totalDisjointSet;

    // O(n) space
    private Map<Integer, Node> map = new HashMap<>();


    public DisjointSet() {
        super();
        this.n = 0;
        this.totalDisjointSet = 0;
    }

    public DisjointSet(int n) {
        super();
        this.n = 0;
        this.totalDisjointSet = 0;
        for (int i = 0; i < n; i++) {
            makeSet(i);
        }
    }


    class Node {
        int data;
        int rank;
        Node parent;

        public Node(int data) {
            this.data = data;
            // default rank = 0
            this.rank = 0;
            //  default point to self
            this.parent = this;
        }
    }

    public void makeSet(int data) {
        Node node = new Node(data);
        map.put(data, node);
        this.n++;
        this.totalDisjointSet++;
    }

    public void union(int data1, int data2) {

        Node node1 = map.get(data1);
        Node node2 = map.get(data2);

        Node parent1 = findSet(node1);
        Node parent2 = findSet(node2);

        // since both are pointing to same parent.
        if (parent1.data == parent2.data) {
            return;
        }

        // merging 2 nodes
        this.totalDisjointSet--;

        // change the parent based on the rank of the parent
        if (parent1.rank >= parent2.rank) {
            // increment rank only if the both sets have same rank

            // we will make parent1 as parent for all points
            parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank + 1 : parent1.rank;
            parent2.parent = parent1;
        } else {
            // do not change rank as 2 is already higher
            // make parent2 as representative of whole set
            parent1.parent = parent2;
        }
    }

    public int findSet(int data) {
        return findSet(map.get(data)).data;
    }

    // find set recursively and do path compression
    // do not expose public
    private Node findSet(Node node) {
        Node parent = node.parent;
        if (parent == node) {
            return parent;
        }

        // assignment is doing path compression
        node.parent = findSet(node.parent);
        return node.parent;
    }


    public static void main(String[] args) {

        DisjointSet ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        // all should return 1
        System.out.println(ds.findSet(1));
        System.out.println(ds.findSet(2));
        System.out.println(ds.findSet(3));
        System.out.println(ds.findSet(4));
        System.out.println(ds.findSet(5));
        System.out.println(ds.findSet(6));
        System.out.println(ds.findSet(7));

        System.out.println("total n: " + ds.n);
        System.out.println("total disjoint set : " + ds.totalDisjointSet);
    }

}
