package onlineAssessAz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * You have been given a task of reordering some data from a log file. Every
 * line in the log file is a space delimited list of strings and all lines begin
 * with an identifier that is alphanumeric. After the identifier, a line will
 * consist of either a list of words using only English letters or only a list
 * of integers. There will be no lines that consist of only an identifier.
 * 
 * Your task is to reorder the data from the log file such that all the lines
 * with words are at the top in the log file. in lexicographical order. Words
 * are ordered lexicographically ignoring the identifier except in the case of
 * ties. In the case of ties (if there are two lines that are identical except
 * for the identifier), the identifier is used to order lexicographically.
 * Alphanumerics should be sorted in ASCII order (numbers come before letters).
 * The identifiers must still be part of the lines in the output Strings. Lines
 * with integers do not need to be sorted relative to other lines with integers.
 * 
 * Write an algorithm to reorder the data in the log file.
 * 
 * The input to the function/method consists of two arguments -
 * 
 * logFileSize: an integer representing the number of lines in the log file,
 * logLines: a list of strings representing the log file.
 * 
 * Output: Return a list of strings representing the reordered log file data.
 * 
 * Note: Identifier consists of only English letters and numbers. The lines with
 * words are not required to match case and the sort needs to be case
 * insensitive.
 * 
 * Example: Input: logFileSize = 5 logLines = [a1 9 2 3 1] [g1 Act car] [zo4 4
 * 7] [abl off KEY dog] [a8 act zoo]
 * 
 * Output: [g1 Act car] [a8 act zoo] [ab1 off KEY dog] [a1 9 2 3 1] [zo4 4 7]
 * 
 * 
 * @author hbhavsar
 *
 */
public class SortLogFiles {

	public static void main(String[] args) {
		int logFileSize = 5;
		// Immutable list
		List<String> logLines = List.of("a1 9 2 3 1", "g1 Act car", "zo4 4 7", "ab1 off KEY dog", "a8 act zoo");

		List<String> answer = orderLogLines(logFileSize, logLines);

		answer.stream().forEach(System.out::println);

	}

	public static List<String> orderLogLines(int logFileSize, List<String> logLines) {

		// Handle edge case scenarios
		if (logLines == null || logLines.size() < 2) {
			return logLines;
		}

		// As it is immutable list passed,

		// Not required for mutable lists.
		List<String> logLinesMut = new ArrayList<>(logLines);

		// Variant of merge sort, Tim Sort Algorithm
		// Timsort is a hybrid stable sorting algorithm,
		// derived from merge sort and insertion sort, designed to perform well on many
		// kinds of real-world data

		// TIME = O(NlogN)
		Collections.sort(logLinesMut, (a, b) -> {
			int i = a.indexOf(" ");
			int j = b.indexOf(" ");
			String temp1 = a.substring(i + 1);
			String temp2 = b.substring(j + 1);
			if (Character.isDigit(a.charAt(i + 1)) && Character.isDigit(b.charAt(j + 1)))
				// return temp1.compareTo(temp2);
				return 0;
			if (Character.isDigit(a.charAt(i + 1)))
				return temp2.compareTo(temp1);
			if (Character.isDigit(b.charAt(j + 1)))
				return temp2.compareTo(temp1);
			if (temp1.equals(temp2))
				return a.substring(0, i).compareTo(b.substring(0, j));
			else
				return temp1.compareTo(temp2);
		});

		return logLinesMut;
	}

}
