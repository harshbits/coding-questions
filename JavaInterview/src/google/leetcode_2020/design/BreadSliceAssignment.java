package google.leetcode_2020.design;

import java.util.*;

//https://leetcode.com/discuss/interview-question/480256/Google-or-Onsite-or-Find-assignment-of-bread-slice.
/*
In a party of 2^k people. The host has a bread of size 2^k.
Process of assigning a bread is, host divides the bread into half and give left half to one of the person and this is done iteratively till every person has one slice. We have been given a list of pairs and the host which tells us who gives bread to whom. We need to tell the assignment of each slice.
Example. k = 2, size of bread & people is 4.
Bread slice indices: [0,1,2,3].
A, B, C, D. A is the host.
List of input (A, C), (C, B), (A, D)
Here A gives first half to C, C gives left half to B. A gives left half to D.
Ans - (A, 3), (B, 0), (D,2), (C,1)
0... 3 are the indices of bread slice.
Explaination: A initially has (0-3 ) gives to C(0,1). After 1st rnd A(2,3), C(0,1).
C gives to B. B will have 0, C will have 1.
A will give to D. A will have 3. D will have 2.
Whenever the cut happens. Left half is given to other person, keeping the second half.
*/
public class BreadSliceAssignment {
    static class Tuple {
        char first;
        char second;

        Tuple(char f, char s) {
            this.first = f;
            this.second = s;
        }
    }

    public static void main(String[] args) {
        List<Tuple> list = new ArrayList<>();
        list.add(new Tuple('A', 'C'));
        list.add(new Tuple('C', 'B'));
        list.add(new Tuple('A', 'D'));

        assignBread(list, 4);


        // Using BFS

        System.out.println(
                Arrays.toString(
                        sliceAssignment(
                                "A",
                                new String[][]{
                                        {"A", "B"},
                                        {"B", "C"},
                                        {"C", "D"},
                                        {"B", "G"},
                                        {"A", "E"},
                                        {"E", "F"},
                                        {"A", "H"}
                                })));//D C G B F E H A
        System.out.println(
                Arrays.toString(
                        sliceAssignment(
                                "A",
                                new String[][]{
                                        {"A", "C"},
                                        {"C", "B"},
                                        {"A", "D"},
                                })));//B C D A
    }


    public static void assignBread(List<Tuple> list, int numPeople) {
        Map<Character, int[]> map = new HashMap<>();
        int[] bread = new int[numPeople];

        for (int i = 0; i < bread.length; i++) {
            bread[i] = i;
        }
        map.put('A', bread);

        int[] curBread;
        for (Tuple currTuple : list) {

            if (map.containsKey(currTuple.first)) {
                curBread = map.get(currTuple.first);
                int[] leftHalf = new int[curBread.length / 2];
                int[] rightHalf = new int[curBread.length / 2];

                for (int i = 0; i < leftHalf.length; i++) {
                    leftHalf[i] = curBread[i];
                }
                for (int i = 0; i < rightHalf.length; i++) {
                    rightHalf[i] = curBread[curBread.length / 2 + i];
                }
                map.put(currTuple.first, rightHalf);
                map.put(currTuple.second, leftHalf);
            }
        }

        for (Character key : map.keySet()) {
            for (int val : map.get(key)) {
                System.out.println("Person " + key + " has bread: " + val);
            }
        }
    }


    // Using BFS
    static String[] sliceAssignment(String host, String[][] cuts) {
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> namePosition = new HashMap<>();
        for (String[] cut : cuts) {
            for (String name : cut) {
                String other = name.equals(cut[0]) ? cut[1] : cut[0];
                adj.computeIfAbsent(name, n -> new ArrayList<>()).add(other);
            }
        }
        String[] ans = new String[adj.size()];
        ans[adj.size() - 1] = host;
        namePosition.put(host, adj.size() - 1);
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(host);
        while (!queue.isEmpty()) {
            String name = queue.poll();
            for (String next : adj.get(name)) {
                if (namePosition.containsKey(next)) {
                    continue;
                }
                int pos = namePosition.get(name) - (1 << (adj.get(next).size() - 1));
                ans[pos] = next;
                namePosition.put(next, pos);
                queue.offer(next);
            }
        }
        return ans;
    }

}

