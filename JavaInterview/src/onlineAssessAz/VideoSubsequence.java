package onlineAssessAz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 
 * https://leetcode.com/discuss/interview-question/124652/amazon-onsite-interview-question
 * 
 * Write a function which will partition a sequence of shots into minimal
 * subsequence so that no shot appears in more than one subsequence. The output
 * should be length of each subsequence.
 * 
 * @author hbhavsar
 *
 */
public class VideoSubsequence {

	public static void main(String[] args) {
		
		List<String> inputList = List.of("a", "b", "c");
//		List<String> inputList = List.of("a", "a");
//		List<String> inputList = List.of("a", "b", "a", "b", "c", "b", "a", "c", "a", "d", "e", "f", "e", "g", "d", "e",
//				"h", "i", "j", "h", "k", "l", "i", "j");

		List<Integer> answer = getSubsequenceLength(inputList);

		answer.stream().forEach(System.out::println);

	}

	private static List<Integer> getSubsequenceLength(List<String> inputList) {
		List<Integer> answer = new ArrayList<>();

		// Validations
		if (inputList == null || inputList.size() < 1) {
			return answer;
		}

		// Space = O(N)
		Map<String, Integer> startMap = new HashMap<>();
		// Space = O(N)
		Map<String, Integer> endMap = new HashMap<>();

		// Time = O(n)
		for (int i = 0; i < inputList.size(); i++) {
			String label = inputList.get(i);
			if (!startMap.containsKey(label)) {
				startMap.put(label, i + 1);
				endMap.put(label, i + 1);
			} else {
				if (endMap.containsKey(label)) {
					int value = Math.max(i + 1, endMap.get(label));
					endMap.put(label, value);
				}
			}
		}

		List<Integer> starts = startMap.values().stream().collect(Collectors.toList());
		List<Integer> ends = endMap.values().stream().collect(Collectors.toList());

		// Merge Sort
		// Time = O(LogN)
		Collections.sort(starts);
		// Time = O(LogN)
		Collections.sort(ends);

		int n = starts.size();

//		System.out.println(starts);
//		System.out.println(ends);

		// Time = O(N)
		for (int i = 0, j = 0; i < n; i++) {
			if (i == n - 1 || starts.get(i + 1) > ends.get(i)) {
				int ans = ends.get(i) - starts.get(j) + 1;
				answer.add(ans);
				j = i + 1;
			}
		}

		return answer;
	}
}
