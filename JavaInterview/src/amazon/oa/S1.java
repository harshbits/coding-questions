package amazon.oa;

import java.util.*;

public class S1 {
//    private static List<String> solve(int k, String[] keywords, String[] reviews) {
//        List<String> res = new ArrayList<>();
//        Set<String> set = new HashSet<>(Arrays.asList(keywords));
//        Map<String, Integer> map = new HashMap<>();
//        for(String r : reviews) {
//            String[] strs = r.split("\\W");
//            Set<String> added = new HashSet<>();
//            for(String s : strs) {
//                s = s.toLowerCase();
//                if(set.contains(s) && !added.contains(s)) {
//                    map.put(s, map.getOrDefault(s, 0) + 1);
//                    added.add(s);
//                }
//            }
//        }
//        Queue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>((a, b)->a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
//        maxHeap.addAll(map.entrySet());
//        while(!maxHeap.isEmpty() && k-- > 0) {
//            res.add(maxHeap.poll().getKey());
//        }
//        return res;
//    }

    public static void main(String[] args) {

        List<String> ss = List.of("abc", "XYZ");
        ss.replaceAll(String::toUpperCase);
        System.out.println(ss);


        String s = "abc, i am abc's abc. hello";
        String[] words = s.replaceAll("\\W+", " ").toLowerCase().split("\\s+");

        System.out.println(Arrays.toString(words));

    }

    public ArrayList<String> pp(int topFeatures, List<String> featureRequests, List<String> possibleFeature) {
        // response
        ArrayList<String> topKFeatures = new ArrayList<>();


        Set<String> featureSet = new HashSet<>();

        Map<String, FeatureCount> occourenceCount = new HashMap<>();

        for (String f : featureRequests) {
            String[] words = f.replaceAll("\\W+", " ").toLowerCase().split("\\s+");
            Set<String> set = new HashSet<>();
            for (String w : words) {
                if (featureSet.contains(w) && !set.contains(w)) {
                    FeatureCount fc = occourenceCount.getOrDefault(w, new FeatureCount());
                    fc.feature = w;
                    fc.count += 1;
                    occourenceCount.put(w, fc);
                    set.add(w);
                }
            }
        }

        PriorityQueue<FeatureCount> maxHeap = new PriorityQueue<>();
        maxHeap.addAll(occourenceCount.values());

        while (!maxHeap.isEmpty() && topFeatures-- > 0) {
            topKFeatures.add(maxHeap.poll().feature);
        }
        return topKFeatures;
    }

    private class FeatureCount implements Comparable<FeatureCount> {
        String feature;
        int count = 0;

        @Override
        public int compareTo(FeatureCount o) {
            // if count is same then sort alphabatically
            if (o.count == this.count) {
                return this.feature.compareTo(o.feature);
            }
            return o.count - this.count;
        }
        // getter setter
    }
}
