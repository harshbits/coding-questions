package google.leetcode.string;

/**
 * 
 * Given a rows x cols screen and a sentence represented by a list of non-empty
 * words, find how many times the given sentence can be fitted on the screen.
 * 
 * Note:
 * 
 * A word cannot be split into two lines. The order of words in the sentence
 * must remain unchanged. Two consecutive words in a line must be separated by a
 * single space. Total words in the sentence won't exceed 100. Length of each
 * word is greater than 0 and won't exceed 10. 1 ≤ rows, cols ≤ 20,000. Example
 * 1:
 * 
 * Input: rows = 2, cols = 8, sentence = ["hello", "world"]
 * 
 * Output: 1
 * 
 * Explanation: hello--- world---
 * 
 * The character '-' signifies an empty space on the screen. Example 2:
 * 
 * Input: rows = 3, cols = 6, sentence = ["a", "bcd", "e"]
 * 
 * Output: 2
 * 
 * Explanation: a-bcd- e-a--- bcd-e-
 * 
 * The character '-' signifies an empty space on the screen. Example 3:
 * 
 * Input: rows = 4, cols = 5, sentence = ["I", "had", "apple", "pie"]
 * 
 * Output: 1
 * 
 * Explanation: I-had apple pie-I had--
 * 
 * The character '-' signifies an empty space on the screen.
 * 
 * @author hbhavsar
 *
 */
public class SentenceScreenFitting418 {

	public static void main(String[] args) {
		SentenceScreenFitting418 s = new SentenceScreenFitting418();
		// int rows = 4;
		// int cols = 5;
		// String[] sentence = { "I", "had", "apple", "pie" };

		int rows = 3;
		int cols = 6;
		String[] sentence = { "a", "bcd", "e" };
		int ans = s.wordsTyping(sentence, rows, cols);
		System.out.println(ans);

	}

	/**
	 * 
	 * 
	 * @param sentence
	 * @param rows
	 * @param cols
	 * @return
	 */
	public int wordsTyping(String[] sentence, int rows, int cols) {
		// length of the sentence
		int n = sentence.length;
		// initialize dp to store how many words can fit at ith row for dp
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			int length = 0;
			int words = 0;
			int index = i;

			while (length + sentence[index % n].length() <= cols) {

				length += sentence[index % n].length();
				// space length added
				length += 1;

				index++;
				words++;
			}
			// total number of words fitted in the first row
			dp[i] = words;
		}

		int words = 0;

		for (int i = 0, index = 0; i < rows; i++) {
			words += dp[index];
			// get the start of the next row
			index = (dp[index] + index) % n;
		}
		// total words fitted in the screen
		return words / n;
	}

	// Brute Force
	// Time limit exceeded
	public int wordsTypingBruteForce(String[] sentence, int rows, int cols) {
		int wordIndex = 0;
		int count = 0;
		int currentRowSize = cols;
		int currentWordLength = sentence[wordIndex].length();
		// System.out.println(currentWordLength);
		for (int i = 0; i < rows; i++) {
			while (currentRowSize >= currentWordLength) {
				if (currentRowSize == currentWordLength) {
					currentRowSize = 0;
				} else {
					currentRowSize = currentRowSize - (currentWordLength + 1);
				}

				if (++wordIndex == sentence.length) {
					wordIndex = 0;
					count++;
				}
				currentWordLength = sentence[wordIndex].length();
				// System.out.println(currentWordLength);
			}
			currentRowSize = cols;
		}
		return count;
	}
}
