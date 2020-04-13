package facebook.leetcode_2020.union;

import java.util.*;

public class MergeAccounts {

    public static void main(String[] args) {

    }

    // Time Complexity: O(AlogA), where A =∑ai
    // ai is the length of accounts[i]
    // For union by rank=> O(A)
    // O(Aα(A))≈O(A) ; where α is the Inverse-Ackermann function.

    // Space: O(A)
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        if (accounts == null || accounts.size() == 0) {
            return Collections.emptyList();
        }

        int n = accounts.size();
        UnionFind uf = new UnionFind(n);

        // Step 1: traverse all emails except names,
        // Prepare UnionFind
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                // email, currentParent
                uf.union(accounts.get(i).get(j), i);
            }
        }

        // Step 2. traverse all email and find parent for them
        // Name and emails
        Map<Integer, Set<String>> disjointSet = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = uf.find(i);
            disjointSet.putIfAbsent(parent, new HashSet<>());

            Set<String> curSet = disjointSet.get(parent);
            for (int j = 1; j < accounts.get(i).size(); j++) {
                curSet.add(accounts.get(i).get(j));
            }
            disjointSet.put(parent, curSet);
        }

        // Step 3. Convert disjoint Set int merged accounts
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : disjointSet.entrySet()) {
            List<String> curList = new ArrayList<>(entry.getValue());
            Collections.sort(curList);
            // add name as first index
            curList.add(0, accounts.get(entry.getKey()).get(0));
            mergedAccounts.add(curList);
        }
        return mergedAccounts;
    }


    // we do not need any ranks here,
    // since parent is gonna be always the same
    private class UnionFind {

        Map<String, Integer> emailToIndex;

        int size;

        int[] parent;

        int[] rank;

        public UnionFind(int size) {
            this.size = size;
            this.parent = new int[size];
            this.rank = new int[size];
            this.emailToIndex = new HashMap<>();

            for (int i = 0; i < size; i++) {
                // default is 0.
                //rank[i] = 0;
                parent[i] = i;
            }
        }

        // find parent
        public int find(int data) {
            if (parent[data] != data) {
                // Path compression
                parent[data] = find(parent[data]);
            }
            return parent[data];
        }

        public void union(String email, int currentParent) {
            if (emailToIndex.containsKey(email)) {
                int prevParent = emailToIndex.get(email);
                union(prevParent, currentParent);
            } else {
                emailToIndex.put(email, currentParent);
            }
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);

            if (parentX == parentY) {
                return;
            }

            int rankX = rank[parentX];
            int rankY = rank[parentY];

            if (rankX >= rankY) {
                int newRank = rankX == rankY ? rankX + rankY : rankX;
                parent[parentY] = parent[parentX];
                rank[parentX] = newRank;
            } else {
                parent[parentX] = parent[parentY];
            }
        }
    }
}
