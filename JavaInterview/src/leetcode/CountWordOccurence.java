package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountWordOccurence {

	public List<String> retrieveMostFrequentlyUsedWords(String literatureText, List<String> wordsToExclude) {

		List<String> answer = new ArrayList<>();

		if (literatureText == null || literatureText.trim().isEmpty()) {
			return answer;
		}

		// Convert literatureText to array.
		String[] words = getAllWords(literatureText);

		Set<String> wordsToExcludeSet = wordsToExclude == null ? new HashSet<>()
				: wordsToExclude.stream().filter(w -> !w.isEmpty()).map(w -> w.toLowerCase())
						.collect(Collectors.toSet());

		// Insert all words into a hashmap
		Map<String, Long> countedWords = Arrays.stream(words).filter(w -> !wordsToExcludeSet.contains(w))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		// Traverse through map to find the candidate
		// with maximum votes.
		Long maxValueInMap = 0L;

		// Iterate over the counted words
		for (Map.Entry<String, Long> entry : countedWords.entrySet()) {
			String key = entry.getKey();
			Long val = entry.getValue();
			// If greater than the value
			if (val > maxValueInMap) {
				maxValueInMap = val;
				// Initialize again
				answer = new ArrayList<>();
				answer.add(key);
			} else if (val == maxValueInMap) {
				// If count is same.
				answer.add(key);
			}
		}
		return answer;
	}

	private String[] getAllWords(String literatureText) {
		String regex = "[\\p{Punct}]";
		// String regex = "[^a-zA-Z ]";
		String[] words = literatureText.replaceAll("'s", " s").replaceAll(regex, "").toLowerCase().split("\\s+");
		return words;
	}

	// Driver code
	public static void main(String[] args) {

		String literatureText = "Jack and jill went to the market to buy bread and cheese. Cheese is Jack's and Jill's favorite food.";

		// String[] words = new CountWordOccurence().getAllWords(literatureText);

		// System.out.println(Arrays.toString(words));

		List<String> wordsToExclude = new ArrayList<>();
		wordsToExclude.add("and");
		wordsToExclude.add("he");
		wordsToExclude.add("the");
		wordsToExclude.add("to");
		wordsToExclude.add("is");
		wordsToExclude.add("Jack");
		wordsToExclude.add("Jill");

		List<String> ans = new CountWordOccurence().retrieveMostFrequentlyUsedWords(literatureText, wordsToExclude);

		System.out.println(ans);
	}
}
