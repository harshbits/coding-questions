package amazon.onsite;

public class AlienDictionary {

	
	public static void main(String[] args) {
		String[] words = { "caa", "aaa", "aab" };
		printOrder(words, words.length);

	}
	
	private static void printOrder(String[] words, int alpha) {

		TopologicalSort graph = new TopologicalSort(alpha);

		for (int i = 0; i < words.length - 1; i++) {

			// String word1 = words[i];
			// String word2 = words[i + 1];
			char[] word1 = words[i].toCharArray();
			char[] word2 = words[i + 1].toCharArray();

			// for (int j = 0; j < Math.min(word1.length(), word2.length()); j++) {
			// if(word1.charAt(j) != word2.charAt(j)) {
			// graph.addEdge(word1.charAt(j) - 'a', word2.charAt(j) - 'a');
			// break;
			// }
			// }

			for (int j = 0; j < Math.min(word1.length, word2.length); j++) {
				if (word1[j] != word2[j]) {
					graph.addEdge(word1[j] - 'a', word2[j] - 'a');
					break;
				}
			}
		}
		
		// Print topological sort of the above created graph
        graph.topologicalSort();
	}
	 
}
