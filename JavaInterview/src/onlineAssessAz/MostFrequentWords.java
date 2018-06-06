package onlineAssessAz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MostFrequentWords {

	public static void main(String[] args) {

		String literatureText = "Jack and Jill went to the market to buy bread and cheese. "
				+ "Cheese is Jack's and Jill's favorite food.";
		List<String> wordsToExclude = List.of("and", "he", "the", "to", "is", "Jack", "Jill");

		// System.out.println(Arrays.toString(getImprovedWordsArray(literatureText,
		// wordsToExclude)));

		List<String> answer = mostFrequentWords(literatureText, wordsToExclude);

		answer.stream().forEach(System.out::println);

	}

	private static List<String> mostFrequentWords(String literatureText, List<String> wordsToExclude) {
		List<String> answer = new ArrayList<>();

		if (literatureText == null || literatureText.trim().isEmpty()) {
			return answer;
		}

		// Method 1.A
		// Words to exclude into set
		// Set<String> wordsToExcludeSet = wordsToExclude == null ? new HashSet<>()
		// : wordsToExclude.stream().filter(w -> !w.isEmpty()).map(w -> w.toLowerCase())
		// .collect(Collectors.toSet());
		//
		// // Convert literatureText to array.
		// String[] words = getWordsArray(literatureText);

		// Method 2.A
		String[] words = getImprovedWordsArray(literatureText, wordsToExclude);

		Map<String, Integer> map = new HashMap<>();
		Stream.of(words).forEach(s -> {
			map.put(s, map.getOrDefault(s, 0) + 1);
		});

		// Method 1 using Max Heap/Priority Queue
		// With Comparator based on count of the words
		PriorityQueue<Map.Entry<String, Integer>> maxHeap = new PriorityQueue<>(new MaxHeapComparator());

		// Method 2 using sorted tree
		// With Comparator based on count of the words
		SortedSet<Map.Entry<String, Integer>> sortedset = new TreeSet<>(new MaxHeapComparator());

		//
		// map.entrySet().stream().filter(entry ->
		// !wordsToExcludeSet.contains(entry.getKey())).forEach(entry -> {
		// sortedset.add(entry);
		// maxHeap.add(entry);
		// });

		// Method 2.A
		map.entrySet().stream().forEach(entry -> {
			sortedset.add(entry);
			maxHeap.add(entry);
		});

		// Method 1 Answer Calculation
		int max = 0;
		for (int i = 0; i < maxHeap.size(); i++) {
			Map.Entry<String, Integer> maxEntry = maxHeap.poll();
			if (maxEntry.getValue() >= max) {
				max = maxEntry.getValue();
				answer.add(maxEntry.getKey());
			}
		}

		// Method 2 Answer Calculation
		max = 0;
		for (Map.Entry<String, Integer> maxEntry : sortedset) {
			if (maxEntry.getValue() >= max) {
				max = maxEntry.getValue();
				// answer.add(maxEntry.getKey());
			}
		}

		return answer;
	}

	private static String[] getWordsArray(String literatureText) {
		String regex = "[\\p{Punct}]";
		// String regex = "[^a-zA-Z ]";
		String[] words = literatureText.replaceAll("'s", " s").replaceAll(regex, "").toLowerCase().split("\\s+");
		return words;
	}

	private static String[] getImprovedWordsArray(String literatureText, List<String> wordsToExclude) {
		// Map<String, String> tokens = new HashMap<String, String>();
		// // Words to ignore
		// wordsToExclude.stream().forEach(word -> {
		// tokens.put(word, "");
		// });
		// tokens.put("'s", "s");

		// List<String> excludeTokens = new ArrayList<>();
		// if (wordsToExclude != null) {
		// excludeTokens.addAll(wordsToExclude);
		// }
		// excludeTokens.add("'s");

		// Exclude Words Pattern String
		String patternString = (wordsToExclude != null ? "|"
				+ wordsToExclude.stream().map(String::toLowerCase).collect(Collectors.joining("\\b|\\b", "\\b", "\\b"))
				+ "|'s" : "|'s");

		final Pattern pattern = Pattern.compile("[\\p{Punct}&&[^()]]" + patternString);

		Matcher matcher = pattern.matcher(literatureText.toLowerCase());

		// String is immutable, so each replace will create a new string,
		// instead use string buffer.
		StringBuffer sb = new StringBuffer();

		while (matcher.find()) {
			// matcher.appendReplacement(sb, tokens.get(matcher.group(1)));
			matcher.appendReplacement(sb, "");
		}
		matcher.appendTail(sb);

		return new String(sb).trim().split("\\s+");

	}

	public static class MaxHeapComparator implements Comparator<Map.Entry<String, Integer>> {
		@Override
		public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
			if (e1.getValue() != e2.getValue()) {
				return e2.getValue() - e1.getValue();
			} else {
				return e1.getKey().compareToIgnoreCase(e2.getKey());
			}
		}
	}
}
