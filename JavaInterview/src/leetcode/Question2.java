package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Question2 {

	public static void main(String[] args) {

		List<String> logLines = Arrays.asList("abc 1 4 5 6", "a1 55 78 11 90", "f1 act car", "a8 act zoo",
				"g1 act car");

		int logFileSize = logLines.size();
		List<String> answer = reorderLines(logFileSize, logLines);
		answer.stream().forEach(l -> System.out.println(l));
	}

	public static List<String> reorderLines(int logFileSize, List<String> logLines) {
		List<String> numericEntries = new ArrayList<>();
		List<String> lineList = new ArrayList<>();
		for (int i = 0; i < logFileSize; i++) {
			String line = logLines.get(i);
			int lastIndex = line.lastIndexOf(" ");
			String str = line.substring(lastIndex + 1);
			if (str.replaceAll("\\s+", "").matches("-?\\d+(\\.\\d+)?")) {
				numericEntries.add(line);
			} else {
				lineList.add(line);
			}
		}

		Collections.sort(lineList, new AmazonLexicoComparator());
		// Add numeric entries in natural order
		lineList.addAll(numericEntries);
		return lineList;
		// WRITE YOUR CODE HERE
	}
}

class AmazonLexicoComparator implements Comparator<String> {
	@Override
	public int compare(String o1, String o2) {
		int index1 = o1.indexOf(" ");
		String id1 = o1.substring(0, index1);
		String str1 = o1.substring(index1 + 1);
		int index2 = o2.indexOf(" ");
		String id2 = o1.substring(0, index2);
		String str2 = o2.substring(index2 + 1);
		if (str1.compareTo(str2) == 0) {
			return id1.compareTo(id2);
		}
		return str1.compareTo(str2);
	}
}