package amazon.heap;

import java.util.*;

public class TopKFrequentWords {


    public static void main(String[] args) {

    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> topKWords = new ArrayList<>();
        if (k == 0) {
            return topKWords;
        }

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) ->
                wordCount.get(a).equals(wordCount.get(b)) ? b.compareTo(a) : wordCount.get(a) - wordCount.get(b));

        // maxHeap.addAll(wordCount.keySet());
        for (String word : wordCount.keySet()) {
            maxHeap.offer(word);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        while (!maxHeap.isEmpty()) topKWords.add(0, maxHeap.poll());
        return topKWords;
    }
}
